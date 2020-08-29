import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/result")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Float first = Float.parseFloat(request.getParameter("first-operator"));
        Float second = Float.parseFloat(request.getParameter("second-operator"));
        String operator = request.getParameter("operator");
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        if (operator.equals("+")){
            Float result=first+second;
            request.setAttribute("id",result);
        }else if (operator.equals("-")){
            Float result=first-second;
            request.setAttribute("id", result);
        }else if (operator.equals("*")){
            Float result=first*second;
            request.setAttribute("id", result);
        }else if (operator.equals("/")){
            if (second==0){
                request.setAttribute("id", "fail");
            }else{
                Float result=first/second;
                request.setAttribute("id", result);
            }
        }
        dispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
