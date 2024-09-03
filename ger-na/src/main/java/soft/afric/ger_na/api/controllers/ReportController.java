package soft.afric.ger_na.api.controllers;

import org.springframework.web.bind.annotation.*;
import soft.afric.ger_na.api.dto.request.ReportCreateDto;

import java.util.Map;

public interface ReportController {
// ABDOULAYE
    @GetMapping("/signalements/paginate")
    Map<Object, Object> reports(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "0" ) Long service,
            @RequestParam(defaultValue = "0" ) Long region,
            @RequestParam(defaultValue = "0" ) Long zone
    );

    @GetMapping("/signalements")
    Map<Object, Object> reports(
            @RequestParam(defaultValue = "0" ) Long service,
            @RequestParam(defaultValue = "0" ) Long region,
            @RequestParam(defaultValue = "0" ) Long zone
    );

    @GetMapping("/signalements/{id}")
    Map<Object, Object> myReports(
            @PathVariable Long id
    );

    @PostMapping("/signalements")
    Map<Object, Object> save(
            @RequestBody ReportCreateDto reportDto
    );
}
