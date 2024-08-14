package soft.afric.ger_na.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Table(name="zones")
public class Zone extends AbstractEntity{
    @Column(unique = true, nullable = false, length = 50)
    private String libelle;
    @ManyToOne
    private Region region;
    @OneToMany(mappedBy = "zone")
    private List<Report> report;
}
