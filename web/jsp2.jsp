<%-- 
    Document   : jsp2
    Created on : Jul 18, 2014, 11:10:54 AM
    Author     : Dhruv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%String str=null;
  str=request.getParameter("t1");
%>
<hr/>
<% for(int n=1;n<=7;n++)
      {          
%>
<%=str%> <br>
<% }
%>
