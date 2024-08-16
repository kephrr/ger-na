package soft.afric.ger_na.data.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="zones")
public class Zone extends AbstractEntity{
    @Column(unique = true, nullable = false, length = 100)
    private String libelle;
    @ManyToOne
    private Region region;
    @OneToMany(mappedBy = "zone")
    private List<Report> report;
}
