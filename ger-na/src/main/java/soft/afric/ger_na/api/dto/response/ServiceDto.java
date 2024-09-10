package soft.afric.ger_na.api.dto.response;

import lombok.*;
import soft.afric.ger_na.data.entities.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceDto {
    private Long id;
    private String libelle;
    public static ServiceDto toDto(Service service){
        return ServiceDto.builder()
                .id(service.getId())
                .libelle(service.getLibelle())
                .build();
    }
}
