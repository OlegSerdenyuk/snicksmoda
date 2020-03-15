package ua.com.snicksmoda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.snicksmoda.entity.Stuff;

public interface StuffRepository extends JpaRepository<Stuff, Long> {
    Stuff findByName(String name);
}
