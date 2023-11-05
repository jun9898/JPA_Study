package hellojpa.section6;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Team {

    @Id @GeneratedValue
    @Column(name = "team_id")
    private Long id;
    private String name;

    @ToString.Exclude
    // mappedBy의 존재 의의
    // 데이터의 수정은 불가능하고 열람만 가능
    @OneToMany
    @JoinColumn(name = "team_id")
    List<Member> members = new ArrayList<>();

}
