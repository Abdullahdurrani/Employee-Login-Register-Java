

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/index"})
public class index extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            if(request.getParameter("btnRegister") != null){
                response.sendRedirect("EmployeeForm.html");
            }
            if(request.getParameter("btnLogin") != null){
                response.sendRedirect("Login.html");
            }
        } catch(Exception ex) {
            
        }
    }

}
