package hellojpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Locker {

    @Id @GeneratedValue
    @Column(name = "locker_id")
    private Long id;

/*
    @OneToOne(mappedBy = "locker")
    private Member member;
*/
}
