package umc.study.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.domain.User;
import umc.study.web.dto.UserRequestDTO;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    @Override
    public User signupUser(UserRequestDTO.SignupDto request) {
        return null;
    }
}