package soft.afric.ger_na.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import soft.afric.ger_na.data.enums.EtatReport;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Table(name="reports")
public class Report extends AbstractEntity{
    private Date date;
    private Double montant;
    @Enumerated(value = EnumType.STRING)
    private EtatReport etat;
    @ManyToOne
    private Zone zone;
    @ManyToOne
    private Service service;
}
