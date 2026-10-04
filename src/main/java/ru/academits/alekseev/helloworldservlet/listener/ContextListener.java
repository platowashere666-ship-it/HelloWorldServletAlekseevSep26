package ru.academits.alekseev.helloworldservlet.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Контекст создан");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Контекст уничтожен");
    }
}
