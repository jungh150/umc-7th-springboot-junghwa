package umc.study.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.User;
import umc.study.domain.mapping.Review;
import umc.study.domain.Store;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
    Page<Review> findAllByUser(User user, PageRequest pageRequest);
}
