package personal.project.onlineclothesshop.productcolor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductColorRepository extends JpaRepository<ProductColor, Long> {
}
