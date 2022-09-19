package personal.project.onlineclothesshop.producttype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeService {
    @Autowired
    private ProductTypeRepository productTypeRepository;

    public List<ProductType> getAllProductType() {
        return productTypeRepository.findAll();
    }

    public List<ProductType> getProductTypeByCategory(long categoryId) {
        return productTypeRepository.findProductTypeByCategoryId(categoryId);
    }
}
