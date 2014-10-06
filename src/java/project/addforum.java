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
import java.util.Date;
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
public class addforum extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            HttpSession session = request.getSession(true);
            String formno=request.getParameter("formno");
            String sname=session.getAttribute("studentname").toString();
            String enrollno=session.getAttribute("enrollmentno").toString();
            String topic=request.getParameter("topic");
            String content=request.getParameter("content");
            
          Class.forName("com.mysql.jdbc.Driver");
  	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","123");
            Statement stmt=con.createStatement();
            Date dat=new Date();
           String date=dat.toString();
            int r=stmt.executeUpdate("insert into forum values ('"+formno+"','"+date+"','"+sname+"','"+topic+"')");
            r=stmt.executeUpdate("insert into topic values ('"+formno+"','"+topic+"','"+content+"','"+sname+"','"+date+"')");
            JOptionPane.showMessageDialog (null, "Submitted!", "Done", JOptionPane.INFORMATION_MESSAGE);
            
            response.sendRedirect("forum");
        }
        
        catch(Exception e){out.print(e);}
    }

   

}
