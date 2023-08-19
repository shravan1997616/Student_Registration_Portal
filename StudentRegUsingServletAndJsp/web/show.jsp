
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="student.Conn" %> 
<%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show student details</title>
        <style>
            body {
                background-color: graytext; 
            }
        </style>
    </head>
    <body>
        <table align="center" cellpadding="5" cellspacing="5" border="1">
            <tr>

            </tr>
            <tr bgcolor="#A52A2A">
                <td><b>Student Name</b></td>
                <td><b>Student Roll no</b></td>
                <td><b>Student Password</b></td>
                <td><b>Student Email</b></td>
                <td><b>Student Gender</b></td>
                <td><b>Student Course</b></td>
            </tr>
            <%
                try{
                    Conn con=new Conn();
                    Connection connection=con.getConnection();
                    PreparedStatement p = connection.prepareStatement("select * from student_servlet");
                    ResultSet set = p.executeQuery();
                    
                    while(set.next()){
                        %>

                        <tr bgcolor="#DEB887">

                            <td><%=set.getString("name") %></td>
                            <td><%=set.getString("roll") %></td>
                            <td><%=set.getString("pass") %></td>
                            <td><%=set.getString("email") %></td>
                            <td><%=set.getString("gender") %></td>
                            <td><%=set.getString("course") %></td>

                        </tr>

                        <%  
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            %>
        </table>
    </body>
</html>
