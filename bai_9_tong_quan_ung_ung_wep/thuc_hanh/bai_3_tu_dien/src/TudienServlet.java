import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Tu-dienServlet", urlPatterns = "/traTuDien")
public class TudienServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> tu_dien = new HashMap<>();
        tu_dien.put("hello", "Xin chào");
        tu_dien.put("how", "Thế nào");
        tu_dien.put("book", "Quyển vở");
        tu_dien.put("computer", "Máy tính");

        String search = request.getParameter("txtSearch");

        PrintWriter writer = response.getWriter();
        writer.println("<html>");

        String result = tu_dien.get(search);
        if(result != null){
            writer.println("Word: " + search);
            writer.println("Result: " + result);
        } else {
            writer.println("Not found");
        }

        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
