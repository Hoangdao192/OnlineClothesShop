package personal.project.onlineclothesshop.producttype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    List<ProductType> findProductTypeByCategoryId(long categoryId);
}
