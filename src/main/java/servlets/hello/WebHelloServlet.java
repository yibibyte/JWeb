package servlets.hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Hello from annotated Servlet!</h1>");
    }
}