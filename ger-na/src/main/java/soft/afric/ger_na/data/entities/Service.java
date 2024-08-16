package soft.afric.ger_na.data.entities;

import jakarta.persistence.Column;
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
@Table(name="services")
public class Service extends AbstractEntity{
    @Column(unique = true, nullable = false, length = 50)
    private String libelle;

    @OneToMany(mappedBy = "service")
    private List<Report> report;
}
