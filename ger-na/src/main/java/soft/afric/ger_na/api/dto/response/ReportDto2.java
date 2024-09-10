package soft.afric.ger_na.api.dto.response;

import lombok.*;
import soft.afric.ger_na.data.entities.Report;

import java.text.SimpleDateFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportDto2 {
    private Long id;
    private String date;
    private String lieu;
    private String details;
    private Double montant;
    private String zone;
    private String service;
    private String region;

    public static ReportDto2 toDto(Report r){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return ReportDto2.builder()
                .id(r.getId())
                .date(sdf.format(r.getDate()))
                .lieu(r.getLieu())
                .details(r.getDetails())
                .montant(r.getMontant())
                .zone(r.getZone().getLibelle())
                .region(r.getRegion().getLibelle())
                .service(r.getService().getLibelle())
                .build();
    }
}
