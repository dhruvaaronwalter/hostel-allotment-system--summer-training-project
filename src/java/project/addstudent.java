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
import javax.swing.JOptionPane;

/**
 *
 * @author Dhruv
 */
public class addstudent extends HttpServlet {

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
        try {
            /* TODO output your page here. You may use following sample code. */
            String sname=request.getParameter("sname");
            String enrollno=request.getParameter("enrollno");
            String rno=request.getParameter("rno");
            String year=request.getParameter("year");
            String type=request.getParameter("type");
            String sphone=request.getParameter("sphone");
                        
            Class.forName("com.mysql.jdbc.Driver");
  	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","123");
            Statement stmt=con.createStatement();
            ResultSet r=stmt.executeQuery("select * from student where rno="+rno);
            while(r.next()){     out.print("<br><br><br><br><hr size='8'><center><font size=6 face='book antiqua'>"
                + "<i>Room Already Taken! Enter a valid room number!</i></font><hr size='8'></center>");
            return;}
            int rs=stmt.executeUpdate("insert into student values ('"+sname+"','"+enrollno+"','"+rno+"','"+year+"','"+sphone+"')");
            rs=stmt.executeUpdate("update room set type='"+type+"', sname='"+sname+"', enrollno='"+enrollno+"', status='occupied' where rno='"+rno+"'");
     
                 JOptionPane.showMessageDialog (null, "Record Inserted", "Done", JOptionPane.INFORMATION_MESSAGE);
            response.sendRedirect("addstudent.html");
        }    
        catch(Exception e){
            JOptionPane.showMessageDialog (null,e, "Error", JOptionPane.ERROR_MESSAGE);
       response.sendRedirect("addstudent.html");
       }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
