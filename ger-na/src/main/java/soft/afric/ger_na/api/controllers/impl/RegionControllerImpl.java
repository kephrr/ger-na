package soft.afric.ger_na.api.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import soft.afric.ger_na.api.controllers.RegionController;
import soft.afric.ger_na.api.dto.response.RegionDto;
import soft.afric.ger_na.api.dto.response.rest.RestResponseDto;
import soft.afric.ger_na.services.RegionService;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RegionControllerImpl implements RegionController {
    private final RegionService service;
    @Override
    public Map<Object, Object> regions() {
        List<RegionDto> results = service.findAll().stream()
                .map(RegionDto::toDto).toList();
        return RestResponseDto.response(
                results,
                HttpStatus.OK
        );
    }

    @Override
    public Map<Object, Object> regions(int page, int size) {
        return Map.of();
    }
}
