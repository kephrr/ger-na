package soft.afric.ger_na.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import soft.afric.ger_na.data.entities.Region;
import soft.afric.ger_na.data.entities.Zone;

import java.util.List;
import java.util.Optional;

public interface IZoneRepository extends JpaRepository<Zone,Long> {
    @Query("SELECT DISTINCT z FROM Zone z "+
            "WHERE z.isActive = true "+
            "AND (:region IS NULL OR z.region=:region) "
    )
    List<Zone> findAllByRegion(@Param("region") Region region);
    Optional<Zone> findByIdAndIsActiveTrue(Long id);
    Page<Zone> findAllByIsActiveTrue(Pageable pageable);
}
