package soft.afric.ger_na.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import soft.afric.ger_na.data.entities.Service;


import java.util.List;

public interface ServiceService {
    List<Service> findAll();
    Page<Service> findAll(Pageable page);
    Service findById(Long id);
}
