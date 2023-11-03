package hellojpa.section5;

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
    @OneToMany(mappedBy = "team")
    List<Member5> members = new ArrayList<>();


}
