package soft.afric.ger_na.api.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import soft.afric.ger_na.api.controllers.ZoneController;
import soft.afric.ger_na.api.dto.response.ServiceDto;
import soft.afric.ger_na.api.dto.response.ZoneDto;
import soft.afric.ger_na.api.dto.response.rest.RestResponseDto;
import soft.afric.ger_na.services.RegionService;
import soft.afric.ger_na.services.ZoneService;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ZoneControllerImpl implements ZoneController {
    private final ZoneService service;
    private final RegionService regionService;
    @Override
    public Map<Object, Object> zones() {
        List<ZoneDto> results = service.findAll().stream()
                .map(ZoneDto::toDto).toList();
        return RestResponseDto.response(
                results,
                HttpStatus.OK
        );
    }

    @Override
    public Map<Object, Object> zones(int page, int size) {
        Page<ZoneDto> results = service.findAll(PageRequest.of(page, size)).map(ZoneDto::toDto);
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
    public Map<Object, Object> zonesByRegions(Long id) {
        List<ZoneDto> results;
        if(regionService.findById(id)!=null){
            results = service.findAll().stream()
                    .filter(z -> Objects.equals(z.getRegion().getId(), id))
                    .map(ZoneDto::toDto)
                    .toList();
        }else{
            results = service.findAll().stream()
                    .map(ZoneDto::toDto).toList();
        }
        return RestResponseDto.response(
                results,
                results.size(),
                HttpStatus.OK
        );
    }
}
