package org.me;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import org1.me.MVCconfigAn;

@SpringBootApplication

// this is facultatif because springbootapplication config class is in root package

@EnableJpaRepositories(basePackages="org.me",repositoryImplementationPostfix="Impl")
public class AppConfig  extends SpringBootServletInitializer{

	public static void main(String[] args ){
		SpringApplication.run(AppConfig.class, args);
		
	}
	
	
	@Bean
    
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        //viewResolver.setViewClass(JstlView.class);
        
        viewResolver.setPrefix("/WEB-INF/views/jsp/");
        viewResolver.setSuffix(".jsp");
 
        return viewResolver;
    }
	
	@Bean
	public ServletRegistrationBean dispatcherRegistration() {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();

	    
	    AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MVCconfigAn.class);
        dispatcherServlet.setApplicationContext(ctx);
        ServletRegistrationBean registration = new ServletRegistrationBean(
	            dispatcherServlet,"/admin/*");
        registration.setLoadOnStartup(1);
	    //registration.addUrlMappings("/admin/*");
	    registration.setName("myDispatcher");
	    return registration;
	}
	
	
@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppConfig.class);
    }
	
	/*
	CommandLineRunner run(){
		return null;
	}*/
}
