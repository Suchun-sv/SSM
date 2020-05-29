package com.servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SpringContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        //配置完web.xml在进行值得填写
        String config = context.getInitParameter("contextLocation");
        ApplicationContext app = new ClassPathXmlApplicationContext(config);
        context.setAttribute("ApplicationContext",app);

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
