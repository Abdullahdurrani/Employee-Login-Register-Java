

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(urlPatterns = {"/EmployeeLogin"})
public class EmployeeLogin extends HttpServlet {

    
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            Employee e = new Employee();
            e.username = request.getParameter("t1");
            e.password = request.getParameter("t2");

            EmployeeDAO dao = new EmployeeDAO();
                        
            ResultSet rs = dao.Login(e);
                       
            if(rs.next()){
                
                HttpSession session = request.getSession();
                session.setAttribute("uname", e.username);
                session.setAttribute("pass", e.password);
                response.sendRedirect("Home");
            }
            else {
                response.sendRedirect("Login.html");
            }
            
        } catch(Exception ex) {
            System.out.println(ex.toString());
        }
    }

}
