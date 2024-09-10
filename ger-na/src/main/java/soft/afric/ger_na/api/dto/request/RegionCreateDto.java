package soft.afric.ger_na.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import soft.afric.ger_na.data.entities.Region;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegionCreateDto {
    @NotBlank(message = "Le libelle est obligatoire")
    private String libelle;

    public static Region toEntity(RegionCreateDto dto){
        return Region.builder()
                .libelle(dto.getLibelle())
                .build();
    }
}
