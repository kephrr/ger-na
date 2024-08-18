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
    private String libelle;
    private Date date;
    private String region;
    private String zone;
    private Double montant;

    public static Report toEntity(){
        return Report.builder().build();
    }
}
