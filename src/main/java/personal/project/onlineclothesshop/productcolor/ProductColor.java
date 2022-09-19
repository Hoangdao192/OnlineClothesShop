package personal.project.onlineclothesshop.productcolor;

import javax.persistence.*;

@Entity
@Table(name = "productcolor")
public class ProductColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private long productId;
    @Column(name = "productColorId")
    private long productColorId;
    @Column(name = "colorHexCode")
    private String colorHexCode;
    @Column(name = "colorImagePath")
    private String colorImagePath;

    public ProductColor() {}

    public ProductColor(int productId, int productColorId, String colorHexCode, String colorImagePath) {
        this.productId = productId;
        this.productColorId = productColorId;
        this.colorHexCode = colorHexCode;
        this.colorImagePath = colorImagePath;
    }

    public ProductColor(int productId, String colorHexCode, String colorImagePath) {
        this.productId = productId;
        this.colorHexCode = colorHexCode;
        this.colorImagePath = colorImagePath;
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

    public String getColorHexCode() {
        return colorHexCode;
    }

    public void setColorHexCode(String colorHexCode) {
        this.colorHexCode = colorHexCode;
    }

    public String getColorImagePath() {
        return colorImagePath;
    }

    public void setColorImagePath(String colorImagePath) {
        this.colorImagePath = colorImagePath;
    }
}
