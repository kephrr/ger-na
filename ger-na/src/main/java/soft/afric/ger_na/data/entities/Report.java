package soft.afric.ger_na.data.entities;

import jakarta.persistence.*;
import lombok.*;
import soft.afric.ger_na.data.enums.EtatReport;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="reports")
public class Report extends AbstractEntity{
    private Date date;
    private Double montant;
    private String details;
    @Column(nullable = true, unique = true, length = 50)
    private String telephone;
    private String lieu;
    @Enumerated(value = EnumType.STRING)
    private EtatReport etat;
    @ManyToOne
    private Zone zone;
    @ManyToOne
    private Service service;
    @ManyToOne
    private Region region;
}
