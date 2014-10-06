/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dhruv
 */
public class empshift extends HttpServlet {

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
            
            HttpSession session=request.getSession(false);
            if(session==null)
              {out.print("<br><br><hr size=8>"
                      + "<center><font size=5 face='Consolas'>You need to be logged in to view this page!</font><hr size=8></center>");return;
              }
            Class.forName("com.mysql.jdbc.Driver");
  	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","123");
            Statement stmt=con.createStatement();
            
            ResultSet rs=stmt.executeQuery("select * from employee");
            out.print("<html><head><title>Employee Records</title></head>");
            out.print("<body background='abstractblue.jpg'>");
            out.print("<center><font size=10 face='stencil'>Employee Shift</font>"
                    + "<br><br><hr size=8><br><br><table border=1><tr><th><font size=6 face='book antiqua'><i>Name</font></th>"
                    + "<th><i><font size=6 face='book antiqua'>Phone</font></th>"
                    + "<th><i><font size=6 face='book antiqua'>Type</font></th>"
                    
         
                    + "<th><i><font size=6 face='book antiqua'>Shift</font></th>");
            while(rs.next())
            {out.println("<tr>");
             out.println("<td><font size=5 face='book antiqua'><i>"+rs.getString("name")+"</i></font></td>"
                     + "<td><font size=5 face='book antiqua'><i>"+rs.getString("phone")+"</i></font></td>"
                     + "<td><font size=5 face='book antiqua'><i>"+rs.getString("type")+"</i></font></td>"
                     
                     +"<td><font size=5 face='book antiqua'><i>"+rs.getString("shift")+"</i></font></td>");
            
            
                  
               out.println("</tr>");}
            out.print("</table></center></body></html>");
              
            
            
            
        }
        catch(Exception e){out.print(e);}
    }
}

    