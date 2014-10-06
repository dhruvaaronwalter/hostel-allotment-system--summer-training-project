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
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Dhruv
 */
public class save extends HttpServlet {

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
              String n=request.getParameter("sname");
              String e=request.getParameter("enrollno");
              String y=request.getParameter("year");
              
              String p=request.getParameter("sphone");
              
               Class.forName("com.mysql.jdbc.Driver");
  	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","123");
            Statement stmt=con.createStatement();
            
            int s=stmt.executeUpdate("update student set year='"+y+"', sphone='"+p+"' where sname='"+n+"' and enrollno='"+e+"'");
           
             JOptionPane.showMessageDialog (null, "Record Updated", "Done", JOptionPane.INFORMATION_MESSAGE);
             String referer = request.getHeader("Referer"); response.sendRedirect(referer);
        }
        
        catch(Exception e){out.print(e);}
    }
}

    