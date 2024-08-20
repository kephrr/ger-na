package soft.afric.ger_na.api.controllers;


import org.springframework.web.bind.annotation.*;
import soft.afric.ger_na.api.dto.request.ReportCreateDto;

import java.util.Map;


public interface MainController {
    @GetMapping("/regions")
    Map<Object, Object> regions();

    @GetMapping("/zones")
    Map<Object, Object> zones();

    @GetMapping("/services")
    Map<Object, Object> services();


    @GetMapping("/reports")
    Map<Object, Object> reports(
            @RequestParam Long idService,
            @RequestParam Long idRegion,
            @RequestParam Long idZone
    );

    @GetMapping("{id}/reports")
    Map<Object, Object> myReports(
            @PathVariable Long id
    );

    @PostMapping("/save")
    Map<Object, Object> save(
            @RequestBody ReportCreateDto reportDto
    );
    /*
    @RequestBody RendezVousCreateDto rendezVous
    @GetMapping("/regions/{id}")
    Map<Object, Object> regions(
            @PathVariable Long id
    );*/
}
