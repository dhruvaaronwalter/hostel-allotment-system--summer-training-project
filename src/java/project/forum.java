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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dhruv
 */
public class forum extends HttpServlet {

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
            HttpSession session=request.getSession(false);
            if(session==null)
              {out.print("<br><br><hr size=8>"
                      + "<center><font size=5 face='Consolas'>You need to be logged in to view this page!</font><hr size=8></center>");return;
              }
            
            out.println("<!DOCTYPE html>");
            Class.forName("com.mysql.jdbc.Driver");
  	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel","root","123");
            Statement stmt=con.createStatement();
            String f;
            
             out.print("<title>FORUMS</title><center><font color='#e0e0e0' size=10 face='stencil'>FORUMS</font></center>"
                     + "<p align='right'><a href='studredirect'><button>Home</button></a></p>"
                     + "<hr size=8><br>");
            ResultSet rs=stmt.executeQuery("select * from forum");
          
           
          
            out.print("<body background='forumbg.jpg'><center><table border=1 cellspacing=10 bgcolor='#e0e0e0' border=1><tr>"
                    + "<td width=150><font size=5 face='stencil'><center>Form No.</center></font></td>"
                    + "<td width=200><font size=5 face='stencil'><center>Date-Time</center></font></td>"
                    + "<td width=250><font size=5 face='stencil'><center>Added By</center></font></td>"
                    + "<td width=750><font size=5 face='stencil'><center>Topic</center></font></td></tr>");
            while(rs.next())
            {  f=rs.getString("formno");
              
                out.print("<tr><td><font face='Goudy Old Style' size='5'>"+rs.getString("formno")+"</font></td>"+
                    "<td><font face='Goudy Old Style' size='5'>"+rs.getString("fdate")+"</font></td>"+
                    "<td><font face='Goudy Old Style' size='5'>"+rs.getString("stuname")+"</font></td>"+
                    "<td width='1000'>"
                    + "<font face='Goudy Old Style' size='5'>"
                    + "<a href='forumcontent?fno="+f+"'>"+rs.getString("topic")+"</a></font><br>");
                  
               
                  out.print("</td></tr>");
            }
            out.print("<tr><td height=50 colspan=4><center><a href='addforum.html'><button>Create Forum</button></a></center></td></tr></table>");
            
              
                        
            
    }
          catch(Exception e){out.print(e);}
}
}