/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.swing.JOptionPane;

/**
 *
 * @author Dhruv
 */
public class logoutadmin extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           
 
           HttpSession asession = request.getSession(true);
            
                response.setHeader("Cache-Control", "no-cache, no-store");
	response.setHeader("Pragma", "no-cache"); 
        asession.removeAttribute("user");  
                asession.removeAttribute("id");
                 asession.removeAttribute("pwd");
                
           asession.invalidate();
             
           JOptionPane.showMessageDialog (null, "Logged Out Successfully", "Done", JOptionPane.INFORMATION_MESSAGE);
           
          response.sendRedirect("homepage.html");
          
        }
    }

    

}
