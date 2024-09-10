package soft.afric.ger_na.api.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestController;
import soft.afric.ger_na.api.controllers.ServiceController;
import soft.afric.ger_na.api.dto.request.ServiceCreateDto;
import soft.afric.ger_na.api.dto.response.ServiceDto;
import soft.afric.ger_na.api.dto.response.rest.RestResponseDto;
import soft.afric.ger_na.data.entities.Service;
import soft.afric.ger_na.services.ServiceService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ServiceControllerImpl implements ServiceController {
    private final ServiceService serviceService;
    @Override
    public Map<Object, Object> services() {
        List<ServiceDto> results = serviceService.findAll().stream()
                .map(ServiceDto::toDto).toList();
        return RestResponseDto.response(
                results,
                HttpStatus.OK
        );
    }

    @Override
    public Map<Object, Object> services(int page, int size) {
        Page<ServiceDto> results = serviceService.findAll(PageRequest.of(page, size)).map(ServiceDto::toDto);
        return RestResponseDto.response(
                results.getContent(),
                new int[results.getTotalPages()],
                page,
                results.getTotalElements(),
                results.getTotalPages(),
                HttpStatus.OK
        );
    }

    @Override
    public Map<Object, Object> save(ServiceCreateDto serviceDto, BindingResult bindingResult) {
        Map<Object, Object> response;
        if (bindingResult.hasErrors()){
            // Envoyer les erreurs en reponse
            Map<String, String> errors =new HashMap<>();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> errors.put(fieldError.getField(),fieldError.getDefaultMessage()));
            response= RestResponseDto.response(errors, HttpStatus.NOT_ACCEPTABLE);
        }else{
            try {
                // Creer le signalement
                Service service = ServiceCreateDto.toEntity(serviceDto);
                serviceService.save(service);
                response= RestResponseDto.response(serviceDto,HttpStatus.CREATED);
            }catch (Exception e) {
                // Conflit de DTO
                response= RestResponseDto.response(serviceDto,HttpStatus.NOT_ACCEPTABLE);
                System.out.println(e.getMessage());
            }
        }
        return RestResponseDto.response(
                response,
                HttpStatus.OK
        );
    }
}
