package umc.study.converter;

import org.springframework.data.domain.Page;
import umc.study.domain.Mission;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.domain.mapping.Review;
import umc.study.web.dto.StoreRequestDTO;
import umc.study.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static StoreResponseDTO.CreateStoreResultDTO toCreateStoreResultDTO(Store store) {
        return StoreResponseDTO.CreateStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.CreateStoreDto request, Region region) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .rate(request.getRate())
                .region(region)
                .build();
    }

    public static StoreResponseDTO.StoreReviewDTO toStoreReviewDTO(Review review){
        return StoreResponseDTO.StoreReviewDTO.builder()
                .ownerName(review.getUser().getName())
                .rate(review.getRate())
                .createdAt(review.getCreatedAt())
                .content(review.getContent())
                .build();
    }

    public static StoreResponseDTO.StoreReviewListDTO toStoreReviewListDTO(Page<Review> reviewList){

        List<StoreResponseDTO.StoreReviewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::toStoreReviewDTO)
                .collect(Collectors.toList());

        return StoreResponseDTO.StoreReviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static StoreResponseDTO.StoreMissionDTO toStoreMissionDTO(Mission mission) {
        return StoreResponseDTO.StoreMissionDTO.builder()
                .missionId(mission.getId())
                .content(mission.getContent())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .build();
    }

    public static StoreResponseDTO.StoreMissionListDTO toStoreMissionListDTO(Page<Mission> missionPage) {
        List<StoreResponseDTO.StoreMissionDTO> missionDTOList = missionPage.stream()
                .map(StoreConverter::toStoreMissionDTO)
                .collect(Collectors.toList());

        return StoreResponseDTO.StoreMissionListDTO.builder()
                .missionList(missionDTOList)
                .listSize(missionDTOList.size())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .isFirst(missionPage.isFirst())
                .isLast(missionPage.isLast())
                .build();
    }
}
