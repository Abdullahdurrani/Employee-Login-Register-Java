
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/Home"})
public class Home extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.println("<html><body>");
            HttpSession session = request.getSession();

            if (session.getAttribute("uname") == null) {
                response.sendRedirect("Login.html");
            } else {
                Employee e = new Employee();
                e.username = session.getAttribute("uname").toString();
                e.password = session.getAttribute("pass").toString();
                EmployeeDAO dao = new EmployeeDAO();
                ResultSet rs = dao.Login(e);
                out.print("<table width=20% border=1 style=\"margin: auto\">");
                out.print("<center><h1>Employee:</h1></center>");
                if (rs.next()) {
                    out.print("<tr>");
                    out.print("<th>" + "ID" + "</th>");
                    out.print("<td>" + rs.getInt("id") + "</td></tr>");
                    out.print("<tr><th>" + "Name" + "</th>");
                    out.print("<td>" + rs.getString("name") + "</td></tr>");
                    out.print("<tr><th>" + "CNIC" + "</th>");
                    out.print("<td>" + rs.getString("cnic") + "</td></tr>");
                    out.print("<tr><th>" + "Username" + "</th>");
                    out.print("<td>" + rs.getString("username") + "</td></tr>");
                    out.print("<tr><th>" + "Password" + "</th>");
                    out.print("<td>" + rs.getString("password") + "</td></tr>");
                    out.print("<tr><th>" + "Email" + "</th>");
                    out.print("<td>" + rs.getString("email") + "</td></tr>");
                }
                out.print("</table>");
                out.println("<a href='Update.html' style = 'margin-left: 30%' \">Update</a>");              
            }
            out.println("</body></html>");
        } catch (Exception ex) {

        }
    }

}
