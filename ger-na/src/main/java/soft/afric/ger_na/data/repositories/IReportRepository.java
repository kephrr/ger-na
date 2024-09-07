package soft.afric.ger_na.data.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import soft.afric.ger_na.data.entities.*;

import java.util.List;

public interface IReportRepository extends JpaRepository<Report,Long> {
    List<Report> findAllByUser(User user);

    @Query("SELECT DISTINCT r FROM Report r "+
            "JOIN r.zone z "+
            "WHERE r.isActive = true "+
            "AND (:service IS NULL OR r.service = :service) "+
            "AND (:region IS NULL OR r.region = :region) "+
            "AND (:zone IS NULL OR z= :zone) ")
    Page<Report> findAllByServiceAndRegionAndZoneAndPage(
            @Param("service") Service service,
            @Param("region") Region region,
            @Param("zone") Zone zone,
            Pageable page);

    // Filtre a partir des libelle
    @Query("SELECT DISTINCT r FROM Report r JOIN r.zone z WHERE r.isActive = true " +
            "AND (:service IS NULL OR r.service.libelle = :service) " +
            "AND (:zone IS NULL OR r.zone.libelle = :zone)"+
            "AND (:region IS NULL OR z.region.libelle = :region) ")
    Page<Report> findAllWithOptionalFiltersAndPage(
                                            @Param("service") String service,
                                            @Param("zone") String zone,
                                            @Param("region") String region,
                                            Pageable page);
}
