package personal.project.onlineclothesshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.project.onlineclothesshop.product.Product;
import personal.project.onlineclothesshop.product.ProductRepository;

@RestController
@RequestMapping
public class MainController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping(path = {"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping(path = {"/about"})
    public String about() {
        Product product = productRepository.findAll().get(0);
        return product.toString();
    }
}
