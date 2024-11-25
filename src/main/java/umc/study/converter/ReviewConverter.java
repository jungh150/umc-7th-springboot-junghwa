package umc.study.converter;

import umc.study.domain.Store;
import umc.study.domain.User;
import umc.study.domain.mapping.Review;
import umc.study.web.dto.ReviewRequestDTO;
import umc.study.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review) {
        return ReviewResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.CreateReviewDto request, User user, Store store) {
        return Review.builder()
                .rate(request.getRate())
                .content(request.getContent())
                .user(user)
                .store(store)
                .build();
    }
}
