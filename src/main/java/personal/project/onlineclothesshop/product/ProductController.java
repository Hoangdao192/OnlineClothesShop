package personal.project.onlineclothesshop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(path = "/api/product")
public class ProductController {

    ProductService productService;

    /**
     * <p>This method's return value will be automated convert to JSON by Spring</p>
     *
     *  @return
     *  <br>JSON: {
     *          <br>"page": current page,
     *          <br>"numberOfPage": int,
     *          <br>"products": [
     *              array of products
     *          ]
     *     <br>}
     */
    @GetMapping(path = "/list", params = "categoryId")
    public Map<String, Object> getProductByCategoryId(
            @RequestParam(required = true) long categoryId,
            @RequestParam(required = false) String orderBy,
            @RequestParam(required = false, defaultValue = "asc") String order,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "9") int perPage
    ) {
        Page<Product> productPage = null;
        if (orderBy != null) {
            String sortBy = "";
            switch (orderBy) {
                case "name": sortBy = "productName"; break;
                case "price": sortBy = "productPrice"; break;
            }
            if (!sortBy.equals("")) {
                if (order != null && (order.equals("des") || order.equals("asc"))) {
                    productPage = productService
                            .getProductByCategoryIdOrdered(
                                    categoryId,
                                    sortBy,
                                    order, page, perPage);
                }
            }
        } else {
            productPage = productService.getProductByCategoryId(categoryId, page, perPage);
        }

        //  Mapping data for JSON
        Map<String, Object> result = new HashMap<>();
        result.put("products", productPage.stream().toList());
        result.put("page", productPage.getPageable().getPageNumber());
        result.put("numberOfPage", productPage.getTotalPages());
        return result;
    }

    /**
     * <i>/api/list?productTypedId=?</i>
     * <p>This method's return value will be automated convert to JSON by Spring</p>
     *
     *  @return
     *  <br>JSON: {
     *          <br>"page": current page,
     *          <br>"numberOfPage": int,
     *          <br>"products": [
     *              array of products
     *          ]
     *     <br>}
     */
    @GetMapping(path = "/list", params = "productTypeId")
    public Map<String, Object> getProductByProductTypeId(
            @RequestParam(required = true) long productTypeId,
            @RequestParam(required = false) String orderBy,
            @RequestParam(required = false, defaultValue = "asc") String order,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "9") int perPage
    ) {
        Page<Product> productPage = null;
        if (orderBy != null) {
            String sortBy = "";
            switch (orderBy) {
                case "name": sortBy = "productName"; break;
                case "price": sortBy = "productPrice"; break;
            }
            if (sortBy.compareTo("") != 0) {
                if (order != null && (order.equals("asc") || order.equals("des"))) {
                    productPage = productService
                            .getProductByProductTypeIdOrdered(
                                    productTypeId,
                                    sortBy,
                                    order, page, perPage);
                }
            }
        } else {
            productPage = productService.getProductByProductTypeId(productTypeId, page, perPage);
        }

        //  Mapping data for JSON
        Map<String, Object> result = new HashMap<>();
        result.put("products", productPage.stream().toList());
        result.put("page", productPage.getPageable().getPageNumber());
        result.put("numberOfPage", productPage.getTotalPages());
        return result;
    }

    @GetMapping(path = "/list")
    public Map<String, Object> getAllProduct(
            @RequestParam(required = false) String orderBy,
            @RequestParam(required = false, defaultValue = "asc") String order,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "9") int perPage
    ) {
        Page<Product> productPage = null;
        if (orderBy != null) {
            String sortBy = "";
            switch (orderBy) {
                case "name": sortBy = "productName"; break;
                case "price": sortBy = "productPrice"; break;
            }
            if (sortBy.compareTo("") != 0) {
                if (order != null && (order.equals("des") || order.equals("asc"))) {
                    productPage = productService.getAllProductOrdered(sortBy, order, page, perPage);
                }
            }
        } else {
            productPage = productService.getAllProduct(page, perPage);
        }

        //  Mapping data for JSON
        Map<String, Object> result = new HashMap<>();
        result.put("products", productPage.stream().toList());
        result.put("page", productPage.getPageable().getPageNumber());
        result.put("numberOfPage", productPage.getTotalPages());
        return result;
    }

    public ProductService getProductService() {
        return productService;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
}
