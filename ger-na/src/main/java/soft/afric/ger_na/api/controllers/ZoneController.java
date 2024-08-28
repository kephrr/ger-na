package soft.afric.ger_na.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface ZoneController {
    @GetMapping("/zones")
    Map<Object, Object> zones();

    @GetMapping("/zones")
    Map<Object, Object> zones(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "0") int size
    );

    @GetMapping("/zones/region/{id}")
    Map<Object, Object> zonesByRegions(
            @PathVariable Long id
    );
}
