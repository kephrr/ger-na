package soft.afric.ger_na.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import soft.afric.ger_na.data.entities.Region;
import soft.afric.ger_na.data.entities.Report;
import soft.afric.ger_na.data.entities.Service;
import soft.afric.ger_na.data.entities.Zone;




public interface ReportService extends IService<Report,Long>{

    Page<Report> findAllByServiceAndRegionAndZone(Pageable page, Service service, Region region, Zone zone);
}
