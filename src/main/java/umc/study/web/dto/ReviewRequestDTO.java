package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.study.validation.annotation.ExistStores;
import umc.study.validation.annotation.ExistUsers;

import java.util.List;

public class ReviewRequestDTO {

    @Getter
    public static class CreateReviewDto{
        @NotBlank
        private String name;
        @Size(max = 100)
        String content;
        @NotNull
        private Float rate;
        @NotNull
        @ExistUsers
        private Long userId;
        @NotNull
        @ExistStores
        private Long storeId;
    }
}
