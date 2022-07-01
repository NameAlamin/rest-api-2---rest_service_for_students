package com.rest2.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // root config
        AnnotationConfigWebApplicationContext ctxObj = new AnnotationConfigWebApplicationContext();
        ctxObj.register(RootConfig.class);
        ctxObj.refresh();
        servletContext.addListener(new ContextLoaderListener(ctxObj));

        // servlet config
        AnnotationConfigWebApplicationContext ctxObjServlet = new AnnotationConfigWebApplicationContext();
        ctxObjServlet.register(ServletConfig.class);
        ServletRegistration.Dynamic registration = servletContext
                .addServlet("servlet",new DispatcherServlet(ctxObjServlet));

        // load on start up
        registration.setLoadOnStartup(1);

        // mapping
        registration.addMapping("/");
    }
}
