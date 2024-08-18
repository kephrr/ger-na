package soft.afric.ger_na.api.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import soft.afric.ger_na.api.controllers.MainController;
import soft.afric.ger_na.api.dto.request.ReportCreateDto;
import soft.afric.ger_na.api.dto.response.RegionDto;
import soft.afric.ger_na.api.dto.response.ReportDto;
import soft.afric.ger_na.api.dto.response.ServiceDto;
import soft.afric.ger_na.api.dto.response.ZoneDto;
import soft.afric.ger_na.api.dto.response.rest.RestResponseDto;
import soft.afric.ger_na.data.entities.Region;
import soft.afric.ger_na.services.RegionService;
import soft.afric.ger_na.services.ReportService;
import soft.afric.ger_na.services.ServiceService;
import soft.afric.ger_na.services.ZoneService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MainControllerImpl implements MainController {
    private final RegionService regionService;
    private final ZoneService zonesService;
    private final ServiceService service;
    private final ReportService reportService;
    @Override
    public Map<Object, Object> regions() {
        List<RegionDto> results = regionService.findAll().stream()
                .map(RegionDto::toDto)
                .collect(Collectors.toList());
        return RestResponseDto.response(
                results,
                HttpStatus.OK
        );
    }

    @Override
    public Map<Object, Object> zones() {
        List<ZoneDto> results = zonesService.findAll().stream()
                .map(ZoneDto::toDto)
                .collect(Collectors.toList());
        return RestResponseDto.response(
                results,
                HttpStatus.OK
        );
    }

    @Override
    public Map<Object, Object> services() {
        List<ServiceDto> results = service.findAll().stream()
                .map(ServiceDto::toDto)
                .collect(Collectors.toList());
        return RestResponseDto.response(
                results,
                HttpStatus.OK
        );
    }

    @Override
    public Map<Object, Object> reports() {
        List<ReportDto> results = reportService.findAll().stream()
                .map(ReportDto::toDto)
                .collect(Collectors.toList());
        return RestResponseDto.response(
                results,
                HttpStatus.OK
        );
    }

    @Override
    public Map<Object, Object> myReports(Long id) {
        List<ReportDto> results = reportService.findAllByUser(id).stream()
                .map(ReportDto::toDto)
                .collect(Collectors.toList());
        return RestResponseDto.response(
                results,
                HttpStatus.OK
        );
    }

    @Override
    public Map<Object, Object> save(ReportCreateDto reportDto) {
        return RestResponseDto.response(
                "crée avec succès",
                HttpStatus.OK
        );
    }
}
