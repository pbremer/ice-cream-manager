package io.github.pbremer.icecreammanager.configuration;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebMvc
@EnableSpringDataWebSupport
@ComponentScan(
        basePackages = { "io.github.pbremer.icecreammanager.controller" })
public class ControllerConfiguration extends WebMvcAutoConfigurationAdapter {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/webjars/**")
	        .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
     * #addCorsMappings(org.springframework.web.servlet.config.annotation.
     * CorsRegistry)
     */

    @Override
    public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping("/**");
    }
}
