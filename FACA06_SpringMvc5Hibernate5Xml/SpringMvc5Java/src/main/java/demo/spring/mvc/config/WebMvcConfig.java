package demo.spring.mvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc // <mvc:annotation-driven />
// WebMvcConfigurer(in Spring 5) replace WebMvcConfigurerAdapter(in Spring 4) 
public class WebMvcConfig implements WebMvcConfigurer /*WebMvcConfigurerAdapter*/ {

    // Cấu hình để sử dụng các file nguồn tĩnh (html, image, ..)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("WebMvcConfig");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
        registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        System.out.println("configureDefaultServletHandling");
        configurer.enable();
    }

}