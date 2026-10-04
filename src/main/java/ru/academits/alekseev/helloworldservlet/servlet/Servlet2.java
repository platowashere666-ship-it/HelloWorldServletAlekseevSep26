package ru.academits.alekseev.helloworldservlet.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.text.StringEscapeUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.Enumeration;

public class Servlet2 extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 28L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("""
                <!DOCTYPE html>
                <html>
                <head>
                    <title>servlet2</title>
                    <meta charset="UTF-8">
                </head>
                <body>
                    <table border='1'>
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Value</th>
                            </tr>
                        </thead>
                        <tbody>""");

        Enumeration<String> contextParameters = getServletContext().getInitParameterNames();

        while (contextParameters.hasMoreElements()) {
            String name = contextParameters.nextElement();
            String value = req.getServletContext().getInitParameter(name);

            out.println("""
                    <tr>
                        <td>%s</td>
                        <td>%s</td>
                    </tr>
                    """.formatted(StringEscapeUtils.escapeHtml4(name), StringEscapeUtils.escapeHtml4(value)));
        }

        Enumeration<String> initParameters = getInitParameterNames();

        while (initParameters.hasMoreElements()) {
            String name = initParameters.nextElement();
            String value = getInitParameter(name);

            out.println("""
                    <tr>
                        <td>%s</td>
                        <td>%s</td>
                    </tr>
                    """.formatted(StringEscapeUtils.escapeHtml4(name), StringEscapeUtils.escapeHtml4(value)));
        }

        out.println("""
                        </tbody>
                    </table>
                </body>
                </html>
                """);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("OK");
    }
}
