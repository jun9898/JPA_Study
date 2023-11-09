package hellojpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "address")
public class AddressEntity {
    @Id @GeneratedValue
    private Long id;

    private Address address;

    public AddressEntity(Address address) {
        this.address = address;
    }

    public AddressEntity(String old1, String test2, String test3) {
        this.address = new Address(old1,test2,test3);
    }
}
