<%-- 
    Document   : env
    Created on : 2021/9/18, 下午 07:19:28
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>check environment</title>
    </head>
    <body>
        <p>CLOUDSQL</p><%= System.getenv("CLOUDSQL")%>
    </body>
</html>
