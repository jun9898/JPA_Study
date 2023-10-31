package hellojpa.section4.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue
    private Long itemId;
    private String name;
    private String price;
    private String stockquantity;
}
