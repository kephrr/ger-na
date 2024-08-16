package soft.afric.ger_na.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;


public interface MainController {
    @GetMapping("/regions")
    Map<Object, Object> regions();

    @GetMapping("/zones")
    Map<Object, Object> zones();

    @GetMapping("/services")
    Map<Object, Object> services();

    /*
    @GetMapping("/regions/{id}")
    Map<Object, Object> regions(
            @PathVariable Long id
    );*/
}
