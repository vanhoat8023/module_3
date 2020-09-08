package controller;


import bo.customer_bo.CustomerBO;
import bo.customer_bo.CustomerBOImpl;
import model.Customer;
import model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customer"})
public class CustomerServlet extends HttpServlet {
    CustomerBO customerBO = new CustomerBOImpl() {
    };
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action){
            case "create":
                createCustomer(request,response);
                break;
            case "edit":
                updateCustomer(request,response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id1"));
        customerBO.remove(id);
        showListCustomer(request,response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("a");
        String birthday = request.getParameter("b");
        String gender = request.getParameter("c");
        String id_card = request.getParameter("d");
        String phone = request.getParameter("e");
        String email = request.getParameter("f");
        String address = request.getParameter("g");
        customerBO.update(new Customer(id,name,birthday,gender,id_card,phone,email,address));
        showListCustomer(request,response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id_cr"));
        String name = request.getParameter("1");
        String birthday = request.getParameter("2");
        String gender = request.getParameter("3");
        String phone = request.getParameter("4");
        String email = request.getParameter("5");
        String address = request.getParameter("6");
        String id_card = request.getParameter("7");
        if (customerBO.validateMKH(name)){
            customerBO.save(new Customer(id,name,birthday,gender,id_card,phone,email,address));
            showListCustomer(request,response);
        }else {
            String error="nhap sai ban hay nhap lai!";
            request.setAttribute("error",error);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/furama/customer/createCustomer.jsp");
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
            case "listCustomer":
                showListCustomer(request,response);
                break;
            case "create":
                showCreateEmployee(request,response);
                break;
            case "edit":
                showEditCustomer(request,response);
                break;
            case "delete":
                showDelete(request,response);
                break;
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer=customerBO.findById(id);
        request.setAttribute("customer",customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/furama/customer/delete.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerBO.findById(id);
        request.setAttribute("customer",customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/furama/customer/editCustomer.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateEmployee(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/furama/customer/createCustomer.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerBO.findAll();
        request.setAttribute("listCustomer",customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/furama/customer/listCustomer.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
