package com.personalblog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.personalblog")
public class WebConfig implements WebMvcConfigurer {

//    @Bean
//    public InternalResourceViewResolver viewResolver() {
//        var bean = new InternalResourceViewResolver();
//        bean.setPrefix("/WEB-INF/views/");
//        bean.setSuffix(".jsp");
//        bean.setOrder(0);
//        return bean;
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
//    }

    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        var tr = new SpringResourceTemplateResolver();
        tr.setPrefix("classpath:/templates/");
        tr.setSuffix(".html");
        tr.setTemplateMode("HTML");
        tr.setCharacterEncoding("UTF-8");
        return tr;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        var te = new SpringTemplateEngine();
        te.setTemplateResolver(templateResolver());
        return te;
    }

    @Bean
    public ThymeleafViewResolver viewResolver() {
        var vr = new ThymeleafViewResolver();
        vr.setTemplateEngine(templateEngine());
        vr.setCharacterEncoding("UTF-8");
        vr.setOrder(1); // Set order to ensure it is used after InternalResourceViewResolver
        return vr;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        // Serve static resources from the classpath
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        // Serve templates from the classpath
        registry.addResourceHandler("/templates/**")
                .addResourceLocations("classpath:/templates/");
    }

}
