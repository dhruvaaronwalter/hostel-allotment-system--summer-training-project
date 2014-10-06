<%-- 
    Document   : jsp1
    Created on : Jul 18, 2014, 10:33:36 AM
    Author     : Dhruv
--%>

<%@page import="java.util.Date,java.sql.*" contentType="text/html" pageEncoding="UTF-8"%>
<%!
   Date d;
%>

<% 
   d=new Date();
   out.println("Current Date Time:"+d);
%>
<br>
<br>

Date Time:<%=d%>

