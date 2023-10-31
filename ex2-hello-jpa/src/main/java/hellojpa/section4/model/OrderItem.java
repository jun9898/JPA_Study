package hellojpa.section4.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "order_item")
public class OrderItem {
    @Id
    @GeneratedValue
    private Long orderItemId;
    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "order_id")
    private Orders orders;
    @ManyToOne
    @JoinColumn(name = "item_id")
    @ToString.Exclude
    private Item item ;
    private String orderprice;
    private String count;
}
