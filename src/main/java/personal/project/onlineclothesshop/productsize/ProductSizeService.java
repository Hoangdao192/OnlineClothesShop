package personal.project.onlineclothesshop.productsize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSizeService {
    ProductSizeRepository productSizeRepository;

    public ProductSizeRepository getProductSizeRepository() {
        return productSizeRepository;
    }

    @Autowired
    public void setProductSizeRepository(ProductSizeRepository productSizeRepository) {
        this.productSizeRepository = productSizeRepository;
    }
}
