package hellojpa.model;

import jakarta.persistence.*;

@Entity
public class CategoryItem {

    @Id @GeneratedValue
    private Long categoryItemId;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
