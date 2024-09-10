package soft.afric.ger_na.services;

import soft.afric.ger_na.data.entities.Region;
import soft.afric.ger_na.data.entities.Zone;

import java.util.List;


public interface ZoneService extends IService<Zone,Long>{
    List<Zone> findAllByRegion(Region region);
}
