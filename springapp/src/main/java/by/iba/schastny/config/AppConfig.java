package by.iba.schastny.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import static by.iba.schastny.constants.ApplicationStringConstants.BASE_PACKAGES;
import static by.iba.schastny.constants.ApplicationStringConstants.PREFIX;
import static by.iba.schastny.constants.ApplicationStringConstants.SUFFIX;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages ={
        BASE_PACKAGES})
public class AppConfig {
    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix(PREFIX);
        resolver.setSuffix(SUFFIX);
        return resolver;
    }

}
