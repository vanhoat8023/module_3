package controller;

import bo.EmployeeBO;
import bo.EmployeeBOImpl;
import model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = {"", "/employee"})
public class EmployeeServlet extends HttpServlet {
    EmployeeBO employeeBO= new EmployeeBOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
        if (action == null){
            action="";
        }
        switch (action){
            case "listEmployee":
                showEmployee(request, response);
                break;
            case  "edit":
                updateEmployee(request,response);
                break;
            case "create":
                createEmployee(request,response);
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id_cr"));
        String name = request.getParameter("1");
        String birthday = request.getParameter("2");
        String salary = request.getParameter("3");
        String phone = request.getParameter("4");
        String email = request.getParameter("5");
        String address = request.getParameter("6");
        String id_card = request.getParameter("7");
        employeeBO.save(new Employee(id,name,birthday,salary,phone,email,address,id_card));
        showEmployee(request,response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("a");
        String birthday = request.getParameter("b");
        String salary = request.getParameter("c");
        String phone = request.getParameter("d");
        String email = request.getParameter("e");
        String address = request.getParameter("f");
        String id_card = request.getParameter("g");
        employeeBO.update(new Employee(id,name,birthday,salary,phone,email,address,id_card));
        showEmployee(request,response);
    }

    private void showEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employee =employeeBO.findAll();
        request.setAttribute("listEmployee", employee);
        try {
            request.getRequestDispatcher("/furama/listEmployee.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
        if (action== null){
            action="";
        }
        switch (action){
            case "create":
                showCreateEmployee(request,response);
            case "listEmployee":
                showListEmployee(request, response);
                break;
            case "edit":
                showEditEmployee(request, response);
                break;
            default:employee(request,response);
        }
    }

    private void showCreateEmployee(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/furama/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList =employeeBO.findAll();
        request.setAttribute("listEmployee",employeeList);
        RequestDispatcher dispatcher= request.getRequestDispatcher("/furama/listEmployee.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee= employeeBO.findById(id);
        request.setAttribute("employee",employee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/furama/editEmployee.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void employee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employees = employeeBO.findAll();
        request.setAttribute("employeeList", employees);
        try {
            request.getRequestDispatcher("furama/indexEmployee.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
