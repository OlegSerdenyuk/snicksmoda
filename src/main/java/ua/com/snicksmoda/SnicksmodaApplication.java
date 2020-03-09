package ua.com.snicksmoda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.com.snicksmoda.configuration.JpaConfiguration;

@SpringBootApplication
public class SnicksmodaApplication {
    public static void main(String[] args) {
        SpringApplication.run(new Class<?>[]{SnicksmodaApplication.class, JpaConfiguration.class}, args);
    }
}
