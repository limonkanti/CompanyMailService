<%-- 
    Document   : inbox
    Created on : Nov 6, 2015, 8:58:06 AM
    Author     : limon
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>INBOX</title>

        <script>

            var request;
            function viewAll(name)
            {
                var v = name;
                var url = "delete.jsp?val=" + v;

                if (window.XMLHttpRequest) {
                    request = new XMLHttpRequest();
                }
                else if (window.ActiveXObject) {
                    request = new ActiveXObject("Microsoft.XMLHTTP");
                }

                try
                {
                    request.onreadystatechange = getAllInfo;
                    request.open("GET", url, true);
                    request.send();
                }
                catch (e) {
                    alert("Unable to connect to server");
                }
            }

            function getAllInfo() {
                if (request.readyState === 4) {
                    var val = request.responseText;
                    document.getElementById('bottom').innerHTML = val;
                }
            }

        </script>

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
                        out.print("<td><a href='delete.jsp?val=" + rs.getString(1) + "'> Delete</a></td>");
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
