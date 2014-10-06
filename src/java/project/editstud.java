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
public class editstud extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            /* TODO output your page here. You may use following sample code. */
            HttpSession session=request.getSession(false);
            if(session==null)
              {out.print("<br><br><hr size=8>"
                      + "<center><font size=5 face='Consolas'>You need to be logged in to view this page!</font><hr size=8></center>");return;
              }
            session = request.getSession(true);
           String s=session.getAttribute("studentname").toString();
           String e=session.getAttribute("enrollmentno").toString();
           
           Class.forName("com.mysql.jdbc.Driver");
  	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","123");
            Statement stmt=con.createStatement();
            
            ResultSet rs=stmt.executeQuery("select * from student where sname='"+s+"' and enrollno='"+e+"'");
             
            
            
            
             
          
            if(rs.next()){
                out.print("<body background='red.jpg'>"
                        + "<center><font size=10 face=stencil>Edit Record</font><br><hr size=8><br><br>");
                out.print("<font size=5 face='book antiqua'><i>");
                out.print("Student Name: "+s);
            out.print("<br>Enrollment No: "+e);
           
            out.print("<form action='http://localhost:8084/WebApplication1/save' method='get'>");
            
            out.print("<input type='hidden' name='sname' value='"+rs.getString("sname")+"'>"
                    + "<input type='hidden' name='enrollno' value='"+rs.getString("enrollno")+"'>"
                    
                    + "Select Year:<input type='radio' name='year' value='1st' >1st"
                    + "<input type='radio' name='year' value='2nd'>2nd"
                    + "<input type='radio' name='year' value='3rd'>3rd"
                    + "<input type='radio' name='year' value='4th'>4th<br>");
            out.print("Room No:"+rs.getString("rno")+"<br>");
            out.print("Enter Phone No:<input type='text' name='sphone' value='"+rs.getString("sphone")+"' ><br>");
            out.print("<input type='submit' value='Update'>");
            out.print("</form></i></font></center>");
            }
        }
        catch(Exception e){out.println(e);}
      
    }

}