package personal.project.onlineclothesshop.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users_role")
public class UserRole implements Serializable {
    @Id
    private Long userId;
    @Id
    private Long roleId;
}
