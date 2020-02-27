package ua.com.snicksmoda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.snicksmoda.entity.Orders;
import ua.com.snicksmoda.entity.Stuff;

import java.util.List;

public interface StuffRepository extends JpaRepository<Stuff, Long> {
    Stuff findByName(String name);
}
