package hellojpa.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "member")
public class Member {

    @Id @GeneratedValue
    private Long memberId;
    private String name;
    private String street;
    private String zipcode;
    @OneToMany(mappedBy = "member")
    private List<Orders> ordersList = new ArrayList<>();
}
