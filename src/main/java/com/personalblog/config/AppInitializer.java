package com.personalblog.config;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext sc) throws SecurityException {
        var ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebConfig.class); // Register the configuration class

        var dispatcher = new DispatcherServlet(ctx);
        ServletRegistration.Dynamic registration = sc.addServlet("dispatcher", dispatcher);

        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
