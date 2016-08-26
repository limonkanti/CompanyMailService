<%-- 
    Document   : delete1
    Created on : Nov 7, 2015, 11:36:41 AM
    Author     : limon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.sql.*" %>


<%
     
    String i=request.getParameter("id");
   
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mail_Casting", "root", "");

            PreparedStatement ps = con.prepareStatement("delete  from inbox3 where id = '" + i + "' ");
           
            int s = ps.executeUpdate();
            if(s>0)
            {
            out.print("Mail has been successfully deleted");
            }
            else
            {
                 out.print("Wrong!!!");
                
                
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
  
%>