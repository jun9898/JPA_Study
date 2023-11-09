package hellojpa.model;

import jakarta.persistence.*;

@Entity
public class Delivery {
    @Id @GeneratedValue
    private Long deliveryId;

    private Status status;

    @Embedded
    private Address address;
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;
}
