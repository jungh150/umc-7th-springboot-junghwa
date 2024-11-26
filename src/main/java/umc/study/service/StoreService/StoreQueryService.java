package umc.study.service.StoreService;

import org.springframework.data.domain.Page;
import umc.study.domain.Store;
import umc.study.domain.mapping.Review;

import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findStore(Long id);
    Page<Review> getReviewList(Long storeId, Integer page);
}
