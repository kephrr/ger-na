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
import soft.afric.ger_na.api.dto.response.rest.RestResponseDto;
import soft.afric.ger_na.data.entities.Region;
import soft.afric.ger_na.data.entities.Report;
import soft.afric.ger_na.data.entities.Service;
import soft.afric.ger_na.data.entities.Zone;
import soft.afric.ger_na.services.RegionService;
import soft.afric.ger_na.services.ReportService;
import soft.afric.ger_na.services.ServiceService;
import soft.afric.ger_na.services.ZoneService;

import javax.swing.plaf.basic.BasicButtonUI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.stream;


@RestController
@RequiredArgsConstructor
public class ReportControllerImpl implements ReportController {
    private final ReportService service;
    private final ServiceService serviceService;
    private final RegionService regionService;
    private final ZoneService zoneService;

    @Override
    public Map<Object, Object> reportsPaginate(int page, int size, Long idService, Long idZone, Long idRegion) {
        /*Service serviceFilter = serviceService.show(idService).orElse(null);
        Region regionFilter = regionService.show(idRegion).orElse(null);
        Zone zoneFilter = zoneService.show(idZone).orElse(null);*/
        Service serviceFilter=null;
        Region regionFilter=null;
        Zone zoneFilter=null;
        if (idService != null) {
            serviceFilter = serviceService.show(idService).orElse(null);
        }
        if (idRegion != null) {
            regionFilter = regionService.show(idRegion).orElse(null);
        }
        if (idZone != null) {
            zoneFilter = zoneService.show(idZone).orElse(null);
        }

        Page<ReportDto> results = service.findAllByServiceAndRegionAndZoneAndPage(
                PageRequest.of(page,size),
                serviceFilter, regionFilter, zoneFilter
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

    @Override
    public Map<Object, Object> reports() {
        List<ReportDto> results = service.findAll().stream().map(ReportDto::toDto).toList();
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

    @Override
    public Map<Object, Object> save(ReportCreateDto reportDto, BindingResult bindingResult) {
        Map<Object, Object> response;
        if (bindingResult.hasErrors()){
            // Envoyer les erreurs en reponse
            Map<String, String> errors =new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()));
            response= RestResponseDto.response(errors, HttpStatus.NOT_FOUND);
        }else{
            try {
                // Creer le signalement
                Report report = ReportCreateDto.toEntity(reportDto);
                Zone zone = zoneService.findById(reportDto.getZone());
                report.setRegion(zone.getRegion());
                report.setZone(zone);
                report.setService(serviceService.findById(reportDto.getService()));

                service.save(report);
                response= RestResponseDto.response(reportDto,HttpStatus.CREATED);
            }catch (Exception e) {
                // Conflit de DTO
                response= RestResponseDto.response(reportDto,HttpStatus.CONFLICT);
                System.out.println(e.getMessage());
            }
        }
            //Report report = ReportCreateDto.toEntity(reportDto);
            return RestResponseDto.response(
                    response,
                    HttpStatus.OK
            );
    }
}
