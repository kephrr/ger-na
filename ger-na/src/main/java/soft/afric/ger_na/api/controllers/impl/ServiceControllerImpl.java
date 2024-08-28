package soft.afric.ger_na.api.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import soft.afric.ger_na.api.controllers.ServiceController;
import soft.afric.ger_na.api.dto.response.ServiceDto;
import soft.afric.ger_na.api.dto.response.rest.RestResponseDto;
import soft.afric.ger_na.services.ServiceService;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ServiceControllerImpl implements ServiceController {
    private final ServiceService service;
    @Override
    public Map<Object, Object> services() {
        List<ServiceDto> results = service.findAll().stream()
                .map(ServiceDto::toDto).toList();
        return RestResponseDto.response(
                results,
                HttpStatus.OK
        );
    }

    @Override
    public Map<Object, Object> services(int page, int size) {
        return Map.of();
    }
}
