package org.me;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import org1.me.MVCconfigAn;

public class MyWebClassLoader /* implements WebApplicationInitializer */ {
	 
    public void onStartup(ServletContext container) throws ServletException {
 
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MVCconfigAn.class);
        ctx.setServletContext(container);
 System.out.println("Dispatcher1 ************************");
        ServletRegistration.Dynamic servlet = container.addServlet("dispatcher1", new DispatcherServlet(ctx));
 
        servlet.setLoadOnStartup(1);
        //servlet.addMapping("/admin");
    }
 
}