package soft.afric.ger_na.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import soft.afric.ger_na.data.entities.Report;
import soft.afric.ger_na.data.entities.Service;
import soft.afric.ger_na.data.entities.Zone;


import java.util.List;
import java.util.Optional;

public interface ServiceService extends IService<Service,Long>{
    Service findById(Long id);
}
