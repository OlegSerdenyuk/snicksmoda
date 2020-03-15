package ua.com.snicksmoda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.snicksmoda.entity.Basket;

public interface StuffReviewRepository extends JpaRepository<Basket, Long> {
}
