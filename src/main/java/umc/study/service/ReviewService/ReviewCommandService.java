package umc.study.service.ReviewService;

import umc.study.domain.mapping.Review;
import umc.study.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {

    Review createReview(ReviewRequestDTO.CreateReviewDto request);
}
