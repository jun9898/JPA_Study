package hellojpa.section3;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "MBR")
public class Member1 {

    @Id
    private Long id;
    // unique값과 length를 Column 어노테이션에서 설정해줄 수 있다
    @Column(unique = true, length = 10)
    private String name;

    // JPA의 엔티티는 기본 생성자가 반드시 있어야 한다.
    public Member1() {
    }

    public Member1(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
