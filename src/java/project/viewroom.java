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
public class viewroom extends HttpServlet {

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
            Class.forName("com.mysql.jdbc.Driver");
  	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","123");
            Statement stmt=con.createStatement();
            
            ResultSet rs=stmt.executeQuery("select * from room");
            out.print("<body background='abstractblue.jpg'>"
                    + "<center><font size=10 face='stencil'>Room Database</font></center>"
                    + "<p align='right'> <form>\n" +
                      "<input type='button' value='Print' onclick='window.print()'></p>" 
                     +"</form><hr size=8><br>"
                    + "<center><table border=1>"
                    + "<th><font size=5>Room No</font></th>"
                    + "<th><font size=5>Type</font></th>"
                    + "<th><font size=5>Alloted to</font></th>"
                    + "<th><font size=5>Enrollment No</font></th>"
                    + "<th><font size=5>Status</font></th>");
            while(rs.next())
            {out.print("<tr>");
             out.print("<td><font size=5>"+rs.getString("rno")+"</font></td>"
                     + "<td><font size=5>"+rs.getString("type")+"</font></td>"
                     + "<td><font size=5>"+rs.getString("sname")+"</font></td>"
                     + "<td><font size=5>"+rs.getString("enrollno")+"</font></td>"
                     + "<td><font size=5>"+rs.getString("status")+"</font></td></tr>");
            }
            out.print("</table>"
                    + "<br><br><br><font size=5 face='book antiqua'><i>"
                    + ""
                    + "<a href='adminlogin?id=123&password=123'>back</a></i></font>"
                    + "</center><body>");
                    
        }
        catch(Exception e){out.print(e);}
    }

    

}
