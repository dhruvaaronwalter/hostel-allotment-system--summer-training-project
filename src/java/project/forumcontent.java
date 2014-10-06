/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dhruv
 */
public class forumcontent extends HttpServlet {

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
            String formno=request.getParameter("fno");
           Class.forName("com.mysql.jdbc.Driver");
  	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","123");
            Statement stmt=con.createStatement();
            String t="";
            ResultSet rs=stmt.executeQuery("select * from topic where formno='"+formno+"'");
            out.print("<title>FORUMS</title><center><font size=10 color='#e0e0e0' face='stencil'>FORUMS</font></center>"
                    + "<p align='right'><a href='studredirect'><button>Home</button></a></p>"
                     + "<hr size=8><br>");
            out.print("<body background='forumbg.jpg'>"
                    + "<center><table border=1 bgcolor='#e0e0e0' cellspacing=10>");
            while(rs.next()){t=rs.getString("topic");}
            out.print("<tr><td colspan=4><center><font size=5 face='Goudy Old Style'>"+t+"</font></center></td></tr>");
            
           rs=stmt.executeQuery("select * from topic where formno='"+formno+"'");
            while(rs.next())
            {
            out.print("<tr><td width=150>Date & Time:<br><font size=5 face='Goudy Old Style'>"+rs.getString("cdate")+"</font></td>");
            out.print("<td width=200>Added By:<br><br><font size=5 face='Goudy Old Style'>"+rs.getString("studname")+"</font></td>");
            out.print("<td width=700><font size=5 face='Goudy Old Style'>"+rs.getString("content")+"</font></td></tr>");
            
             }
            out.print("<tr><td colspan=4><center><a href='addcontent?f="+formno+"'><button>Add Response</button></center></td></tr>");
            out.print("</center></table>");
        }
        catch(Exception e){}
    }

  
}
