package personal.project.onlineclothesshop.producttype;

import javax.persistence.*;

@Entity
@Table(name = "producttype")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productTypeId")
    private long id;

    @Column(name = "categoryId")
    private long categoryId;

    @Column(name = "productTypeName")
    private String name;

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", name='" + name + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
