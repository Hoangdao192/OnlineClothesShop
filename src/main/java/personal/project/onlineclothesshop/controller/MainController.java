package personal.project.onlineclothesshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.project.onlineclothesshop.product.Product;
import personal.project.onlineclothesshop.product.ProductService;

@Controller
@RequestMapping
public class MainController {
    @Autowired
    ProductService productService;

    @GetMapping(path = {"/", "/home"})
    public String home() {
        return "shop";
    }

//    @GetMapping(path = {"/about"})
//    public String about() {
//        Product product = productService.getAllProduct().get(0);
//        return product.toString();
//    }
}
