package controller;

import bo.service_bo.ServiceBO;
import bo.service_bo.ServiceBOImpl;
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

@WebServlet(name = "ServiceServlet", urlPatterns = {"/service"})
public class ServiceServlet extends HttpServlet {
    ServiceBO serviceBO = new ServiceBOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("create")){
            createService(request,response);
        }
    }

    private void createService(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id_cr"));
        String name = request.getParameter("1");
        String area = request.getParameter("2");
        String cost = request.getParameter("3");
        String max_people = request.getParameter("4");
        String standardRoom = request.getParameter("5");
        String descriptionOtherConvenience = request.getParameter("6");
        String poolArea = request.getParameter("7");
        String numberOfFloors = request.getParameter("8");
        if (serviceBO.validateMKH(name)){
            serviceBO.save(new Service(id,name,area,cost,max_people,standardRoom,descriptionOtherConvenience,poolArea,numberOfFloors));
            showListService(request,response);
        }else {
            String error = "ban nhap sai! hay nhap lai!";
            request.setAttribute("error", error);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/furama/service/create.jsp");
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "listService":
                showListService(request,response);
                break;
            case "create":
                showCreateService(request,response);
        }
    }

    private void showCreateService(HttpServletRequest request, HttpServletResponse response) {
    RequestDispatcher dispatcher = request.getRequestDispatcher("/furama/service/create.jsp");
    try {
        dispatcher.forward(request,response);
    } catch (ServletException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

    private void showListService(HttpServletRequest request, HttpServletResponse response) {
        List<Service> services =serviceBO.findAll();
        request.setAttribute("listService",services);
        RequestDispatcher dispatcher= request.getRequestDispatcher("/furama/service/listService.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
