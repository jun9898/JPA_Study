package hellojpa.model;

import jakarta.persistence.*;

@Entity
public class OrderItem {

    @Id @GeneratedValue
    private Long orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders orders;

    // item 추가
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;


    private Long orderPrice;
    private Long count;
}
