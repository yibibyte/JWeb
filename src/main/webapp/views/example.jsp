<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<%--
    Директива JSP (JSP Directive) - выше мы использовали директивы page для установки
    contentType и импорта классов
--%>

<%!
    // Объявление JSP (JSP Declaration) - объявляем метод, который можно использовать в JSP
    public String formatDate(Date date) {
        return new java.text.SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(date);
    }
%>

<html>
<head>
    <title>Пример JSP</title>
</head>
<body>
    <h1>Пример использования различных конструкций JSP</h1>

    <%-- Комментарий JSP (не отображается в HTML) --%>
    <!-- Обычный HTML комментарий (отображается в исходном коде HTML) -->

    <h2>1. Выражения JSP (JSP Expression)</h2>
    <p>Текущая дата: <%= new Date() %></p>
    <p>Форматированная дата: <%= formatDate(new Date()) %></p>

    <h2>2. Скриплеты JSP (JSP Scriplet)</h2>
    <%
        // Скриплет JSP - вставка Java кода
        String message = "Привет из скриплета!";
        out.println("<p>" + message + "</p>");

        // Установка атрибута в контекст страницы
        pageContext.setAttribute("pageAttribute", "Данные в контексте страницы");
    %>

    <h2>3. Expression Language (EL)</h2>
    <p>Атрибут запроса: ${requestScope.requestAttribute}</p>
    <p>Атрибут сессии: ${sessionScope.sessionAttribute}</p>
    <p>Атрибут приложения: ${applicationScope.applicationAttribute}</p>
    <p>Атрибут страницы: ${pageScope.pageAttribute}</p>

    <h2>4. Доступ к контекстам через pageContext</h2>
    <%
        // Доступ к разным контекстам через pageContext
        out.println("<p>Атрибут запроса через pageContext: " +
                    pageContext.getRequest().getAttribute("requestAttribute") + "</p>");

        out.println("<p>Атрибут сессии через pageContext: " +
                    pageContext.getSession().getAttribute("sessionAttribute") + "</p>");

        out.println("<p>Атрибут приложения через pageContext: " +
                    pageContext.getServletContext().getAttribute("applicationAttribute") + "</p>");

        out.println("<p>Атрибут страницы через pageContext: " +
                    pageContext.getAttribute("pageAttribute") + "</p>");
    %>

    <h2>5. Параметры инициализации</h2>
    <p>Имя сервлета: <%= config.getServletName() %></p>
    <p>Информация о сервере: <%= application.getServerInfo() %></p>
</body>
</html>