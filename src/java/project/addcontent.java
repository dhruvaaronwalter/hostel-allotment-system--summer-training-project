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

/**
 *
 * @author Dhruv
 */
public class addcontent extends HttpServlet {

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
            String f=request.getParameter("f");
            out.print("    <head>" +
"        <script>" +
"            function validate()" +
"            {" +
"                if(document.form2.ucontent.value==\"\")" +
"                {alert(\"Please enter some content!\");" +
"                return false;}" +
"            " +
"            }" +
"        </script>" +
"        " +
"        <title>Add Content</title>" +
"        \n" +
"    </head>\n" +
"    <body background=\"blueblack.jpg\">\n" +
"        <form action=\"addcontents\" name=\"form2\" onsubmit=\"return validate();\" method=\"get\">\n" +
"            \n" +
"            <font color=\"white\" size=\"5\">\n" +
"            \n" +
"            Content:<br><textarea style=\"font-size:20\"  name=\"ucontent\" cols=\"80\" rows=\"15\"></textarea></font>\n" +
"            <br><br><input type='hidden' name='formno' value='"+f+"'> <input type=\"submit\" value=\"Submit\">\n" +
"        </form>\n" +
"    </body>\n" );
            
        }
        catch(Exception e){}
    }

   
}
