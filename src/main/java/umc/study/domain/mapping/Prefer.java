package umc.study.domain.mapping;

import lombok.*;
import umc.study.domain.User;
import umc.study.domain.Food;
import umc.study.domain.common.BaseEntity;

import jakarta.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Prefer extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id")
    private Food food;

    public void setUser(User user){
        if(this.user != null)
            user.getPreferList().remove(this);
        this.user = user;
        user.getPreferList().add(this);
    }

    public void setFood(Food food){
        this.food = food;
    }
}