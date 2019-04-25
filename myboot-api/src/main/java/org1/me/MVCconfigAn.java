package org1.me;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
 
@Configuration
@EnableWebMvc
@ComponentScan
//@PropertySource
public class MVCconfigAn  extends WebMvcConfigurerAdapter 
{

	
	
	
	
	
    
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	    registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/views/dyn/");
//	}
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/me").setViewName("you");
	}
	    
//	
//	
	
//	
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
	
//	@Bean
//	public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
//	    ServletRegistrationBean registration = new ServletRegistrationBean(
//	            dispatcherServlet);
//	    registration.addUrlMappings("/admin/*");
//	    registration.setName("myDispatcher");
//	    return registration;
//	}
	
//	@Bean
//	    
//	    public ViewResolver viewResolver() {
//	        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//	        viewResolver.setViewClass(JstlView.class);
//	        
//	        viewResolver.setPrefix("/WEB-INF/views/jsp/");
//	        viewResolver.setSuffix(".jsp");
//	 
//	        return viewResolver;
//	    }
	
	
//	@Override
//    public void configureDefaultServletHandling(
//            DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }
	 
	}
