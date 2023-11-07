package hellojpa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Child {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

//    @ManyToOne
//    @JoinColumn(name = "parent_id")
//    private Parent parent;
}
