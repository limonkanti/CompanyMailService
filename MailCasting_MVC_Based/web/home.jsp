<%-- 
    Document   : home
    Created on : Nov 4, 2015, 9:03:22 PM
    Author     : limon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%

            if(session.getAttribute("username") != null) 
            {
                String username = (String)session.getAttribute("username");
                out.print("<font style='color:green'>Welcome to you :\t" + username + "</font>"+"<br/><br/>");
            } 
        %>
        <%=session.getAttribute("username")%>
        <a href="compose.jsp">Compose Mail</a>|
        <a href="inbox2.jsp">Inbox</a>|
        <a href="LogoutServlet">Logout</a>

    </body>
</html>
