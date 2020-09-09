package controller;

import bo.contract_bo.Contract_BO;
import bo.contract_bo.Contract_BOImpl;
import model.Contract;
import model.Employee;
import model.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = {"/contract"})
public class ContractServlet extends HttpServlet {
    Contract_BO contract_bo = new Contract_BOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("create")){
            createContract(request,response);
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id_cr"));
        String startDate = request.getParameter("1");
        String endDate = request.getParameter("2");
        String deposit = request.getParameter("3");
        String totalMoney = request.getParameter("4");
        contract_bo.save(new Contract(id,startDate,endDate,deposit,totalMoney));
        showListContract(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("listContract")){
            showListContract(request,response);
        }else if (action.equals("create")){
            showCreateContract(request,response);
        }
    }

    private void showCreateContract(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/furama/contract/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListContract(HttpServletRequest request, HttpServletResponse response) {
        List<Contract> contracts =contract_bo.findAll();
        request.setAttribute("listContract",contracts);
        RequestDispatcher dispatcher= request.getRequestDispatcher("/furama/contract/listContract.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
