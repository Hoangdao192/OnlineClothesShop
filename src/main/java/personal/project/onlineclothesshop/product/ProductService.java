package personal.project.onlineclothesshop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public List<Product> getProductByCategoryId(long categoryId) {
        return productRepository.findAllByCategoryId(categoryId);
    }

    public List<Product> getProductByProductTypeId(long productTypeId) {
        return productRepository.findAllByProductTypeId(productTypeId);
    }
}
