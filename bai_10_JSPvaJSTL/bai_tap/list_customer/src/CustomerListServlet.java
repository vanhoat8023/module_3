import model.CustomerList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "CustomerListServlet", urlPatterns = "show")
public class CustomerListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerList>customerList = new ArrayList<>();
        String img = "<img src=\trang.jpg\" height=\"50\" width=\"50\">";
        customerList.add(new CustomerList("Le Hoat", "1997-3-16", "Quang Binh", img));
        customerList.add(new CustomerList("Le Tuan", "1997-3-9", "Quang Binh", img));
        customerList.add(new CustomerList("Nguyen Nhung", "1997-10-16", "Quang Binh", img));
        customerList.add(new CustomerList("Le Trang", "1997-10-20", "Quang Binh", img));
        customerList.add(new CustomerList("Nguyen A", "1998-04-20", "Quang Tri", img));

        request.setAttribute("CustomerListServlet", customerList);

        request.getRequestDispatcher("Customer.jsp").forward(request, response);
    }

}
