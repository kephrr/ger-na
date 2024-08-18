package soft.afric.ger_na.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    Map<Object, Object> reports();

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
