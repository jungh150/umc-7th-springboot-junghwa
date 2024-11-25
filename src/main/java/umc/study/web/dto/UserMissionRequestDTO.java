package umc.study.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.validation.annotation.ExistMissions;
import umc.study.validation.annotation.ExistUsers;

public class UserMissionRequestDTO {

    @Getter
    public static class CreateUserMissionDto{
        @NotNull
        private Integer status;
        @NotNull
        @ExistUsers
        private Long userId;
        @NotNull
        @ExistMissions
        private Long missionId;
    }
}
