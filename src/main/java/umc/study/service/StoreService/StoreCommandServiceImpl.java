package umc.study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.MissionHandler;
import umc.study.apiPayload.exception.handler.RegionHandler;
import umc.study.apiPayload.exception.handler.ReviewHandler;
import umc.study.converter.StoreConverter;
import umc.study.domain.Mission;
import umc.study.domain.Region;
import umc.study.domain.Store;
import umc.study.domain.mapping.Review;
import umc.study.repository.MissionRepository;
import umc.study.repository.RegionRepository;
import umc.study.repository.ReviewRepository;
import umc.study.repository.StoreRepository;
import umc.study.web.dto.StoreRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final MissionRepository missionRepository;
    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public Store createStore(StoreRequestDTO.CreateStoreDto request) {
        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
        Store newStore = StoreConverter.toStore(request, region);

        List<Mission> missionList = request.getMissionIds().stream()
                .map(missionId -> missionRepository.findById(missionId)
                        .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND)))
                .collect(Collectors.toList());
        newStore.getMissionList().addAll(missionList);

        List<Review> reviewList = request.getReviewIds().stream()
                .map(reviewId -> reviewRepository.findById(reviewId)
                        .orElseThrow(() -> new ReviewHandler(ErrorStatus.REVIEW_NOT_FOUND)))
                .collect(Collectors.toList());
        newStore.getReviewList().addAll(reviewList);

        return storeRepository.save(newStore);
    }
}