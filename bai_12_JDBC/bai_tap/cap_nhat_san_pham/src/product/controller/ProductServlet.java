package product.controller;

import product.bo.ProductBO;
import product.bo.ProductBOImpl;
import product.model.Product;

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
         //       createProduct(request, response);
                break;
            case "update":
                break;
            default:
                showProductList(request, response);
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
        String acion = request.getParameter("action");

        if(acion == null){
            acion = "";
        }
        switch (acion) {
            case "create":
         //       showCreateForm(request, response);
                break;
            case "view":
                break;
            case "update":
                break;
            case "delete":
                break;
            default:
                showProductList(request, response);
        }
    }
}
