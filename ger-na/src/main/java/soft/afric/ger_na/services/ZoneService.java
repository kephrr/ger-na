package soft.afric.ger_na.services;

import soft.afric.ger_na.data.entities.Region;
import soft.afric.ger_na.data.entities.Zone;

import java.util.List;


public interface ZoneService{
    List<Zone> findAll();
    //List<Zone> findAll(Region region);
    Zone findById(Long id);
}

