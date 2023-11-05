package hellojpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id @GeneratedValue
    private Long categoryId;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<CategoryItem> categoryItemList = new ArrayList<>();

}
