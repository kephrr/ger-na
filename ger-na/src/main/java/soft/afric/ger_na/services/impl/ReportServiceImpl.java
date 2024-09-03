package soft.afric.ger_na.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import soft.afric.ger_na.api.dto.request.ReportCreateDto;
import soft.afric.ger_na.data.entities.Region;
import soft.afric.ger_na.data.entities.Report;
import soft.afric.ger_na.data.entities.Zone;
import soft.afric.ger_na.data.repositories.IReportRepository;
import soft.afric.ger_na.data.repositories.IUserRepository;
import soft.afric.ger_na.services.ReportService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final IReportRepository repository;
    private final IUserRepository userRepository;
    @Override
    public List<Report> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<Report> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Page<Report> findAllByFiltersAndPaginate(soft.afric.ger_na.data.entities.Service service, Region region, Zone zone, Pageable page) {
        return repository.findAllByServiceAndRegionAndZoneAndPage(service, region, zone, page);
    }

    @Override
    public List<Report> findAllByFilters(soft.afric.ger_na.data.entities.Service service, Region region, Zone zone) {
        return repository.findAllByServiceAndRegionAndZone(service, region, zone);
    }

    @Override
    public Report findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public int create(ReportCreateDto dto) {
        return 0;
    }
}
