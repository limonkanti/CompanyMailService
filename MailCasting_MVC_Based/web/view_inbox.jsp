<%-- 
    Document   : view_inbox
    Created on : Nov 6, 2015, 11:00:40 AM
    Author     : limon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NAME</th>
                    <th>PASSWORD</th>
                    <th>E-MAIL</th>
                   
                        
                </tr>
            </thead> 
            <tbody>
                <c:forEach items="${user}" var="sender">
                    <tr>
                        <td>${sender.d}</td>
                        <td>${sender.reciever}</td>
                        <td>${sender.msg}</td>
                        <td>${sender.dat}</td>
                        
                    </tr>
                </c:forEach>
            </tbody>
            
            
        </table>
    </body>
</html>
