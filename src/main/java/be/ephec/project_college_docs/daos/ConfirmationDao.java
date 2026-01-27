package be.ephec.project_college_docs.daos;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "confirmations")
@ToString
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ConfirmationDao extends Auditable{
    private String code;
    @OneToOne(targetEntity = UserDao.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("user_id")
    private UserDao user;

    public ConfirmationDao(UserDao user){
        this.code = UUID.randomUUID().toString();
        this.user = user;
    }
}
