package ua.com.snicksmoda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ua.com.snicksmoda.configuration.JpaConfiguration;
import ua.com.snicksmoda.repository.ClientRepository;

@SpringBootApplication
public class SnicksmodaApplication {
    public static void main(String[] args) {
        SpringApplication.run(SnicksmodaApplication.class, args);
    }

}
