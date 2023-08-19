
package student;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author shrav
 */
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

