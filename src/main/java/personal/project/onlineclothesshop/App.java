package personal.project.onlineclothesshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import personal.project.onlineclothesshop.category.CategoryService;
import personal.project.onlineclothesshop.producttype.ProductTypeService;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);
    }
}
