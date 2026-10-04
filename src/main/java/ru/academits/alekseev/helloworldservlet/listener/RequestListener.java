package ru.academits.alekseev.helloworldservlet.listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;

public class RequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Запрос получен");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Запрос обработан");
    }
}
