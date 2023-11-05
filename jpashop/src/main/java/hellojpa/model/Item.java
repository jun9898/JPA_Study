package hellojpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Item {

    @Id @GeneratedValue
    private Long itemId;

    private String name;
    private Long price;
    private Long stockQuantity;

    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItem;

    @OneToMany(mappedBy = "item")
    private List<CategoryItem> categoryItemList;

}
