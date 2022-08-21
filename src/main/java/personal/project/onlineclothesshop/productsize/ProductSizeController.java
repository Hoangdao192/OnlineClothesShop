package personal.project.onlineclothesshop.productsize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/productsize")
public class ProductSizeController {
    ProductSizeService productSizeService;

    public ProductSizeService getProductSizeService() {
        return productSizeService;
    }

    @Autowired
    public void setProductSizeService(ProductSizeService productSizeService) {
        this.productSizeService = productSizeService;
    }
}
