package hellojpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Delivery {
    @Id @GeneratedValue
    private Long deliveryId;

    private String city;
    private String street;
    private String zipcode;
    private Status status;
}
