package ua.com.snicksmoda.configuration;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.com.snicksmoda.entity.Client;
import ua.com.snicksmoda.entity.Role;
import ua.com.snicksmoda.service.ClientService;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class AppConfiguration extends GlobalMethodSecurityConfiguration {
    public static String encoderPassword(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }

    @Bean
    public CommandLineRunner commandLineRunner(final ClientService clientService, final PasswordEncoder passwordEncoder) {
        return args -> clientService.saveClient(new Client(passwordEncoder.encode("admin"), Role.ADMIN));
    }
}
