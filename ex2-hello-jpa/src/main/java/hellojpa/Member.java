package hellojpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Member {

    @Id @GeneratedValue @Column(name = "member_id")
    private Long id;

    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    // 기간
    @Embedded
    private Period workperiod;
    // 주소
    @Embedded
    private Address homeAddress;

    // 컬렉션을 저장할 수 있는 테이블을 생성하겠다
    @ElementCollection
    // 그 테이블의 이름읜 FAVORITE_FOOD이고 PK는 MEMBER_ID이다
    // 그리고 String이 저장될 컬럼의 이름은 FOOD_NAME이다
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
    @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoodss = new HashSet<>();

    @OneToMany(cascade = ALL, orphanRemoval = true)
    @JoinColumn(name = "member_id")
    private List<AddressEntity> addressHistory = new ArrayList<>();

//    @ElementCollection
//    @CollectionTable(name = "ADDRESS", joinColumns =
//    @JoinColumn(name = "MEMBER_ID"))
//    private List<Address> addressHistory = new ArrayList<>();
}
