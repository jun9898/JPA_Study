package hellojpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "member")
public class Member {

    @Id @GeneratedValue
    private Long memberId;
    private String name;

    @Embedded
    private Address address;
    @OneToMany(mappedBy = "member")
    private List<Order> ordersList = new ArrayList<>();
}
