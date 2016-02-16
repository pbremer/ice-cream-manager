package io.github.pbremer.icecreammanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ApplicationConfiguration.class)
public class Application {
    
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
}
