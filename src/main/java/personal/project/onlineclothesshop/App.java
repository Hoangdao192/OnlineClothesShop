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

        CategoryService categoryService = context.getBean(CategoryService.class);
        System.out.println(categoryService.getAllCategory().get(0).toString());

        ProductTypeService productTypeService = context.getBean(ProductTypeService.class);
        System.out.println(productTypeService.getAllProductType().get(0));
    }
}
