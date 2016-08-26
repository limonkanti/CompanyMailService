<%-- 
    Document   : compose
    Created on : Nov 4, 2015, 10:44:00 PM
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
           if(session.getAttribute("username")!=null)
           {
            
               String username=(String)session.getAttribute("username");
           }
        
        
        %>
        <form action="ComposeServlet1" method="post">
            To:<input type="text" name="reciever"><br><br>
            Message:<textarea rows="10" cols="50" name="msg"></textarea><br><br>
            <input type="submit" name="SEND"><br><br>
            <input type="reset" name="RESET"><br><br>
        </form>
    </body>
</html>
