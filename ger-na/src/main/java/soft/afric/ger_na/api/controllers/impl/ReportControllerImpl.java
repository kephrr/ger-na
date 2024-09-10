package soft.afric.ger_na.api.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestController;
import soft.afric.ger_na.api.controllers.ReportController;
import soft.afric.ger_na.api.dto.request.ReportCreateDto;
import soft.afric.ger_na.api.dto.response.ReportDto;
import soft.afric.ger_na.api.dto.response.ReportDto2;
import soft.afric.ger_na.api.dto.response.rest.RestResponseDto;
import soft.afric.ger_na.data.entities.Region;
import soft.afric.ger_na.data.entities.Report;
import soft.afric.ger_na.data.entities.Service;
import soft.afric.ger_na.data.entities.Zone;
import soft.afric.ger_na.services.RegionService;
import soft.afric.ger_na.services.ReportService;
import soft.afric.ger_na.services.ServiceService;
import soft.afric.ger_na.services.ZoneService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequiredArgsConstructor
public class ReportControllerImpl implements ReportController {
    private final ReportService reportService;
    private final ServiceService serviceService;
    private final RegionService regionService;
    private final ZoneService zoneService;

    @Override
    public Map<Object, Object> reportsPaginate(
        int page,
        int size,
        Long service,
        Long zone,
        Long region
    ) {
            Service service1 = serviceService.show(service).orElse(null);
            Zone zone1 = zoneService.show(zone).orElse(null);
            Region region1 = regionService.show(region).orElse(null);
            Page<Report> datas = reportService.findAllByServiceAndRegionAndZone(PageRequest.of(page, size),service1,region1,zone1);
            Page<ReportDto> results = datas.map(ReportDto::toDto);
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
    public Map<Object, Object> reports(
            int page,
            int size,
            Long service,
            Long zone,
            Long region
    ) {
        Service service1 = serviceService.show(service).orElse(null);
        Zone zone1 = zoneService.show(zone).orElse(null);
        Region region1 = regionService.show(region).orElse(null);
        Page<Report> datas = reportService.findAllByServiceAndRegionAndZone(PageRequest.of(page, size),service1,region1,zone1);
        Page<ReportDto2> results = datas.map(ReportDto2::toDto);
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
    public Map<Object, Object> myReports(Long id) {
            Report report = reportService.show(id).orElseThrow(()->new RuntimeException("Report "+id.toString()+" not found"));
            ReportDto2 results = ReportDto2.toDto(report);
            return RestResponseDto.response(
                    results,
                    HttpStatus.OK
            );
    }

    @Override
    public Map<Object, Object> save(ReportCreateDto reportDto, BindingResult bindingResult) {
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
                Report report = ReportCreateDto.toEntity(reportDto);
                Zone zone = zoneService.show(reportDto.getZone()).orElseThrow(()->new RuntimeException("Zone "+reportDto.getZone()+" not found"));
                report.setRegion(zone.getRegion());
                report.setZone(zone);
                report.setService(serviceService.show(reportDto.getService()).orElseThrow(()->new RuntimeException("Service "+reportDto.getService()+" not found")));
                reportService.save(report);
                response= RestResponseDto.response(reportDto,HttpStatus.CREATED);
            }catch (Exception e) {
                // Conflit de DTO
                response= RestResponseDto.response(reportDto,HttpStatus.NOT_ACCEPTABLE);
                System.out.println(e.getMessage());
            }
        }
        return RestResponseDto.response(
                response,
                HttpStatus.OK
        );
    }
}
