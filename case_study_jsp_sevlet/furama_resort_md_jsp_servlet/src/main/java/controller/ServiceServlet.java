package controller;

import bo.service_bo.ServiceBO;
import bo.service_bo.ServiceBOImpl;
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

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "listService":
                showListService(request,response);
                break;
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
