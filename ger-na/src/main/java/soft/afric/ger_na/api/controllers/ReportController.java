package soft.afric.ger_na.api.controllers;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import soft.afric.ger_na.api.dto.request.ReportCreateDto;

import java.util.Map;

public interface ReportController {
// LAMINE
    @GetMapping("/signalements/paginate")
    Map<Object, Object> reportsPaginate(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false) Long service,
            @RequestParam(required = false) Long zone,
            @RequestParam(required = false) Long region
    );

    @GetMapping("/signalements")
    Map<Object, Object> reports();

    @GetMapping("/signalements/{id}")
    Map<Object, Object> myReports(
            @PathVariable Long id
    );

    @PostMapping("/signalements")
    Map<Object, Object> save(
            @Valid @RequestBody ReportCreateDto reportDto,
            BindingResult bindingResult
    );
}
