package ru.academits.alekseev.helloworldservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.Enumeration;

@WebServlet(
        value = "/servlet1",
        initParams = {
                @WebInitParam(name = "servlet_1_name_1", value = "servlet_1_value_1"),
                @WebInitParam(name = "servlet_1_name_2", value = "servlet_1_value_2")
        }
)
public class ServletOne extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 23L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>servlet1</title>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<th>Name</th>");
        out.println("<th>Value</th>");
        out.println("</tr>");

        Enumeration<String> contextParameters = getServletContext().getInitParameterNames();
        while (contextParameters.hasMoreElements()) {
            String parameterName = contextParameters.nextElement();
            out.println("<tr>");
            out.println("<td>" + parameterName + "</td>");
            out.println("<td>" + getServletContext().getInitParameter(parameterName) + "</td>");
            out.println("</tr>");
        }

        Enumeration<String> initParameters = getInitParameterNames();
        while (initParameters.hasMoreElements()) {
            String parameterName = initParameters.nextElement();
            out.println("<tr>");
            out.println("<td>" + parameterName + "</td>");
            out.println("<td>" + getInitParameter(parameterName) + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("OK");
    }
}
