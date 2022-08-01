package personal.project.onlineclothesshop.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategoryId(long categoryId);

    List<Product> findAllByCategoryId(long categoryId, Sort by);

    Page<Product> findAllByCategoryId(long categoryId, Pageable pageable);

    List<Product> findAllByProductTypeId(long productTypeId);

    List<Product> findAllByProductTypeId(long productTypeId, Sort by);

    Page<Product> findAllByProductTypeId(long productTypeId, Pageable pageable);
}
