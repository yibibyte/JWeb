<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ошибка</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8d7da;
            color: #721c24;
            padding: 20px;
            border: 1px solid #f5c6cb;
            border-radius: 5px;
        }
        h1 {
            color: #721c24;
        }
    </style>
</head>
<body>
    <h1>Произошла ошибка!</h1>
    <p>К сожалению, произошла ошибка при обработке вашего запроса.</p>
    <p>Тип ошибки: <strong><%= exception.getClass().getName() %></strong></p>
    <p>Сообщение: <strong><%= exception.getMessage() %></strong></p>
    <p>Пожалуйста, попробуйте еще раз или свяжитесь с администратором.</p>
</body>
</html>
