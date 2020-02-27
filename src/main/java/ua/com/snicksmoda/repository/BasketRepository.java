package ua.com.snicksmoda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.snicksmoda.entity.Basket;

public interface BasketRepository extends JpaRepository<Basket, Long> {
}
