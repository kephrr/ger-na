package soft.afric.ger_na.api.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import soft.afric.ger_na.data.entities.Service;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceCreateDto {
    @NotBlank(message = "Le libelle est obligatoire")
    private String libelle;

    public static Service toEntity(ServiceCreateDto dto){
        return Service.builder()
                .libelle(dto.getLibelle())
                .build();
    }
}
