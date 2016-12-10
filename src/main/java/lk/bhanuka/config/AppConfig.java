package lk.bhanuka.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by bhanuka on 12/9/16.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "lk.bhanuka")
public class AppConfig {

}
