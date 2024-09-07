package soft.afric.ger_na.api.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import soft.afric.ger_na.data.entities.Report;
import soft.afric.ger_na.data.enums.EtatReport;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportCreateDto {
    private String details;
    private String lieu;
    @NotNull
    @Min(0)
    private Double montant;
    @NotNull(message = "La date est obligatoire")
    private Date date;
    @NotNull
    @Min(value=1, message = "La zone du signalement est obligatoire")
    private Long zone;
    @NotNull
    @Min(value=1,message = "Le service du signalement est obligatoire")
    private Long service;

    public static Report toEntity(ReportCreateDto dto){
        return Report.builder()
                .details(dto.getDetails())
                .date(dto.getDate())
                .montant(dto.getMontant())
                .lieu(dto.getLieu())
                .etat(EtatReport.Active)
                .build();
    }
}
