package personal.project.onlineclothesshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import personal.project.onlineclothesshop.product.Product;
import personal.project.onlineclothesshop.product.ProductRepository;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Product product = productRepository.findAll().get(1);
        System.out.println(product);
    }
}
