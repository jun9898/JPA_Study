package hellojpa.section6;

import jakarta.persistence.*;

@Entity
public class Locker {

    @Id @GeneratedValue
    @Column(name = "locker_id")
    private Long id;
    private String name;
    @OneToOne(mappedBy = "member_id")
    private Member member;

}
