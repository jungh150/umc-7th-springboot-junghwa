package umc.study.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.User;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.Review;
import umc.study.domain.mapping.UserMission;
import umc.study.repository.ReviewRepository;
import umc.study.repository.UserMissionRepository;
import umc.study.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    public Optional<User> findUser(Long id) {
        return Optional.empty();
    }

    @Override
    public Page<Review> getReviewList(Long userId, Integer page) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return reviewRepository.findAllByUser(user, PageRequest.of(page, 10));
    }

    @Override
    public Page<UserMission> getUserMissionsByStatus(Long userId, MissionStatus status, Integer page) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        return userMissionRepository.findAllByUserAndStatus(user, status, PageRequest.of(page, 10));
    }
}
