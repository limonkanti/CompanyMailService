<%-- 
    Document   : register
    Created on : Nov 4, 2015, 12:00:59 PM
    Author     : limon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Form</title>
    </head>
    <body>
       <form action="ControllerRegServlet" method="post">
           Name:<input type="text" name="uname"><br><br>
           Contact:<input type="text" name="ucontact"><br><br>
           Password:<input type="password" name="upass"><br><br>
           Re-Type_Password:<input type="password" name="urpass"><br><br>
           Email<input type="text" name="uemail"><br><br>
            <input type="submit" value="Registration">
            <input type="RESET" value="CLEAR">
        </form>
    </body>
</html>
