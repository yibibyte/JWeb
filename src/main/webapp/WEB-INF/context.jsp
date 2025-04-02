<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Global Initialization Parameters Example</title>
</head>
<body>
    <h1>Global Initialization Parameters Example</h1>

    <%
        // Получение глобальных параметров инициализации
        String globalParam1 = application.getInitParameter("globalParam1");
        String globalParam2 = application.getInitParameter("globalParam2");
    %>

    <p>Global Param1: <%= globalParam1 %></p>
    <p>Global Param2: <%= globalParam2 %></p>
</body>
</html>
