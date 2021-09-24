
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/Update"})
public class Update extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Employee e = new Employee();
            e.id = Integer.parseInt(request.getParameter("t1"));
            e.name = request.getParameter("t2");
            e.cnic = Integer.parseInt(request.getParameter("t3"));
            e.username = request.getParameter("t4");
            e.password = request.getParameter("t5");
            e.email = request.getParameter("t6");
            EmployeeDAO dao = new EmployeeDAO();
            int res = dao.Update(e);
            if (res > 0) {
                HttpSession session = request.getSession();
                session.setAttribute("uname", e.username);
                session.setAttribute("pass", e.password);
                response.sendRedirect("Home");
            }
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }

}
