package personal.project.onlineclothesshop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

    public List<Product> getProductByCategoryIdOrdered(
            long categoryId, String orderBy, String order
    ) {
        switch (order) {
            case "asc":
                return productRepository
                        .findAllByCategoryId(categoryId, Sort.by(Sort.Direction.ASC, orderBy));
            case "des":
                return productRepository
                        .findAllByCategoryId(categoryId, Sort.by(Sort.Direction.DESC, orderBy));
        }
        return productRepository.findAllByCategoryId(categoryId);
    }

    public List<Product> getProductByProductTypeId(long productTypeId) {
        return productRepository.findAllByProductTypeId(productTypeId);
    }

    public List<Product> getProductByProductTypeIdOrdered(
            long productTypeId, String orderBy, String order
    ) {
        switch (order) {
            case "asc":
                return productRepository
                        .findAllByProductTypeId(productTypeId, Sort.by(Sort.Direction.ASC, orderBy));
            case "des":
                return productRepository
                        .findAllByProductTypeId(productTypeId, Sort.by(Sort.Direction.DESC, orderBy));
        }
        return productRepository.findAllByProductTypeId(productTypeId);
    }
}
