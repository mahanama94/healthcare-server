package lk.bhanuka.config;

import lk.bhanuka.interceptors.AuthInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by bhanuka on 12/9/16.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "lk.bhanuka")
public class AppConfig extends WebMvcConfigurerAdapter{

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new AuthInterceptor());
    }
}
