package soft.afric.ger_na.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="users")
public class User extends AbstractEntity{
    private String nom;
    private String telephone;

    @OneToMany(mappedBy = "user")
    private List<Report> report;
}
