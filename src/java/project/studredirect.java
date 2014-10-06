/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dhruv
 */
public class studredirect extends HttpServlet {

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
            {response.sendRedirect("student.html");
            }
            else
            {
              session=request.getSession(true);
              String s=session.getAttribute("studentname").toString();
             
             
             Date createTime = new Date(session.getCreationTime());
             Date lastAccessTime = 
                        new Date(session.getLastAccessedTime());
            
            out.print("<html>");
         
           out.print("<head><center><font size=10 face='stencil'>STUDENT MODULE</font></center>");
           
           out.print("<title>Student Module</title>");
           out.print("</head>");
           out.print("<body background='light-blue-background.jpg'>");
           out.print("<font size=4 face='Arial'><b>User : "+s+",<br><br>Session last accessed at : "+lastAccessTime+"<br>"
                   + "Created at : "+createTime+"</b></font><br><hr size=8>");
                 
           out.print("<center><table border=1 cellspacing=55  >"
                   + "<tr><td><font size=5 face='Bauhaus 93'><a href='editstud'>View/Edit Personal Details&nbsp&nbsp&nbsp</font></a></td>"
                   + "<td><font size=5 face='Bauhaus 93'><a href='empshift'>View Employee Shift&nbsp&nbsp&nbsp</font></a></td>"
                   + "<td><font size=5 face='Bauhaus 93'><a href='addquery.html'>Add Query/Complaint&nbsp&nbsp&nbsp</font></a></td>"
                   + "<td><font size=5 face='Bauhaus 93'><a href='viewresponse'>View Query/Complaint Response</font></a></td>"
                   +"<td><font size=5 face='Bauhaus 93'><a href='forum'>Forums</font></a></td>"
                   + "<td><font size=5 face='Bauhaus 93'><a href='http://localhost:8084/WebApplication1/logoutstudent'>"
                   + "Logout</font></a></td>"
                   + "</tr></table></font>");
           out.print("</center>"
                   
                 
                  +"</body></html>");
            }
        }
        catch(Exception e){out.print(e);}
    }

    

}
