package soft.afric.ger_na.api.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestController;
import soft.afric.ger_na.api.controllers.ZoneController;
import soft.afric.ger_na.api.dto.request.ZoneCreateDto;
import soft.afric.ger_na.api.dto.response.ZoneDto;
import soft.afric.ger_na.api.dto.response.rest.RestResponseDto;
import soft.afric.ger_na.data.entities.Region;
import soft.afric.ger_na.data.entities.Zone;
import soft.afric.ger_na.services.RegionService;
import soft.afric.ger_na.services.ZoneService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
public class ZoneControllerImpl implements ZoneController {
    private final ZoneService zoneService;
    private final RegionService regionService;

    @Override
    public Map<Object, Object> zones(int page, int size) {
        Page<ZoneDto> results = zoneService.findAll(PageRequest.of(page, size)).map(ZoneDto::toDto);
        return RestResponseDto.response(
                results.getContent(),
                new int[results.getTotalPages()],
                page,
                results.getTotalElements(),
                results.getTotalPages(),
                HttpStatus.OK
        );
    }

    @Override
    public Map<Object, Object> zonesByRegions(Long regionID) {
        Region region = regionService.show(regionID).orElse(null);
        List<Zone> datas = zoneService.findAllByRegion(region);
        List<ZoneDto> results = datas.stream().map(ZoneDto::toDto).toList();
        return RestResponseDto.response(
                results,
                HttpStatus.OK
        );
    }

    @Override
    public Map<Object, Object> save(ZoneCreateDto zoneDto, BindingResult bindingResult) {
        Map<Object, Object> response;
        if (bindingResult.hasErrors()){
            // Envoyer les erreurs en reponse
            Map<String, String> errors =new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()));
            response= RestResponseDto.response(errors, HttpStatus.NOT_ACCEPTABLE);
        }else{
            try {
                // Creer le signalement
                Zone zone = ZoneCreateDto.toEntity(zoneDto);
                Region region = regionService.show(zoneDto.getIdRegion()).orElseThrow(()->new RuntimeException("Region "+zoneDto.getIdRegion().toString()+" not found"));
                zone.setRegion(region);
                zoneService.save(zone);
                response= RestResponseDto.response(zoneDto,HttpStatus.CREATED);
            }catch (Exception e) {
                // Conflit de DTO
                response= RestResponseDto.response(zoneDto,HttpStatus.NOT_ACCEPTABLE);
                System.out.println(e.getMessage());
            }
        }
        return RestResponseDto.response(
                response,
                HttpStatus.OK
        );
    }
}
