/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Dhruv
 */
public class saveemp extends HttpServlet {

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
            String n=request.getParameter("name");
            String p=request.getParameter("phone");
            String t=request.getParameter("type");
            String i=request.getParameter("id");
            String sa=request.getParameter("salary");
            String sh=request.getParameter("shift");
           
            Class.forName("com.mysql.jdbc.Driver");
  	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","123");
            Statement stmt=con.createStatement();
            
            int u=stmt.executeUpdate("update employee set name='"+n+"', phone='"+p+"', type='"+t+"', salary='"+sa+"', shift='"+sh+"' where id='"+i+"'");
                JOptionPane.showMessageDialog (null, "Record Updated", "Done", JOptionPane.INFORMATION_MESSAGE);
                      response.sendRedirect("viewemp");
        }
    catch(Exception e){out.print(e);}
    }
    

}