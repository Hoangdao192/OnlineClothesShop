package personal.project.onlineclothesshop.productcolor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductColorService {
    ProductColorRepository productColorRepository;

    public ProductColorRepository getProductColorRepository() {
        return productColorRepository;
    }

    @Autowired
    public void setProductColorRepository(ProductColorRepository productColorRepository) {
        this.productColorRepository = productColorRepository;
    }
}
