package soft.afric.ger_na.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import soft.afric.ger_na.data.entities.Report;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportCreateDto {
    private  Long id;
    private String details;
    private Date date;
    private String region;
    private String zone;
    private Double montant;
    private String service;

    public static Report toEntity(ReportCreateDto dto){
        return Report.builder()
                .details(dto.getDetails())
                .date(dto.getDate())
                .montant(dto.getMontant())
                .build();
    }
}
