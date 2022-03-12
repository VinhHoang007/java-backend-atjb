package demo.spring.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("demo.spring.mvc") // <context:component-scan base-package="demo.spring.mvc" />
public class ApplicationContextConfig {

    // View resolver - Normal
    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        System.out.println("getViewResolver");

        InternalResourceViewResolver obj = new InternalResourceViewResolver();
        obj.setPrefix("/WEB-INF/views/");
        obj.setSuffix(".jsp");

        // Specialization of InternalResourceView for JSTL pages,i.e. JSP pages that use
        // the JSP Standard Tag Library.
        // Exposes JSTL-specific request attributes specifying localeand resource bundle for JSTL's formatting and message tags,using Spring's locale and org.springframework.context.MessageSource. 
        // Typical usage with InternalResourceViewResolver would look as follows,from the perspective of the DispatcherServlet context definition: 
        // obj.setViewClass(JstlView.class); // Import JSTL If setting
        
        return obj;
    }
}
