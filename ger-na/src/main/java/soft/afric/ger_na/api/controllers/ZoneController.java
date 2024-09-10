package soft.afric.ger_na.api.controllers;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import soft.afric.ger_na.api.dto.request.ZoneCreateDto;

import java.util.Map;

public interface ZoneController {
    @GetMapping("/zones/paginate")
    Map<Object, Object> zones(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    );

    @GetMapping("/zones")
    Map<Object, Object> zonesByRegions(
            @RequestParam(defaultValue = "0") Long regionID
    );

    @PostMapping("/zones")
    Map<Object, Object> save(
            @Valid @RequestBody ZoneCreateDto zoneDto,
            BindingResult bindingResult
    );
}
