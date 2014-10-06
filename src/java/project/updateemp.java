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
public class updateemp extends HttpServlet {

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
            String name=request.getParameter("name");
            String id=request.getParameter("id");
            
            Class.forName("com.mysql.jdbc.Driver");
  	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","123");
            Statement stmt=con.createStatement();
            
            out.print("<body background=abstractblue.jpg>"
                    + "<center><font size=10 face='stencil'>Update Employee Record<br><hr size=8><br></font>");
            
            ResultSet rs=stmt.executeQuery("select * from employee where id='"+id+"'");
            while(rs.next())
            {out.print("<font face='lucida handwriting' size=4><form action='http://localhost:8084/WebApplication1/saveemp' method='get'>");
             out.print("Employee Name:<input type='text' name='name' value='"+name+"'><br>"
                     + "Phone No:<input type='text' name='phone' value='"+rs.getString("phone")+"'><br>"
                     + " Select Type:<input type='radio' name='type' value='cook'>Cook"
                     +"<input type='radio' name='type' value='guard'>Guard" 
                     +"<input type='radio' name='type' value='maid'>Maid"
                     +" <input type='radio' name='type' value='warden'>Warden<br>"
                     + "<input type='hidden' name='id' value='"+id+"'>"
                     + "Employee ID:"+id+"<br>"
                     + "Enter Salary:<input type='text' name='salary' value='"+rs.getString("salary")+"'><br>"
                     + "Select Shift:<input type='radio' name='shift' value='day'>Day"
                     + "<input type='radio' name='shift' value='night'>Night"
                     + "<br><input type='submit' value='Done'></form></font></center></body>");
            }
            
          
        }
        
        catch(Exception e){out.print(e);}
    }

}