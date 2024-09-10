package soft.afric.ger_na.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import soft.afric.ger_na.data.entities.Region;




public interface RegionService extends  IService<Region,Long>{
    Page<Region> findAll(Pageable page);
}
