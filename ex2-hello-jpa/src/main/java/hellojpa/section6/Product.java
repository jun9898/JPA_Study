package hellojpa.section6;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {

    @Id @GeneratedValue
    @Column(name = "product_id")
    private Long id;
    private String name;

    @OneToMany
    @JoinColumn(name = "product")
    private List<MemberProduct> memberList = new ArrayList<>();
}
