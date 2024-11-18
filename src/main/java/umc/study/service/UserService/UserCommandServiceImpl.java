package umc.study.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.User;
import umc.study.repository.UserRepository;
import umc.study.web.dto.UserRequestDTO;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;

    @Override
    public User signupUser(UserRequestDTO.SignupDto request) {
        return null;
    }
}