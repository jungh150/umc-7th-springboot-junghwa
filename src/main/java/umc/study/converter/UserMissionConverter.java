package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.domain.User;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;
import umc.study.web.dto.UserMissionResponseDTO;
import umc.study.web.dto.UserMissionRequestDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserMissionConverter {

    public static UserMissionResponseDTO.CreateUserMissionResultDTO toCreateUserMissionResultDTO(UserMission userMission){
        return UserMissionResponseDTO.CreateUserMissionResultDTO.builder()
                .userMissionId(userMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static UserMission toUserMission(UserMissionRequestDTO.CreateUserMissionDto request, User user, Mission mission){

        MissionStatus missionStatus = switch (request.getStatus()) {
            case 1 -> MissionStatus.CHALLENGING;
            case 2 -> MissionStatus.COMPLETED;
            default -> null;
        };

        return UserMission.builder()
                .status(missionStatus)
                .user(user)
                .mission(mission)
                .build();
    }
}
