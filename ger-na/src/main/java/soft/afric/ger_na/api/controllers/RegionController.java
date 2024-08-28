package soft.afric.ger_na.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface RegionController {
    @GetMapping("/regions")
    Map<Object, Object> regions();

    @GetMapping("/regions")
    Map<Object, Object> regions(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "0") int size
    );
}
