package umc.study.converter;

import umc.study.domain.Store;
import umc.study.domain.Mission;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.CreateMissionResultDTO toCreateMissionResultDTO(Mission mission) {
        return MissionResponseDTO.CreateMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.CreateMissionDto request, Store store) {
        return Mission.builder()
                .reward(request.getReward())
                .content(request.getContent())
                .deadline(request.getDeadline())
                .store(store)
                .build();
    }
}
