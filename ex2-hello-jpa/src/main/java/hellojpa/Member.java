package hellojpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Member {

    @Id @GeneratedValue @Column(name = "member_id")
    private Long id;

    private String username;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_id")
    private Team team;

/*
    @OneToOne
    @JoinColumn(name = "locker_id")
    private Locker locker;
*/

/*
    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProductList = new ArrayList<>();
*/

}
