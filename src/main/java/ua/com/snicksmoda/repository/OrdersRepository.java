package ua.com.snicksmoda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.snicksmoda.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
