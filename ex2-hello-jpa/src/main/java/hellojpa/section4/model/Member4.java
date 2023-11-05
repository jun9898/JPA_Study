package hellojpa.section4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Member4 {

    @Id
    @GeneratedValue
    private Long memberId;
    private String name;
    private String city;
    private String street;
    private String zipcode;


}
