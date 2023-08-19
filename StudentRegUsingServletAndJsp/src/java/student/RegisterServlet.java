package student;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
        
            out.println("<h2>Welcome to Register servlet</h2>");
        
            String name=request.getParameter("user_name");
            String roll=request.getParameter("user_roll");
            String password=request.getParameter("user_password");
            String email=request.getParameter("user_email");
            String gender=request.getParameter("user_gender");
            String course=request.getParameter("user_course");

            String cond=request.getParameter("condition");
            if(cond!=null){
                if(cond.equals("checked")){
                    out.println("<h2> Name : "+ name +"</h2>");
                    out.println("<h2> Roll no : "+ roll +"</h2>");
                    out.println("<h2> Password : "+ password +"</h2>");
                    out.println("<h2> Email : "+ email +"</h2>");
                    out.println("<h2> Gender : "+ gender +"</h2>");
                    out.println("<h2> Course : "+ course +"</h2>");

                    try{
                        Conn ob=new Conn();
                        Connection con=ob.getConnection();
                        Statement st = con.createStatement();
                        st.executeUpdate("insert into student_servlet values('"+name+"','"+roll+"','"+password+"','"+email+"','"+gender+"','"+course+"')");
                        response.sendRedirect("index.html");
                    }catch(Exception e){
                        out.println(e);
                    }
                }else{
                    out.println("<h2>You have not accepted terms and conditions</h2>");
                }
            }else{
                out.println("<h2>You have not accepted terms and conditions</h2>");
                RequestDispatcher rd=request.getRequestDispatcher("index.html");

                rd.include(request, response);
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
