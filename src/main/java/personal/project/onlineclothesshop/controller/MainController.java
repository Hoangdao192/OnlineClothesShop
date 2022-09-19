package personal.project.onlineclothesshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.project.onlineclothesshop.category.Category;
import personal.project.onlineclothesshop.category.CategoryService;
import personal.project.onlineclothesshop.product.Product;
import personal.project.onlineclothesshop.product.ProductService;
import personal.project.onlineclothesshop.producttype.ProductType;
import personal.project.onlineclothesshop.producttype.ProductTypeService;

import java.util.List;

@Controller
@RequestMapping
public class MainController {

    ProductService productService;
    ProductTypeService productTypeService;
    CategoryService categoryService;

    @GetMapping(path = { "/shop"})
    public String shop(Model model) {
        List<Product> productList = productService.getAllProduct();
        List<Category> categories = categoryService.getAllCategory();
        List<ProductType> productTypes = productTypeService.getAllProductType();
        model.addAttribute("categories", categories);
        model.addAttribute("productTypes", productTypes);
        return "shop";
    }

    @GetMapping(path = {"/", "/home"})
    public String home() {
        return "home";
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setProductTypeService(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
