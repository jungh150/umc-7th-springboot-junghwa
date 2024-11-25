package umc.study.service.UserMissionService;

import umc.study.domain.mapping.UserMission;
import umc.study.web.dto.UserMissionRequestDTO;

public interface UserMissionCommandService {

    UserMission createUserMission(UserMissionRequestDTO.CreateUserMissionDto request);
}
