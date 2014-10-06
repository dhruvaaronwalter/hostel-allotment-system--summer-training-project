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
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author Dhruv
 */
public class addqry extends HttpServlet {

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
        try {
            /* TODO output your page here. You may use following sample code. */
             String qry=request.getParameter("txt");
             HttpSession session = request.getSession(true);
           String s=session.getAttribute("studentname").toString();
           String e=session.getAttribute("enrollmentno").toString();
             
            Class.forName("com.mysql.jdbc.Driver");
  	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","123");
            Statement stmt=con.createStatement();
            int q=stmt.executeUpdate("insert into query values('"+s+"','"+e+"','"+qry+"',null)");
              JOptionPane.showMessageDialog (null, "Query Submitted! You will be answered shortly!", "Done", JOptionPane.INFORMATION_MESSAGE);
                    String referer = request.getHeader("Referer"); response.sendRedirect(referer);
                     out.print("</center>");
        }
        catch(Exception e){out.print(e);}
    }
}

    