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
public class viewresponse extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            HttpSession session=request.getSession(false);
            if(session==null)
              {out.print("<br><br><hr size=8>"
                      + "<center><font size=5 face='Consolas'>You need to be logged in to view this page!</font><hr size=8></center>");return;
              }
            session = request.getSession(true);
            String e=session.getAttribute("enrollmentno").toString();
            String s=session.getAttribute("studentname").toString();
            
           
            Class.forName("com.mysql.jdbc.Driver");
  	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","123");
            Statement stmt=con.createStatement();
            
            ResultSet rs=stmt.executeQuery("select * from query where enrollno='"+e+"'");
              
              out.print("<body background='abstractblue.jpg'>"
                      + "<center><font size='10' face='stencil'>Query Response<br><hr size=8><br></font>"
                      + "<table border=1 width=1000><tr><th><font size=6 face='cooper'>"
                      + "Your Query</font></th><th><font size=6 face='cooper'>Response</font></th>");
          while(rs.next())
                 { 
                   out.print("<tr><td><font size=5 face='book antiqua'><i>"+rs.getString("qry")+"</i></font></td>"
                            +"<td><font size=5 face='book antiqua'><i>"+rs.getString("ans")+"</i></td></tr>");
                        
                 }
          out.print("</table></body>");
            
            
        }
        catch(Exception e){out.print(e);}
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
