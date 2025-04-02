<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Initialization Parameters Example</title>
</head>
<body>
    <h1>Initialization Parameters Example</h1>

    <%
        // Получение параметров инициализации
        String param1 = config.getInitParameter("param1");
        String param2 = config.getInitParameter("param2");
    %>

    <p>Param1: <%= param1 %></p>
    <p>Param2: <%= param2 %></p>
</body>
</html>
