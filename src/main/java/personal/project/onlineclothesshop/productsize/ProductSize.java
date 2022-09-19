package personal.project.onlineclothesshop.productsize;

import javax.persistence.*;

@Entity
@Table(name = "productsize")
public class ProductSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private long productId;
    @Column(name = "productColorId")
    private long productColorId;
    @Column(name = "productSizeId")
    private long productSizeId;

    @Column(name = "sizeImagePath")
    private String sizeImagePath;
    @Column(name = "sizeName")
    private String sizeName;
    @Column(name = "quantityInStock")
    private long quantityInStock;

    public ProductSize() {
    }

    public ProductSize(
            long productId, long productColorId, long productSizeId,
            String sizeImagePath, String sizeName, long quantityInStock)
    {
        this.productId = productId;
        this.productColorId = productColorId;
        this.productSizeId = productSizeId;
        this.sizeImagePath = sizeImagePath;
        this.sizeName = sizeName;
        this.quantityInStock = quantityInStock;
    }

    public ProductSize(
            long productId, long productColorId,
            String sizeImagePath, String sizeName, long quantityInStock)
    {
        this.productId = productId;
        this.productColorId = productColorId;
        this.sizeImagePath = sizeImagePath;
        this.sizeName = sizeName;
        this.quantityInStock = quantityInStock;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getProductColorId() {
        return productColorId;
    }

    public void setProductColorId(long productColorId) {
        this.productColorId = productColorId;
    }

    public long getProductSizeId() {
        return productSizeId;
    }

    public void setProductSizeId(long productSizeId) {
        this.productSizeId = productSizeId;
    }

    public String getSizeImagePath() {
        return sizeImagePath;
    }

    public void setSizeImagePath(String sizeImagePath) {
        this.sizeImagePath = sizeImagePath;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public long getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(long quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
