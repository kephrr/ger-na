package soft.afric.ger_na.api.dto.response;

import lombok.*;
import soft.afric.ger_na.data.entities.Region;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegionDto {
    private Long id;
    private String libelle;

    public static RegionDto toDto(Region region){
        return RegionDto.builder()
                .id(region.getId())
                .libelle(region.getLibelle())
                .build();
    }
}
