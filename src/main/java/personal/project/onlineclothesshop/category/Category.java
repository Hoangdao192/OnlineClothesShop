package personal.project.onlineclothesshop.category;

import javax.persistence.*;

@Entity
@Table(name = "productcategory")
public class Category {
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private long id;

    @Column(name = "categoryName")
    private String name;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
