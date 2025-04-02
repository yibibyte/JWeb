package servlets.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;

public class HelloServlet extends HttpServlet {
    public HelloServlet() {
        logger.info("============ HelloServlet created! ============");
    }
    private static final Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    @Override
    public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        response.setContentType("text/html");
        response.getWriter().println("<h1>Hello World! Im from Servlet</h1>");
    }
}
