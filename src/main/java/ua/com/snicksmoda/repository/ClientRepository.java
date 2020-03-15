package ua.com.snicksmoda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.snicksmoda.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);
}
