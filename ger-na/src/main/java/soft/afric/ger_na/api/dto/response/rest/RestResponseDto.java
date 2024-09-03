package soft.afric.ger_na.api.dto.response.rest;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class RestResponseDto {
    public static Map<Object, Object> response(Object results, Object pages,
                                               Object totalPages, Object totalItems,
                                               Object currentPage, HttpStatus status){
        Map<Object, Object> response = response(results, status);
        response.put("TYPE", "Page");
        response.put("totalItems", totalItems);
        response.put("currentPage",currentPage);
        response.put("pages", pages);
        response.put("totalPages", totalPages);
        return response;
    }
    public static Map<Object, Object> response(Object results, Object totalItems,
                                               HttpStatus status){
        Map<Object, Object> response = response(results, status);
        response.put("TYPE", "Liste/Collection");
        response.put("totalItems", totalItems);
        return response;
    }
    public static Map<Object, Object> response(Object results, HttpStatus status){
        Map<Object, Object> response = new HashMap<>();
        response.put("TYPE", "Object/NULL");
        response.put("status", status.value());
        response.put("results", results);
        return response;
    }
}
