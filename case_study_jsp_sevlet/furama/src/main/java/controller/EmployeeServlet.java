package controller;

import bo.EmployeeBO;
import bo.EmployeeBOImpl;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "EmployeeServlet", urlPatterns = {"", "employee"})
public class EmployeeServlet extends javax.servlet.http.HttpServlet {
    EmployeeBO employeeBO= new EmployeeBOImpl();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action= request.getParameter("action");
        if (action == null){
            action="";
        }
        switch (action){

        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action= request.getParameter("action");
        if (action== null){
            action="";
        }
        switch (action){
            default:showEmployee(request,response);
        }
    }

    private void showEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = employeeBO.findAll();
        request.setAttribute("employeeList", employees);
        try {
            request.getRequestDispatcher("furama/employee.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
