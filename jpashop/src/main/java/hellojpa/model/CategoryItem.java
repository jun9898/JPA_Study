package hellojpa.model;

import jakarta.persistence.*;

import static jakarta.persistence.FetchType.*;

@Entity
public class CategoryItem {

    @Id @GeneratedValue
    private Long categoryItemId;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

}
