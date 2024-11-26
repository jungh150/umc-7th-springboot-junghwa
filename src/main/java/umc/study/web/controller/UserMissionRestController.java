package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.study.apiPayload.ApiResponse;
import umc.study.converter.StoreConverter;
import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.domain.mapping.Review;
import umc.study.service.StoreService.StoreCommandService;
import umc.study.service.StoreService.StoreQueryService;
import umc.study.service.UserMissionService.UserMissionCommandService;
import umc.study.validation.annotation.ExistStores;
import umc.study.web.dto.StoreResponseDTO;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.UserMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/userMissions")
public class UserMissionRestController {

    private final UserMissionCommandService userMissionCommandService;

    @PatchMapping("/{userMissionId}/complete")
    @Operation(summary = "진행 중인 미션을 완료 상태로 변경 API", description = "특정 UserMission의 상태를 완료(COMPLETED)로 변경하는 API입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userMissionId", description = "UserMission의 ID, PathVariable 입니다!")
    })
    public ApiResponse<UserMissionResponseDTO.UpdateUserMissionStatusResultDTO> completeUserMission(@PathVariable Long userMissionId) {
        UserMissionResponseDTO.UpdateUserMissionStatusResultDTO response = userMissionCommandService.com(userMissionId);
        return ApiResponse.onSuccess(response);
    }
}
