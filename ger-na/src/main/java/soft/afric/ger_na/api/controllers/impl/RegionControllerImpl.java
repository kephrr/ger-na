package soft.afric.ger_na.api.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestController;
import soft.afric.ger_na.api.controllers.RegionController;
import soft.afric.ger_na.api.dto.request.RegionCreateDto;
import soft.afric.ger_na.api.dto.response.RegionDto;
import soft.afric.ger_na.api.dto.response.rest.RestResponseDto;
import soft.afric.ger_na.data.entities.Region;
import soft.afric.ger_na.services.RegionService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RegionControllerImpl implements RegionController {
    private final RegionService regionService;
    @Override
    public Map<Object, Object> regions() {
        List<RegionDto> results = regionService.findAll().stream()
                .map(RegionDto::toDto).toList();
        return RestResponseDto.response(
                results,
                HttpStatus.OK
        );
    }

    @Override
    public Map<Object, Object> regionsByPaginate(int page, int size) {
        Page<RegionDto> results = regionService.findAll(PageRequest.of(page, size)).map(RegionDto::toDto);
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
    public Map<Object, Object> save(RegionCreateDto regionDto, BindingResult bindingResult) {
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
                Region region = RegionCreateDto.toEntity(regionDto);
                regionService.save(region);
                response= RestResponseDto.response(regionDto,HttpStatus.CREATED);
            }catch (Exception e) {
                // Conflit de DTO
                response= RestResponseDto.response(regionDto,HttpStatus.NOT_ACCEPTABLE);
                System.out.println(e.getMessage());
            }
        }
        return RestResponseDto.response(
                response,
                HttpStatus.OK
        );
    }
}
