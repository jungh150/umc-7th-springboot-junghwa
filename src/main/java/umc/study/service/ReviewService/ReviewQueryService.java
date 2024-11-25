package umc.study.service.ReviewService;

import umc.study.domain.mapping.Review;

import java.util.Optional;

public interface ReviewQueryService {

    Optional<Review> findReview(Long id);
}
