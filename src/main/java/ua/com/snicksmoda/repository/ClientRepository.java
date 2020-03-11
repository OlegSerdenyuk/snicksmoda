package ua.com.snicksmoda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.snicksmoda.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);

    Client getEmail(String email);

    Client getAllClient(Client client);
}
