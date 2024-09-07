package soft.afric.ger_na.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import soft.afric.ger_na.data.entities.Region;


import java.util.List;

public interface RegionService extends  IService<Region,Long>{
    Page<Region> findAll(Pageable page);
    Region findById(Long id);
}
