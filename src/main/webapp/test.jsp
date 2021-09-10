<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>日本語先生</title>
    </head>
    <body>
        <h1>日期測驗</h1>
        <form name="QA Form" action="ResultServlet" method="POST">
            ${question}
            <br>
            <input type="submit" value="交卷"/>
        </form>
    </body>
</html>
