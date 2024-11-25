package umc.study.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.study.validation.annotation.ExistMissions;
import umc.study.validation.annotation.ExistRegions;
import umc.study.validation.annotation.ExistReviews;

import java.util.List;

public class StoreRequestDTO {

    @Getter
    public static class CreateStoreDto{
        @NotBlank
        private String name;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String specAddress;
        @NotNull
        private Float rate;
        @NotNull
        @ExistRegions
        private Long regionId;
        @ExistMissions
        private List<Long> missionIds;
        @ExistReviews
        private List<Long> reviewIds;
    }

    @Getter
    public static class UpdateStoreDto {
        private Long id;
        private String name;
        @Size(min = 5, max = 12)
        private String address;
        @Size(min = 5, max = 12)
        private String specAddress;
        private Float rate;
        @ExistRegions
        private Long regionId;
        @ExistMissions
        private List<Long> missionIds;
        @ExistReviews
        private List<Long> reviewIds;
    }
}
