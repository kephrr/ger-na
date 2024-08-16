package soft.afric.ger_na.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import soft.afric.ger_na.data.entities.Region;
import soft.afric.ger_na.data.entities.Zone;

import java.util.List;

public interface IZoneRepository extends JpaRepository<Zone,Long> {
    List<Zone> findAllByRegion(Region region);
}
