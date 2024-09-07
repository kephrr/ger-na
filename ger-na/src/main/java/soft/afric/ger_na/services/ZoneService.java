package soft.afric.ger_na.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import soft.afric.ger_na.data.entities.Region;
import soft.afric.ger_na.data.entities.Zone;

import java.util.List;


public interface ZoneService extends IService<Zone,Long>{
    List<Zone> findAll(Region region);
    Zone findById(Long id);
}
