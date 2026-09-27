package ru.academits.alekseev.helloworldservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.Enumeration;

public class ServletTwo extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 28L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>servlet2</title>");
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
