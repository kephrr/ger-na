package soft.afric.ger_na.api.controllers;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import soft.afric.ger_na.api.dto.request.RegionCreateDto;

import java.util.Map;

public interface RegionController {
    @GetMapping("/regions")
    Map<Object, Object> regions();

    @GetMapping("/regions/paginate")
    Map<Object, Object> regionsByPaginate(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    );
    @PostMapping("/regions")
    Map<Object, Object> save(
            @Valid @RequestBody RegionCreateDto regionDto,
            BindingResult bindingResult
            );
}
