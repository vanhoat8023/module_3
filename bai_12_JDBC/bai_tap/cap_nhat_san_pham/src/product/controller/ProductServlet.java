package product.controller;

import product.bo.ProductBO;
import product.bo.ProductBOImpl;
import product.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = {"","/product"})
public class ProductServlet extends HttpServlet {
    ProductBO productBO=new ProductBOImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "update":
                updateProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            default:
                showProductList(request, response);
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));

        //delete element from element list
        this.productBO.remove(id);

        showProductList(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("a");
        String address=request.getParameter("b");
        int id=Integer.parseInt(request.getParameter("id"));
        productBO.update(new Product(id,name,address));
        showProductList(request,response);
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        String a=request.getParameter("a");
        String b=request.getParameter("b");
        int id=productBO.nextId();
        Product product=new Product(id,a,b);
        productBO.save(product);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/product/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showProductList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList =  productBO.findAll();
        request.setAttribute("productListServlet", productList);
        try {
            request.getRequestDispatcher("/product/list.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action == null){
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditProduct(request,response);
                break;
            case "delete":
                showDeleteProduct(request,response);
                break;
            default:
                showProductList(request, response);
        }
    }

    private void showDeleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        Product product=productBO.findById(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/product/delete.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditProduct(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        Product product=productBO.findById(id);
        request.setAttribute("product", product);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/product/edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher= request.getRequestDispatcher("/product/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
