package soft.afric.ger_na.api.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import soft.afric.ger_na.api.controllers.ReportController;
import soft.afric.ger_na.api.dto.request.ReportCreateDto;
import soft.afric.ger_na.api.dto.response.ReportDto;
import soft.afric.ger_na.api.dto.response.rest.RestResponseDto;
import soft.afric.ger_na.data.entities.Report;
import soft.afric.ger_na.services.ReportService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
public class ReportControllerImpl implements ReportController {
    private final ReportService reportService;
    // ABDOULAYE
    @Override
    public Map<Object, Object> reports(int page, int size, Long service, Long region, Long zone) {
        return Map.of();
    }
    // ABDOULAYE
    @Override
    public Map<Object, Object> reports(Long service, Long region, Long zone) {
        return Map.of();
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
