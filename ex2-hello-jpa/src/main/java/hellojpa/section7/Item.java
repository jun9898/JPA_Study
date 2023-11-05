package hellojpa.section7;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
// DTYPE으로 테이블 생성
@DiscriminatorColumn
public abstract class Item {

    @Id @GeneratedValue
    private Long id;
    private String name;
    private int price;
}
