package be.ephec.project_college_docs.daos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@ToString
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserDao extends Auditable{
    @Column(unique = true,updatable = false, nullable = false)
    private String userId;
    private String firstName;
    private String lastName;
    @Column(unique = true,updatable = false, nullable = false)
    private String email;
    private Integer loginAttempts;
    private LocalDateTime lastLogin;
    private String phone;
    private String bio;
    private String imageUrl;
    private boolean isAccountNotExpired;
    private boolean isAccountNotLocked;
    private boolean isAccountEnabled;
    private boolean mfaEnabled;
    @JsonIgnore
    private String qrCodeSecret;
    @Column(columnDefinition = "text") //more characters than default varchar
    private String qrCodeUri;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_role",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private RoleDao role;
}
