package personal.project.onlineclothesshop.product;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private Long productId;
    @Column(name = "productTypeId")
    private Long productTypeId;
    @Column(name = "categoryId")
    private Long categoryId;

    @Column(name = "productName")
    private String productName;
    @Column(name = "productColor")
    private String productColor;
    @Column(name = "productImagePath")
    private String productImagePath;
    @Column(name = "productPrice")
    private Long productPrice;

    public Product() {}

    public Product(Long productId,
                   Long productTypeId,
                   Long categoryId,
                   String productName,
                   String productColor,
                   String productImagePath,
                   Long productPrice
    ) {
        this.productId = productId;
        this.productTypeId = productTypeId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.productColor = productColor;
        this.productImagePath = productImagePath;
        this.productPrice = productPrice;
    }

    public Product(Long productTypeId,
                   Long categoryId,
                   String productName,
                   String productColor,
                   String productImagePath,
                   Long productPrice
    ) {
        this.productTypeId = productTypeId;
        this.categoryId = categoryId;
        this.productName = productName;
        this.productColor = productColor;
        this.productImagePath = productImagePath;
        this.productPrice = productPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getProductImagePath() {
        return productImagePath;
    }

    public void setProductImagePath(String productImagePath) {
        this.productImagePath = productImagePath;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productTypeId=" + productTypeId +
                ", categoryId=" + categoryId +
                ", productName='" + productName + '\'' +
                ", productColor='" + productColor + '\'' +
                ", productImagePath='" + productImagePath + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}
