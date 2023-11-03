package hellojpa.section4.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue
    private Long orderId;
    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "member_id")
    private Member4 member4;
    @CreationTimestamp
    private Date orderdate;
    private String status;
}
