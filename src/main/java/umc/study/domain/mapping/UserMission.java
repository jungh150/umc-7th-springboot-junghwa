package umc.study.domain.mapping;

import lombok.*;
import umc.study.domain.common.BaseEntity;
import umc.study.domain.enums.MissionStatus;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserMission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;
}
