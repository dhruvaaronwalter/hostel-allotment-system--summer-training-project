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

/**
 *
 * @author Dhruv
 */
public class updatestud extends HttpServlet {

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
            
            String enrollno=request.getParameter("enrollno");
            
            
            
             Class.forName("com.mysql.jdbc.Driver");
  	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","123");
            Statement stmt=con.createStatement();
            
            ResultSet rs1=stmt.executeQuery("select * from student where enrollno='"+enrollno+"'");
           
            while(rs1.next())
            {
            out.print("<body background='abstractblue.jpg'><center>"
                    + "<font size=10 face='stencil'>Update Student Record</font><br><br><hr size=8><br><br>"
                    + "<form action='savestud' method='get'>"
                    + "<font size=4 face='lucida handwriting'>"
                    + "Enter Name:<input type='text' name='sname' value='"+rs1.getString("sname")+"'>"
                    + "<br>Enrollment No.:"+enrollno+"<br>"
                    + "<input type='hidden' name='enrollno' value='"+enrollno+"'>"
                    + "Select Year:<input type='radio' name='year' value='1st'>1st"
                    + "<input type='radio' name='year' value='2nd'>2nd"
                    + "<input type='radio' name='year' value='3rd'>3rd"
                    + "<input type='radio' name='year' value='4th'>4th<br>"
                    + "Enter Phone:<input type='text' name='sphone' value='"+rs1.getString("sphone")+"'><br>");
                    }
            ResultSet rs2=stmt.executeQuery("select * from room where enrollno='"+enrollno+"'");
            
            while(rs2.next())
            {String room=rs2.getString("rno");
                out.print("Enter Room No:<input type='text'  name='rno' value='"+rs2.getString("rno")+"'>"
                    + "<br>Enter Room Type:<input type='radio' name='type' value='ac'>ac"
                    + "<input type='radio' name='type' value='non-ac'>non-ac"
                        + "<input type='hidden' name='room' value='"+room+"'>"
                        
                    + "<br><input type='submit' value='Update'></font></form>");
                    out.print("</center></body>");
            }       
            
            
        }
        catch(Exception e){out.print(e);}
    }

   
}
