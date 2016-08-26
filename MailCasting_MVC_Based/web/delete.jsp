<%-- 
    Document   : delete
    Created on : Nov 7, 2015, 10:12:29 AM
    Author     : limon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>


<%
    String n = request.getParameter("val");
    if (n.length() > 0) 
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mail_Casting", "root", "");

            PreparedStatement ps = con.prepareStatement("delete  from inbox3 where id = '" + n + "' ");
//ps.setString(1,n);
            out.print("<br>");
            int s = ps.executeUpdate();
            out.print("Mail has been successfully deleted");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//end of if
%>