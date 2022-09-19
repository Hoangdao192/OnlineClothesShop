package personal.project.onlineclothesshop.producttype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/producttype")
public class ProductTypeController {
    @Autowired
    ProductTypeService productTypeService;

    @GetMapping(path = "/list", params = "categoryId")
    public List<ProductType> getAllProductTypeByCategoryId(@RequestParam long categoryId) {
        return productTypeService.getProductTypeByCategory(categoryId);
    }

    @GetMapping(path = "/list")
    public List<ProductType> getAllProductType() {
        return productTypeService.getAllProductType();
    }
}
