package personal.project.onlineclothesshop.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserInformationRepository extends JpaRepository<UserInformation, Long> {
    boolean existsByEmail(String email);
}
