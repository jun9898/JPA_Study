package hellojpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MemberProduct {

    @Id
    @GeneratedValue
    @Column(name = "member_product_id")
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;
}
