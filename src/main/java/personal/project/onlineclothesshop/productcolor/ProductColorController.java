package personal.project.onlineclothesshop.productcolor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.project.onlineclothesshop.product.ProductService;

@RestController
@RequestMapping(path = "/api/productcolor")
public class ProductColorController {
    ProductService productService;

    public ProductService getProductService() {
        return productService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
