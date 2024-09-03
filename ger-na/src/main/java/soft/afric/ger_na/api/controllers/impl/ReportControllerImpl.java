package soft.afric.ger_na.api.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import soft.afric.ger_na.api.controllers.ReportController;
import soft.afric.ger_na.api.dto.request.ReportCreateDto;
import soft.afric.ger_na.api.dto.response.ReportDto;
import soft.afric.ger_na.api.dto.response.rest.RestResponseDto;
import soft.afric.ger_na.data.entities.Report;
import soft.afric.ger_na.services.RegionService;
import soft.afric.ger_na.services.ReportService;
import soft.afric.ger_na.services.ServiceService;
import soft.afric.ger_na.services.ZoneService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;


@RestController
@RequiredArgsConstructor
public class ReportControllerImpl implements ReportController {
    private final ReportService service;
    private final ServiceService serviceService;
    private final RegionService regionService;
    private final ZoneService zoneService;
    // ABDOULAYE
    @Override
    public Map<Object, Object> reports(int page, int size, Long idService, Long idRegion, Long idZone) {
        Page<ReportDto> results = service.findAllByFiltersAndPaginate(
             serviceService.findById(idService),
             regionService.findById(idRegion),
             zoneService.findById(idZone),
                PageRequest.of(page,size)
        ).map(ReportDto::toDto);
        return RestResponseDto.response(
                results.getContent(),
                new int[results.getTotalPages()],
                page,
                results.getTotalElements(),
                results.getTotalPages(),
                HttpStatus.OK
        );
    }
    // ABDOULAYE
    @Override
    public Map<Object, Object> reports(Long idService, Long idRegion, Long idZone) {
        List<ReportDto> results = service.findAllByFilters(
                serviceService.findById(idService),
                regionService.findById(idRegion),
                zoneService.findById(idZone)
        ).stream().map(ReportDto::toDto).toList();
        return RestResponseDto.response(
                results,
                results.size(),
                HttpStatus.OK
        );
    }

    @Override
    public Map<Object, Object> myReports(Long id) {
            Report report = service.findById(id);
            ReportDto results=null;
            if(report!=null) results = ReportDto.toDto(report);
            return RestResponseDto.response(
                    results,
                    HttpStatus.OK
            );
    }
    // ABDOULAYE
    @Override
    public Map<Object, Object> save(ReportCreateDto reportDto) {
            Report report = ReportCreateDto.toEntity(reportDto);
            return RestResponseDto.response(
                    report,
                    HttpStatus.OK
            );
    }
}
