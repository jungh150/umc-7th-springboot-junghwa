package umc.study.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.FoodHandler;
import umc.study.converter.UserConverter;
import umc.study.converter.PreferConverter;
import umc.study.domain.Food;
import umc.study.domain.User;
import umc.study.domain.mapping.Prefer;
import umc.study.repository.FoodRepository;
import umc.study.repository.UserRepository;
import umc.study.web.dto.UserRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final FoodRepository foodRepository;

    @Override
    @Transactional
    public User signupUser(UserRequestDTO.SignupDto request) {
        User newUser = UserConverter.toUser(request);
        List<Food> foodList = request.getPreferList().stream()
                .map(category -> {
                    return foodRepository.findById(category).orElseThrow(() -> new FoodHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<Prefer> preferList = PreferConverter.toPreferList(foodList);

        preferList.forEach(prefer -> {prefer.setUser(newUser);});

        return userRepository.save(newUser);
    }
}