package personal.project.onlineclothesshop.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(path = "/list")
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }
}
