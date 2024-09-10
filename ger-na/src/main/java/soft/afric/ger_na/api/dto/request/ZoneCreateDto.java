package soft.afric.ger_na.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import soft.afric.ger_na.data.entities.Zone;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ZoneCreateDto {
    @NotBlank(message = "Le libelle est obligatoire")
    private String libelle;
    @NotNull(message = "La région est obligatoire")
    private Long idRegion;

    public static Zone toEntity(ZoneCreateDto dto){
        return Zone.builder()
                .libelle(dto.getLibelle())
                .build();
    }
}
