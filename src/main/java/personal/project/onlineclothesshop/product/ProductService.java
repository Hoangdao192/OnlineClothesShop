package personal.project.onlineclothesshop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    public List<Product> getAllProductOrdered(String orderBy, String order) {
        Sort sort = createSort(orderBy, order);
        return productRepository.findAll(sort);
    }

    public List<Product> getProductByCategoryId(long categoryId) {
        return productRepository.findAllByCategoryId(categoryId);
    }

    public List<Product> getProductByCategoryIdOrdered(
            long categoryId, String orderBy, String order
    ) {
        Sort sort = createSort(orderBy, order);
        return productRepository.findAllByCategoryId(categoryId, sort);
    }

    public List<Product> getProductByProductTypeId(long productTypeId) {
        return productRepository.findAllByProductTypeId(productTypeId);
    }

    public List<Product> getProductByProductTypeIdOrdered(
            long productTypeId, String orderBy, String order
    ) {
        Sort sort = createSort(orderBy, order);
        return productRepository.findAllByProductTypeId(productTypeId, sort);
    }

    public Page<Product> getAllProduct(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "productName"));
        return productRepository.findAll(pageable);
    }

    public Page<Product> getAllProductOrdered(String orderBy, String order, int page, int size) {
        Sort sort = createSort(orderBy, order);
        Pageable pageable = PageRequest.of(page, size, sort);
        return productRepository.findAll(pageable);
    }

    public Page<Product> getProductByCategoryId(long categoryId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAllByCategoryId(categoryId, pageable);
    }

    public Page<Product> getProductByCategoryIdOrdered(
            long categoryId, String orderBy, String order, int page, int size
    ) {
        Sort sort = createSort(orderBy, order);
        Pageable pageable = PageRequest.of(page, size, sort);
        return productRepository.findAllByCategoryId(categoryId, pageable);
    }

    public Page<Product> getProductByProductTypeId(long productTypeId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return productRepository.findAllByProductTypeId(productTypeId, pageable);
    }

    public Page<Product> getProductByProductTypeIdOrdered(
            long productTypeId, String orderBy, String order, int page, int size
    ) {
        Sort sort = createSort(orderBy, order);
        Pageable pageable = PageRequest.of(page, size, sort);
        return productRepository.findAllByProductTypeId(productTypeId, pageable);
    }

    /*
    *   Checking and creating Sort from orderBy and order
    */
    private Sort createSort(String orderBy, String order) {
        Sort sort = Sort.by(Sort.Direction.ASC, orderBy);
        if (order != null && order.equals("des")) {
            sort = Sort.by(Sort.Direction.DESC, orderBy);
        }
        return sort;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
