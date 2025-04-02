package servlets.hello;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html lang='ru'>");
            out.println("<head>");
            out.println("    <meta charset='UTF-8'>");
            out.println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.println("    <title>Приветствие</title>");
            out.println("    <style>");
            out.println("        body {");
            out.println("            font-family: Arial, sans-serif;");
            out.println("            background-color: #f0f8ff;");
            out.println("            color: #333;");
            out.println("            margin: 0;");
            out.println("            padding: 0;");
            out.println("            display: flex;");
            out.println("            align-items: center;");
            out.println("            justify-content: center;");
            out.println("            height: 100vh;");
            out.println("            text-align: center;");
            out.println("        }");
            out.println("        h1 {");
            out.println("            font-size: 3em;");
            out.println("            margin-bottom: 20px;");
            out.println("            color: #2c3e50;");
            out.println("        }");
            out.println("        p {");
            out.println("            font-size: 1.5em;");
            out.println("            margin: 10px 0;");
            out.println("            color: #34495e;");
            out.println("        }");
            out.println("        .button {");
            out.println("            background-color: #2980b9;");
            out.println("            color: white;");
            out.println("            padding: 15px 30px;");
            out.println("            text-decoration: none;");
            out.println("            border-radius: 5px;");
            out.println("            transition: background-color 0.3s;");
            out.println("        }");
            out.println("        .button:hover {");
            out.println("            background-color: #3498db;");
            out.println("        }");
            out.println("    </style>");
            out.println("</head>");
            out.println("<body>");
            out.println("    <div>");
            out.println("        <h1>Добро пожаловать на нашу страницу!</h1>");
            out.println("        <p>Мы рады вас видеть. Исследуйте наш контент и наслаждайтесь!</p>");
            out.println("        <a href='#' class='button'>Начать</a>");
            out.println("    </div>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}
