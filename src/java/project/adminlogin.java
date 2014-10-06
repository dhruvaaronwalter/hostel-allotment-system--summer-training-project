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
import java.sql.ResultSet;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Dhruv
 */
public class adminlogin extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
             
           HttpSession asession = request.getSession();
           asession.setAttribute("id", 123);
           asession.setAttribute("pwd", 123);
           out.print("<body background='15223_2d_black-white.jpg'>"
                   + "<center><font size=10 face='stencil'>Admin Module</font><br>"
                   + "<marquee bgcolor='black'><font face='comic sans ms' size=5 color='white'>Welcome Admin,</font></marquee><br><hr size=8>");
           RequestDispatcher rd = request.getRequestDispatcher("adminhome.html");
           
           rd.include(request, response);
          
           
             
             
             
             
          
                   
        }
         catch(Exception e)
         {out.print(e);
        }
    }
}

    