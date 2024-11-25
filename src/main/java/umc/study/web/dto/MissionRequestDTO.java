package umc.study.web.dto;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.study.validation.annotation.ExistStores;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class CreateMissionDto{
        @NotNull
        private Integer reward;
        @Size(max = 100)
        String content;
        @NotNull
        private Float rate;
        @FutureOrPresent
        private LocalDate deadline;
        @NotNull
        @ExistStores
        private Long storeId;
    }
}
