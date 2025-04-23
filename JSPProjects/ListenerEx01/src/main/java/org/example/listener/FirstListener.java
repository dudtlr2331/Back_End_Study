package org.example.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class FirstListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 톰캣이 시작되면
        System.out.println("FirstListener contextInitialized() called");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // 톰캣이 끝나면
        System.out.println("FirstListener contextDestroyed() called");
    }
}
