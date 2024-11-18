package umc.study.converter;

import umc.study.domain.User;
import umc.study.web.dto.UserResponseDTO;

import java.time.LocalDateTime;

public class UserConverter {

    public static UserResponseDTO.SignupResultDTO toJoinResultDTO(User member){
        return UserResponseDTO.SignupResultDTO.builder()
                .userId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}