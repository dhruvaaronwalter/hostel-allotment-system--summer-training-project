/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dhruv
 */
public class delstud extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            /* TODO output your page here. You may use following sample code. */
            String sname=request.getParameter("sname");
            String enrollno=request.getParameter("enrollno");
            
            Class.forName("com.mysql.jdbc.Driver");
  	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","123");
            Statement stmt=con.createStatement();
            
            ResultSet rs=stmt.executeQuery("select * from student where sname='"+sname+"' and enrollno='"+enrollno+"'");
           
            
            if(rs.next())
            {String r=rs.getString("rno");
             int q=stmt.executeUpdate("delete from student where enrollno='"+enrollno+"'");
           
             int i=stmt.executeUpdate("update room set type="+null+", sname="+null+", enrollno="+null+", status='vacant' where rno='"+r+"'");
            
             out.print("<br><br><br><br><hr size='8'><center><font size=6 face='book antiqua'>"
                + "<i>Record Deleted Successfully!</i></font><hr size='8'>"
                     + "<br><br><font size=5 face='book antiqua'><i><a href='adminlogin?id=123&password=123'>back"
                     + "</a></i></font>"
                     + "</center>");
            }
            else
            {out.print("<br><br><br><br><hr size='8'><center><font size=6 face='book antiqua'>"
                + "<i>Invalid Name/Enrollment No!</i></font><hr size='8'></center>"); return;
            }
            
            
        }    
        catch(Exception e){out.print(e);}
        }
    }