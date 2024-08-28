package soft.afric.ger_na.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface ServiceController {
    @GetMapping("/services")
    Map<Object, Object> services();

    @GetMapping("/services")
    Map<Object, Object> services(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "0") int size
    );

}
