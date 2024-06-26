package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String body;

    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    public void setMember(Member member) {

        if(this.member != null){
            this.member.getReviewList().remove(this);
        }
        this.member = member;
        member.getReviewList().add(this);
    }

    public void setStore(Store store) {

        if(this.store != null){
            this.store.getReviewList().remove(this);
        }
        this.store = store;
        store.getReviewList().add(this);
    }
}
