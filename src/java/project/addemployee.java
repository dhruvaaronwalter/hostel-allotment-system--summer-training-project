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
import javax.swing.*;

/**
 *
 * @author Dhruv
 */
public class addemployee extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            /* TODO output your page here. You may use following sample code. */
            
            String name=request.getParameter("name");
            String phone=request.getParameter("phone");
            String type=request.getParameter("type");
            String id=request.getParameter("id");
            String salary=request.getParameter("salary");
            String shift=request.getParameter("shift");
            
            Class.forName("com.mysql.jdbc.Driver");
  	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","123");
            Statement stmt=con.createStatement();
            
            int q=stmt.executeUpdate("insert into employee values('"+name+"','"+phone+"','"+type+"','"+id+"','"+salary+"','"+shift+"')");
           JOptionPane.showMessageDialog (null, "Record Inserted", "Done", JOptionPane.INFORMATION_MESSAGE);
            response.sendRedirect("addemployee.html");
        
        }    
        catch(Exception e){JOptionPane.showMessageDialog (null,e, "Error", JOptionPane.ERROR_MESSAGE);
       response.sendRedirect("addemployee.html");
        }
    }

}