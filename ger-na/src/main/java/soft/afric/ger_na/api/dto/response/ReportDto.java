package soft.afric.ger_na.api.dto.response;

import lombok.*;
import soft.afric.ger_na.data.entities.Report;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportDto {
    private Long id;
    private String date;
    private String lieu;
    private String details;
    private Double montant;
    private String etat;
    private String telephone;
    private String zone;
    private String service;
    private String region;

    public static ReportDto toDto(Report r){
        return ReportDto.builder()
                .date(r.getDate().toString())
                .lieu(r.getLieu())
                .details(r.getDetails())
                .montant(r.getMontant())
                .etat(r.getEtat().toString())
                .region(r.getRegion().getLibelle())
                .zone(r.getZone().getLibelle())
                .service(r.getService().getLibelle())
                .build();
    }
}
