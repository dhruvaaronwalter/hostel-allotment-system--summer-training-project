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
public class viewquery extends HttpServlet {

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
            Class.forName("com.mysql.jdbc.Driver");
  	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","123");
            Statement stmt=con.createStatement();
            
            ResultSet rs=stmt.executeQuery("select * from query where qry is not null");
            out.print("<body background='red.jpg'><center>"
                    + "<font size=10 face='stencil'>Student Queries</font><br><br><hr size=8><br><br><br>"
                    + "<table border=1><tr><th><font size=5 face='cooper'>Name</font>"
                    + "</th><th><font size=5 face='cooper'>Enrollment No</font></th>"
                    + "<th><font size=5 face='cooper'>Query/Complaint</font></th><th></th>");
            while(rs.next())
            {out.print("<tr><td><font size=4 face='book antiqua'><i>"+rs.getString("name")+"</i></font></td>");
             out.print("<td><font size=4 face='book antiqua'><i>"+rs.getString("enrollno")+"</i></font></td>");
             out.print("<td><font size=4 face='book antiqua'><i>"+rs.getString("qry")+"</i></font></td>"
                     + "<td>"
                     + "<form action='http://localhost:8084/WebApplication1/ansquery' method='post'>"
                     +"<textarea name='ans'></textarea>"
                     + "<input type='hidden' name='name' value='"+rs.getString("name")+"'>"
                     +"<input type='hidden' name='enrollno' value='"+rs.getString("enrollno")+"'>"
                     +"<input type='hidden' name='qry' value='"+rs.getString("qry")+"'>"
                     + "<input type=submit value='Ans Query'>"
                     + "</form></td>"
                     + "<td><form action='http://localhost:8084/WebApplication1/delquery' method='get'>"
                     +"<input type='hidden' name='enrollno' value='"+rs.getString("enrollno")+"'>"
                     +"<input type='hidden' name='qry' value='"+rs.getString("qry")+"'>"
                     +"<input type='submit' value='delete'>"
                     + "</tr>");
             
        
            }
             out.print("</table>"
                     + "<br><br><br><font size=5 face='book antiqua'><i>"
                     + "<a href='adminlogin?id=123&password=123'>back</a></i></font><center></body>");
            }
        catch(Exception e){out.print(e);}
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
