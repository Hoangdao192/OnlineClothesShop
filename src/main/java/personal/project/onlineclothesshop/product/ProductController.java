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

    ProductService productService;

    @GetMapping(path = "/list", params = "categoryId")
    public List<Product> getProductByCategoryId(
            @RequestParam(required = true) long categoryId,
            @RequestParam(required = false) String orderBy,
            @RequestParam(required = false) String order
    ) {
        if (orderBy != null) {
            String sortBy = "";
            switch (orderBy) {
                case "name": sortBy = "productName"; break;
                case "price": sortBy = "productPrice"; break;
            }
            if (sortBy.compareTo("") != 0) {
                System.out.println(order);
                if (order != null && order.compareTo("des") == 0) {
                    System.out.println("call des");
                    return productService
                            .getProductByCategoryIdOrdered(
                                    categoryId,
                                    sortBy,
                                    order);
                } else {
                    return productService
                            .getProductByCategoryIdOrdered(
                                    categoryId,
                                    sortBy,
                                    "asc");
                }
            }
        }
        return productService.getProductByCategoryId(categoryId);
    }

    @GetMapping(path = "/list", params = "productTypeId")
    public List<Product> getProductByProductTypeId(
            @RequestParam(required = true) long productTypeId,
            @RequestParam(required = false) String orderBy,
            @RequestParam(required = false) String order
    ) {
        if (orderBy != null) {
            String sortBy = "";
            switch (orderBy) {
                case "name": sortBy = "productName"; break;
                case "price": sortBy = "productPrice"; break;
            }
            if (sortBy.compareTo("") != 0) {
                System.out.println(order);
                if (order != null && order.compareTo("des") == 0) {
                    System.out.println("call des");
                    return productService
                            .getProductByProductTypeIdOrdered(
                                    productTypeId,
                                    sortBy,
                                    order);
                } else {
                    return productService
                            .getProductByProductTypeIdOrdered(
                                    productTypeId,
                                    sortBy,
                                    "asc");
                }
            }
        }
        return productService.getProductByProductTypeId(productTypeId);
    }

    @GetMapping(path = "/list")
    public List<Product> getAllProduct(
            @RequestParam(required = false) String orderBy,
            @RequestParam(required = false) String order
    ) {
        if (orderBy != null) {
            String sortBy = "";
            switch (orderBy) {
                case "name": sortBy = "productName"; break;
                case "price": sortBy = "productPrice"; break;
            }
            if (sortBy.compareTo("") != 0) {
                System.out.println(order);
                if (order != null && order.compareTo("des") == 0) {
                    System.out.println("call des");
                    return productService
                            .getAllProductOrdered(
                                    sortBy,
                                    order);
                } else {
                    return productService
                            .getAllProductOrdered(
                                    sortBy,
                                    "asc");
                }
            }
        }
        return productService.getAllProduct();
    }

    @GetMapping(path = "/test")
    public List<Product> getAllProductTest() {
        return productService.getAllProduct(1, 8).toList();
    }

    public ProductService getProductService() {
        return productService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
