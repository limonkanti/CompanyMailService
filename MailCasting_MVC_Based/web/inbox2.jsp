<%-- 
    Document   : inbox2
    Created on : Nov 7, 2015, 11:35:41 AM
    Author     : limon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     <%

            if (session.getAttribute("username") != null)
            {
                String sender = (String) session.getAttribute("username");

                try {
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Mail_Casting", "root", "");
                    PreparedStatement ps = con.prepareStatement("SELECT id,d,reciever,msg,dat  from inbox3 where sender=?");
                    ps.setString(1, sender);
                    ResultSet rs = ps.executeQuery();
                    out.print("<div id='bottom'></div>");

                    out.print("<table border=4 cellspacing='4' cellpadding='5'>");
                    out.print("<tr><td>TIME</td><td>RECIEVER</td><td>MESSAGE</td><td>DATE</td><td>DELETE</td></tr>");
                    while (rs.next()) {
                       // int id = rs.getInt(1);
                        // String s=rs.getString("sender");
                        //System.out.println(id);
                        
                        out.print("<tr>");
                        out.print("<td>" + rs.getString(2) + "</td>");
                        out.print("<td>" + rs.getString(3) + "</td>");
                        out.print("<td>" + rs.getString(4) + "</td>");
                        out.print("<td>" + rs.getString(5) + "</td>");
                        out.print("<td><a href='delete1.jsp?id=" + rs.getString(1) + "'> Delete</a></td>");
                        out.print("</tr>");

                    }
                    out.print("</table>");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        %>

    </body>
</html>
