package soft.afric.ger_na.api.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
                results.size(),
                HttpStatus.OK
        );
    }

    @Override
    public Map<Object, Object> regionsByPaginate(int page, int size) {
        Page<RegionDto> results = service.findAll(PageRequest.of(page, size)).map(RegionDto::toDto);
        return RestResponseDto.response(
                results.getContent(),
                new int[results.getTotalPages()],
                page,
                results.getTotalElements(),
                results.getTotalPages(),
                HttpStatus.OK
        );
    }
}
