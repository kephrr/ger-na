package soft.afric.ger_na.data.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

@Table(name="regions")
public class Region extends AbstractEntity{
    @Column(unique = true, nullable = false, length = 50)
    private String libelle;
    @OneToMany(mappedBy = "region")
    private List<Zone> zones;
}
