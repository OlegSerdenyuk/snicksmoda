package ua.com.snicksmoda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.snicksmoda.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
