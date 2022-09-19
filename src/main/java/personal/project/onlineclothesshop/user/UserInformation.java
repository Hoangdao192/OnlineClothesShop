package personal.project.onlineclothesshop.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInformation {
    @Id
    private Long userId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    private Integer age;
    @Column(unique = true, name = "email")
    private String email;
    private String gender;
    @Column(unique = true, name = "phoneNumber")
    private String phoneNumber;
    private String address;
    @Column(name = "dateOfBirth")
    private LocalDateTime dateOfBirth;
}
