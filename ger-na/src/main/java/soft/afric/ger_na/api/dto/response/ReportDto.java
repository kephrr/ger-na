package soft.afric.ger_na.api.dto.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.*;
import soft.afric.ger_na.data.entities.Report;
import soft.afric.ger_na.data.entities.Service;
import soft.afric.ger_na.data.entities.User;
import soft.afric.ger_na.data.entities.Zone;
import soft.afric.ger_na.data.enums.EtatReport;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportDto {
    private String date;
    private String lieu;
    private String details;
    private Double montant;
    private String etat;
    private String user;
    private String zone;
    private String service;

    public static ReportDto toDto(Report r){
        return ReportDto.builder()
                .date(r.getDate().toString())
                .lieu(r.getLieu())
                .details(r.getDetails())
                .montant(r.getMontant())
                .etat(r.getEtat().toString())
                .user(r.getUser().getNom())
                .zone(r.getZone().getLibelle())
                .service(r.getService().getLibelle())
                .build();
    }
}
