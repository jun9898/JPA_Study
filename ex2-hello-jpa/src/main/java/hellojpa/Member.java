package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Member {

    @Id
    private Long id;
    private String name;

    // JPA의 엔티티는 기본 생성자가 반드시 있어야 한다.
    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
