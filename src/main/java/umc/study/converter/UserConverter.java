package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.User;
import umc.study.domain.enums.Gender;
import umc.study.domain.mapping.Review;
import umc.study.web.dto.UserRequestDTO;
import umc.study.web.dto.UserResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {

    public static UserResponseDTO.SignupResultDTO toJoinResultDTO(User user){
        return UserResponseDTO.SignupResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    
    public static User toUser(UserRequestDTO.SignupDto request){

        Gender gender = switch (request.getGender()) {
            case 1 -> Gender.MALE;
            case 2 -> Gender.FEMALE;
            case 3 -> Gender.NONE;
            default -> null;
        };

        return User.builder()
                .password(request.getPassword())
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .preferList(new ArrayList<>())
                .build();
    }

    public static UserResponseDTO.UserReviewDTO toUserReviewDTO(Review review) {
        return UserResponseDTO.UserReviewDTO.builder()
                .storeName(review.getStore().getName()) // 가게 이름 포함
                .rate(review.getRate())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static UserResponseDTO.UserReviewListDTO toUserReviewListDTO(Page<Review> reviewPage) {
        List<UserResponseDTO.UserReviewDTO> reviewDTOs = reviewPage.stream()
                .map(UserConverter::toUserReviewDTO)
                .collect(Collectors.toList());

        return UserResponseDTO.UserReviewListDTO.builder()
                .reviewList(reviewDTOs)
                .listSize(reviewDTOs.size())
                .totalPage(reviewPage.getTotalPages())
                .totalElements(reviewPage.getTotalElements())
                .isFirst(reviewPage.isFirst())
                .isLast(reviewPage.isLast())
                .build();
    }
}