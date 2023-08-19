package com.register;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowData extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ShowData</title>"); 
            out.println("<style>body {\n" +
"                background-color: graytext; \n" +
"            }</style>");
            out.println("</head>");
            
            
            out.println("<body>");
            
            out.println("<table align=\"center\" cellpadding=\"5\" cellspacing=\"5\" border=\"1\">");
            out.println("<tr bgcolor=\"#A52A2A\">");
            out.println("<td><b>Student Name</b></td>");
            out.println("<td><b>Student RollNo</b></td>");
            out.println("<td><b>Student Password</b></td>");
            out.println("<td><b>Student Email</b></td>");
            out.println("<td><b>Student Gender</b></td>");
            out.println("<td><b>Student Cource</b></td>");
            
            try{
                Conn con=new Conn();
                Connection connection=con.getConnection();
                PreparedStatement p = connection.prepareStatement("select * from student_servlet");
                ResultSet set = p.executeQuery();
                    
                while(set.next()){
                    out.println("<tr bgcolor=\"#DEB887\">");
                    out.print("<td>"+set.getString("name")+"</td>");
                    out.print("<td>"+set.getString("roll")+"</td>");
                    out.print("<td>"+set.getString("pass")+"</td>");
                    out.print("<td>"+set.getString("email")+"</td>");
                    out.print("<td>"+set.getString("gender")+"</td>");
                    out.print("<td>"+set.getString("course")+"</td>");
                    out.println("</tr>");    
                }
                }catch(Exception e){
                    e.printStackTrace();
                }

            out.println("</table>");
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
