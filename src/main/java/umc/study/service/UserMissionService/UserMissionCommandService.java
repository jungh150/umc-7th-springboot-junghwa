package umc.study.service.UserMissionService;

import umc.study.domain.mapping.UserMission;
import umc.study.web.dto.UserMissionRequestDTO;
import umc.study.web.dto.UserMissionResponseDTO;

public interface UserMissionCommandService {

    UserMission createUserMission(UserMissionRequestDTO.CreateUserMissionDto request);
    UserMissionResponseDTO.UpdateUserMissionStatusResultDTO completeUserMission(Long userMissionId);
}
