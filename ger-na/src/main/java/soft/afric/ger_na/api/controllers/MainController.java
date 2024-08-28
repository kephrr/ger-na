package soft.afric.ger_na.api.controllers;


import org.springframework.web.bind.annotation.*;
import soft.afric.ger_na.api.dto.request.ReportCreateDto;

import java.util.Map;


public interface MainController {


    @GetMapping("/signalements")
    Map<Object, Object> reports(
            @RequestParam(defaultValue = 0 ) Long service,
            @RequestParam(defaultValue = 0 ) Long region,
            @RequestParam(defaultValue = 0 ) Long zone
    );

    @GetMapping("signalements/{id}")
    Map<Object, Object> myReports(
            @PathVariable Long id
    );

    @PostMapping("/signalements")
    Map<Object, Object> save(
            @RequestBody ReportCreateDto reportDto
    );


    @GetMapping("/services")
    Map<Object, Object> services();

    @GetMapping("/regions")
    Map<Object, Object> regions();

    @GetMapping("/zones")
    Map<Object, Object> zones();

    @GetMapping("/zone/region/{region}")
    Map<Object, Object> zonesByRegions(
            @PathVariable Long region
    );

    @GetMapping("/login")
    Map<Object, Object> login();
    @PostMapping("/register")
    Map<Object, Object> register();
    /*
    @RequestBody RendezVousCreateDto rendezVous
    @GetMapping("/regions/{id}")
    Map<Object, Object> regions(
            @PathVariable Long id
    );*/
}
