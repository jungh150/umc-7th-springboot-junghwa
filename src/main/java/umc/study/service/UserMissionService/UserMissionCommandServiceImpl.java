package umc.study.service.UserMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.converter.UserMissionConverter;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.UserMission;
import umc.study.web.dto.UserMissionRequestDTO;
import umc.study.web.dto.UserMissionResponseDTO;
import umc.study.repository.UserMissionRepository;

@Service
@RequiredArgsConstructor
public class UserMissionCommandServiceImpl implements UserMissionCommandService {

    private final UserMissionRepository userMissionRepository;

    @Override
    public UserMission createUserMission(UserMissionRequestDTO.CreateUserMissionDto request) {
        return null;
    }

    @Override
    public UserMissionResponseDTO.UpdateUserMissionStatusResultDTO completeUserMission(Long userMissionId) {
        UserMission userMission = userMissionRepository.findById(userMissionId)
                .orElseThrow(() -> new IllegalArgumentException("UserMission not found"));

        if (userMission.getStatus() != MissionStatus.CHALLENGING) {
            throw new IllegalStateException("UserMission is not in CHALLENGING status");
        }

        userMission.updateStatus(MissionStatus.COMPLETED);

        return UserMissionConverter.toUpdateUserMissionStatusResultDTO(userMission);
    }
}
