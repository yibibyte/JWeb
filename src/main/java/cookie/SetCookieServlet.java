package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Cookie Servlet {@code /cookie/set}
 */
@WebServlet("/set")
public class SetCookieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        try {
            response.addCookie(new Cookie("user", "Tom"));
            out.println("Cookie Установлен используется для авторизации пользователя");
        }
        finally {
            out.close();
        }
    }
}