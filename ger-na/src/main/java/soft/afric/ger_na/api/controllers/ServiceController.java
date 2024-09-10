package soft.afric.ger_na.api.controllers;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import soft.afric.ger_na.api.dto.request.ServiceCreateDto;

import java.util.Map;

public interface ServiceController {
    @GetMapping("/services")
    Map<Object, Object> services();

    @GetMapping("/services/paginate")
    Map<Object, Object> services(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    );

    @PostMapping("/services")
    Map<Object, Object> save(
            @Valid @RequestBody ServiceCreateDto serviceDto,
            BindingResult bindingResult
            );
}
