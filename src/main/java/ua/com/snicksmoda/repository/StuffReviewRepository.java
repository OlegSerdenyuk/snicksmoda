package ua.com.snicksmoda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.snicksmoda.entity.StuffReview;

public interface StuffReviewRepository extends JpaRepository<StuffReview, Long> {
}
