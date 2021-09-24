
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/ViewRecords"})
public class ViewRecords extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            EmployeeDAO dao = new EmployeeDAO();
            ArrayList<Employee> list = dao.SelectAll();

            out.println("<table><tr>");
            out.println("<th>ID</th><th>Name</th><th>CNIC</th><th>USERNAME</th><th>PASSWORD</th><th>EMAIL</th>");

            for (Employee e : list) {
                out.println("<tr><td>" + e.id + "</td>"
                        + "<td>" + e.name + "</td>"
                        + "<td>" + e.cnic + "</td>"
                        + "<td>" + e.username + "</td>"
                        + "<td>" + e.password + "</td>"
                        + "<td>" + e.email + "</td>"
                );
            }
            out.println("</table>");
        }
    }

}
