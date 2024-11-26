package umc.study.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class UserResponseDTO {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SignupResultDTO{
        Long userId;
        LocalDateTime createdAt;
    }
    
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserReviewDTO {
        private String storeName;       // 리뷰 대상 가게 이름
        private Float rate;             // 리뷰 평점
        private String content;         // 리뷰 내용
        private LocalDateTime createdAt; // 리뷰 작성일
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserReviewListDTO {
        private List<UserReviewDTO> reviewList; // 리뷰 리스트
        private Integer listSize;             // 리뷰 개수
        private Integer totalPage;            // 총 페이지 수
        private Long totalElements;           // 총 리뷰 수
        private Boolean isFirst;              // 첫 페이지 여부
        private Boolean isLast;               // 마지막 페이지 여부
    }
}