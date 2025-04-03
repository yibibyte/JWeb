package servlets.hello;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * http://localhost:8080/WebApp/custom?id=5
 * http://localhost:8080/WebApp/custom?nums=1&nums=2&nums=3
 */
@WebServlet("/custom")
public class CustomServlet extends HttpServlet {

//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        response.setContentType("text/html");
//        PrintWriter writer = response.getWriter();
//
//        // Получить параметр запроса id
//        String id = request.getParameter("id");
//
//        try {
//            writer.println("<h2>id:" + id + "</h2>");
//        } finally {
//            writer.close();
//        }
//    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        response.setContentType("text/html");
//        PrintWriter writer = response.getWriter();
//
//        String[] nums = request.getParameterValues("nums");
//
//        try {
//            writer.print("<h2>Numbers: ");
//            for(String n: nums)
//                writer.print(n + " ");
//            writer.println("</h2>");
//        } finally {
//            writer.close();
//        }
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String name = request.getParameter("username");
        String age = request.getParameter("userage");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        String[] courses = request.getParameterValues("greeting");

        try {
            writer.println("<p>Name: " + name + "</p>");
            writer.println("<p>Age: " + age + "</p>");
            writer.println("<p>Gender: " + gender + "</p>");
            writer.println("<p>Country: " + country + "</p>");
            writer.println("<h4>Greeting:</h4>");
            for(String course: courses)
                writer.println("<li>" + course + "</li>");
        } finally {
            writer.close();
        }
    }

}