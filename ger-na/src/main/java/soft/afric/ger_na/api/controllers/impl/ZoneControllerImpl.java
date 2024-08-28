package soft.afric.ger_na.api.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import soft.afric.ger_na.api.controllers.ZoneController;
import soft.afric.ger_na.api.dto.response.ZoneDto;
import soft.afric.ger_na.api.dto.response.rest.RestResponseDto;
import soft.afric.ger_na.services.ZoneService;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ZoneControllerImpl implements ZoneController {
    private final ZoneService service;
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
        return Map.of();
    }

    @Override
    public Map<Object, Object> zonesByRegions(Long id) {
        List<ZoneDto> results = service.findAll().stream()
                .filter(z -> Objects.equals(z.getRegion().getId(), id))
                .map(ZoneDto::toDto)
                .collect(Collectors.toList());
        return RestResponseDto.response(
                results,
                HttpStatus.OK
        );
    }
}
