package servlets.servlet;

import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import servlets.hello.HelloServlet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import java.io.IOException;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;


@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    private DataSource dataSource;
    private Connection connection;
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServlet.class);
    @Override
    public void init() throws ServletException {
//        try {
//            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
//        } catch (SQLException e) {
//            System.err.println("Ошибка SQL: " + e.getMessage());
//        }
//
        //Для использования просто вызовите:
        List<User> testUsers = User.generateTestUsers();

        if (dataSource == null) {
            throw new ServletException("DataSource is null");
        }

        // Инициализация пула соединений (HikariCP, Tomcat JDBC и т.д.)
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:/comp/env/jdbc/PostgresDB");
        } catch (NamingException e) {
            LOGGER.info("Не удалось выполнить поиск источника данных", e.getCause());
            throw new ServletException("Не удалось инициализировать источник данных", e);
        }
    }

    // Метод для отображения формы (GET-запрос)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Перенаправляем на index.html (если нужно)
        resp.sendRedirect("index.html");

        // ИЛИ рендерим HTML прямо из сервлета (альтернатива)
        /*
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("""
            <!DOCTYPE html>
            <html>
            <head><title>Авторизация</title></head>
            <body>
                <form action="/login" method="POST">
                    <input type="text" name="username" placeholder="Логин">
                    <input type="password" name="password" placeholder="Пароль">
                    <button type="submit">Войти</button>
                </form>
            </body>
            </html>
            """);
        */
    }
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        // Использование DataSource для получения соединения
//        try (Connection connection = dataSource.getConnection()) {
//            // Выполняем SQL-запросы или другие операции с базой данных
//            LOGGER.info("Successfully connected to the database");
//            response.getWriter().println("Database connection successful!");
//        } catch (SQLException e) {
//            LOGGER.info("Не удалось выполнить поиск источника данных", e.getCause());
//            throw new ServletException("Database access failed", e);
//        }
//    }
//    // Метод для обработки данных формы (POST-запрос)
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
//            throws ServletException, IOException {
//
//
//        // Получаем данные из формы
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//
////        HttpSession session = req.getSession();
////        session.setAttribute("user", username);
////
////        // В других сервлетах можно проверять:
////        HttpSession session = req.getSession(false);
////        if (session == null || session.getAttribute("user") == null) {
////            resp.sendRedirect("index.html"); // Не авторизован
////        }
//
//        if ("admin".equals(username) && "12345".equals(password)) {
//            resp.sendRedirect("welcome.html"); // Перенаправляем на защищённую страницу
//        } else {
//            req.setAttribute("error", "Неверный логин или пароль");
//            req.getRequestDispatcher("index.html").forward(req, resp); // Возвращаем на форму с ошибкой
//        }
//
//        // Проверяем логин/пароль (условный пример)
//        if ("admin".equals(username) && "12345".equals(password)) {
//            resp.getWriter().write("<h1>Добро пожаловать, " + username + "!</h1>");
//        } else {
//            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401
//            resp.getWriter().write("<h1>Ошибка: неверный логин или пароль!</h1>");
//        }
//    }
//
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("username");
        String password = req.getParameter("password");

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "SELECT * FROM users WHERE login = ? AND password = ?")) {

            stmt.setString(1, login);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                HttpSession session = req.getSession();
                session.setAttribute("user_id", rs.getInt("id"));
                session.setAttribute("first_name", rs.getString("first_name"));
                session.setAttribute("last_name", rs.getString("last_name"));
                session.setAttribute("email", rs.getString("email"));
                resp.sendRedirect("welcome.html");
            } else {
                resp.sendRedirect("index.html?error=1");
            }
        } catch (SQLException e) {
            throw new ServletException("Database error", e);
        }
    }
}