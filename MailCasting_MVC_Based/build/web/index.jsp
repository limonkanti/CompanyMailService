<%-- 
    Document   : index
    Created on : Nov 4, 2015, 10:00:13 AM
    Author     : limon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
    <body>
        <form action="ControllerLoginServlet" method="post">
            E-mail:<input type="text" name="uemail"><br/><br/>
            Password:<input type="password" name="upass"><br/><br/>
            <input type="submit" value="Login">
            <input type="RESET" value="CLEAR">
        </form>
        <a href="register.jsp">Registration</a>
    </body>
</html>
