package personal.project.onlineclothesshop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping(path = "/list", params = "categoryId")
    public List<Product> getProductByCategoryId(@RequestParam(required = true) long categoryId) {
        return productService.getProductByCategoryId(categoryId);
    }

    @GetMapping(path = "/list", params = "productTypeId")
    public List<Product> getProductByProductTypeId(@RequestParam(required = true) long productTypeId) {
        return productService.getProductByProductTypeId(productTypeId);
    }

    @GetMapping(path = "/list")
    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }
}
