package servlets.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/example")
public class ExampleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Установка атрибутов в разные контексты
        request.setAttribute("requestAttribute", "Данные в контексте запроса");

        HttpSession session = request.getSession();
        session.setAttribute("sessionAttribute", "Данные в контексте сессии");

        ServletContext application = getServletContext();
        application.setAttribute("applicationAttribute", "Данные в контексте приложения");

        // Передача управления JSP странице
        request.getRequestDispatcher("/views/example.jsp").forward(request, response);
    }
}