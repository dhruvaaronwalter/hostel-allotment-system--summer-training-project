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
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Dhruv
 */
public class studentlogin extends HttpServlet {

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
        try  {
            /* TODO output your page here. You may use following sample code. */
            String sname=request.getParameter("sname");
            String enrollno=request.getParameter("enrollno");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "123");
            Statement stmt = con.createStatement();

            ResultSet status = stmt.executeQuery("select * from student where sname='"+sname+"' and enrollno='"+enrollno+"'" );
            
            if(status.next()){}
            else{out.print("<html>"
                        + "<head></head>"
                        + "<body><center><img src='sorry.jpeg'><br>"
                        + "<font size=6 face='book antiqua'>"
                        + "<i>Invalid Name/Enrollment No!</i></center>"
                        + "</font></body></html>");
                return;
}
              HttpSession session=request.getSession(true);
            session.setAttribute("studentname", sname);
            session.setAttribute("enrollmentno",enrollno);
             JOptionPane.showMessageDialog (null, "Welcome "+sname+"!", "Login Successful!", JOptionPane.INFORMATION_MESSAGE);
             
             Date createTime = new Date(session.getCreationTime());
             Date lastAccessTime = 
                        new Date(session.getLastAccessedTime());
            
            out.print("<html>");
         
           out.print("<head><center><font size=10 face='stencil'>STUDENT MODULE</font></center>");
           
           out.print("<title>Student Module</title>");
           out.print("</head>");
           out.print("<body background='light-blue-background.jpg'>");
           out.print("<font size=4 face='Arial'><b>User : "+sname+",<br><br>Session last accessed at : "+lastAccessTime+"<br>"
                   + "Created at : "+createTime+"</b></font><br><hr size=8>");
                 
           out.print("<center><table border=1 cellspacing=55  >"
                   + "<tr><td><font size=5 face='Bauhaus 93'><a href='editstud'>View/Edit Personal Details&nbsp&nbsp&nbsp</font></a></td>"
                   + "<td><a href='empshift'><font size=5 face='Bauhaus 93'>View Employee Shift&nbsp&nbsp&nbsp</font></a></td>"
                   + "<td><font size=5 face='Bauhaus 93'><a href='addquery.html'>Add Query/Complaint&nbsp&nbsp&nbsp</font></a></td>"
                   + "<td><font size=5 face='Bauhaus 93'><a href='viewresponse'>View Query/Complaint Response</font></a></td>"
                   +"<td><font size=5 face='Bauhaus 93'><a href='forum'>Forums</font></a></td>"
                   + "<td><font size=5 face='Bauhaus 93'><a href='http://localhost:8084/WebApplication1/logoutstudent'>"
                   + "Logout</font></a></td>"
                   + "</tr></table></font>");
           out.print("</center>"
                   
                 
                  +"</body></html>");
            
        
        }
        
        
            catch(Exception e){out.print(e);}
    }
  
}

   
