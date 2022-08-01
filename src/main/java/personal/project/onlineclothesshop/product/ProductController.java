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
    public List<Product> getProductByCategoryId(@RequestParam long categoryId) {
        return productService.g
    }

    public List<Product> getAllProduct() {
        return productService.getAllProduct();
    }
}
