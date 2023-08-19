
package com.register;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
    private static Connection con;
    public static Connection getConnection(){
        try{
            if(con == null){
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_info","root","root");
                System.out.println("student.Conn.getConnection()");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return con;
    }
}

//create table student_servlet(name varchar(50),roll varchar(50) not null primary key,pass varchar(50),email varchar(50),gender varchar(10),course varchar(10));