package umc.study.service.UserMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.mapping.UserMission;
import umc.study.web.dto.UserMissionRequestDTO;

@Service
@RequiredArgsConstructor
public class UserMissionCommandServiceImpl implements UserMissionCommandService {

    @Override
    public UserMission createUserMission(UserMissionRequestDTO.CreateUserMissionDto request) {
        return null;
    }
}
