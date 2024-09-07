package soft.afric.ger_na.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import soft.afric.ger_na.api.dto.request.ReportCreateDto;
import soft.afric.ger_na.data.entities.Region;
import soft.afric.ger_na.data.entities.Report;
import soft.afric.ger_na.data.entities.Service;
import soft.afric.ger_na.data.entities.Zone;


import java.util.List;

public interface ReportService extends IService<Report,Long>{

    Page<Report> findAllByServiceAndRegionAndZoneAndPage(Pageable page, Service service, Region region, Zone zone);

    Page<Report> findWithAllFiltersPage(Pageable page, String service, String region, String zone);

    Report findById(Long id);
    int create(ReportCreateDto dto);
}
