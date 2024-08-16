package soft.afric.ger_na.api.dto.request;

import soft.afric.ger_na.data.entities.Report;

import java.util.Date;

public class ReportCreateDto {
    private String libelle;
    private Date date;
    private String region;
    private String zone;
    private Double montant;

    public static Report toEntity(){
        return Report.builder().build();
    }
}
