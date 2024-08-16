package soft.afric.ger_na.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import soft.afric.ger_na.data.entities.Region;

import java.util.Optional;

public interface IRegionRepository extends JpaRepository<Region,Long>{
    Optional<Region> findByLibelle(String libelle);
}
