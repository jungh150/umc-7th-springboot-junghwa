package umc.study.web.dto;

import lombok.Getter;

import java.util.List;

public class UserRequestDTO {

    @Getter
    public static class SignupDto{
        String name;
        String password;
        Integer gender;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String address;
        String specAddress;
        List<Long> preferList;
    }
}