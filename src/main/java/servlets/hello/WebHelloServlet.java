package servlets.hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "WebHelloServlet",
        urlPatterns = {"/hi", "/greet"},
        loadOnStartup = 1
)
public class WebHelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("<!DOCTYPE html>");
        resp.getWriter().println("<html lang='ru'>");
        resp.getWriter().println("<head>");
        resp.getWriter().println("    <meta charset='UTF-8'>");
        resp.getWriter().println("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        resp.getWriter().println("    <title>Приветствие</title>");
        resp.getWriter().println("    <style>");
        resp.getWriter().println("        body {");
        resp.getWriter().println("            font-family: 'Arial', sans-serif;");
        resp.getWriter().println("            background-image: url('https://source.unsplash.com/1600x900/?nature');");
        resp.getWriter().println("            background-size: cover;");
        resp.getWriter().println("            color: white;");
        resp.getWriter().println("            margin: 0;");
        resp.getWriter().println("            display: flex;");
        resp.getWriter().println("            align-items: center;");
        resp.getWriter().println("            justify-content: center;");
        resp.getWriter().println("            height: 100vh;");
        resp.getWriter().println("            text-align: center;");
        resp.getWriter().println("            backdrop-filter: blur(5px);");
        resp.getWriter().println("        }");
        resp.getWriter().println("        h1 {");
        resp.getWriter().println("            font-size: 4em;");
        resp.getWriter().println("            margin-bottom: 20px;");
        resp.getWriter().println("            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7);");
        resp.getWriter().println("        }");
        resp.getWriter().println("        p {");
        resp.getWriter().println("            font-size: 1.5em;");
        resp.getWriter().println("            margin: 10px 0;");
        resp.getWriter().println("            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7);");
        resp.getWriter().println("        }");
        resp.getWriter().println("        .button {");
        resp.getWriter().println("            background-color: rgba(0, 0, 0, 0.5);");
        resp.getWriter().println("            color: white;");
        resp.getWriter().println("            padding: 15px 30px;");
        resp.getWriter().println("            text-decoration: none;");
        resp.getWriter().println("            border-radius: 5px;");
        resp.getWriter().println("            transition: background-color 0.3s;");
        resp.getWriter().println("            border: none;");
        resp.getWriter().println("            font-size: 1.2em;");
        resp.getWriter().println("        }");
        resp.getWriter().println("        .button:hover {");
        resp.getWriter().println("            background-color: rgba(0, 0, 0, 0.7);");
        resp.getWriter().println("        }");
        resp.getWriter().println("    </style>");
        resp.getWriter().println("</head>");
        resp.getWriter().println("<body>");
        resp.getWriter().println("    <div>");
        resp.getWriter().println("        <h1>Welcome и Добро пожаловать!</h1>");
        resp.getWriter().println("        <p>Мы рады вас видеть. Изучай наш сайт и узнай больше!</p>");
        resp.getWriter().println("        <a href='#' class='button'>Поехали</a>");
        resp.getWriter().println("    </div>");
        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");
    }
}
