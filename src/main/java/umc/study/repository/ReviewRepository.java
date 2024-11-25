package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.mapping.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}