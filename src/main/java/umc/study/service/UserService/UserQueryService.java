package umc.study.service.UserService;

import org.springframework.data.domain.Page;
import umc.study.domain.User;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.Review;
import umc.study.domain.mapping.UserMission;

import java.util.Optional;

public interface UserQueryService {

    Optional<User> findUser(Long id);
    Page<Review> getReviewList(Long userId, Integer page);
    Page<UserMission> getUserMissionsByStatus(Long userId, MissionStatus status, Integer page);
}
