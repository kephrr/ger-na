package soft.afric.ger_na.api.dto.response;


import lombok.*;
import soft.afric.ger_na.data.entities.Zone;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ZoneDto {
    private String libelle;
    private Long id;
    public static ZoneDto toDto(Zone zone){
        return ZoneDto.builder()
                .id(zone.getId())
                .libelle(zone.getLibelle())
                .build();
    }
}