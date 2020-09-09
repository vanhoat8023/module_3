package controller;

import bo.contractDetail_bo.Contract_detail_BO;
import bo.contractDetail_bo.Contract_detail_BOImpl;
import model.Contract;
import model.ContractDetail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractDetailServlet", urlPatterns = {"/detail"})
public class ContractDetailServlet extends HttpServlet {
    Contract_detail_BO contract_detail_bo = new Contract_detail_BOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("create")){
            createContractDetail(request,response);
        }
    }

    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id_cr"));
        int quantity = Integer.parseInt(request.getParameter("1"));
        contract_detail_bo.save(new ContractDetail(id,quantity));
        showListContractDetail(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("listContract")){
            showListContractDetail(request,response);
        }else if (action.equals("create")){
            showCreateContract(request,response);
        }
    }

    private void showCreateContract(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/furama/ctDetail/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListContractDetail(HttpServletRequest request, HttpServletResponse response) {
        List<ContractDetail> contractDetails =contract_detail_bo.findAll();
        request.setAttribute("listDetail",contractDetails);
        RequestDispatcher dispatcher= request.getRequestDispatcher("/furama/ctDetail/listDetail.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
