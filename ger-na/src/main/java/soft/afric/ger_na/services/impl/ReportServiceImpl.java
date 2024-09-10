package soft.afric.ger_na.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import soft.afric.ger_na.data.entities.Region;
import soft.afric.ger_na.data.entities.Report;
import soft.afric.ger_na.data.entities.Zone;
import soft.afric.ger_na.data.repositories.IReportRepository;
import soft.afric.ger_na.services.ReportService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final IReportRepository repository;
    @Override
    public List<Report> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Report> show(Long dataID) {
        return repository.findById(dataID);
    }

    @Override
    public Report save(Report data) {
        return repository.save(data);
    }

    @Override
    public Page<Report> findAll(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Page<Report> findAllByServiceAndRegionAndZone(Pageable page,
                                                         soft.afric.ger_na.data.entities.Service service,
                                                         Region region,
                                                         Zone zone) {
        return repository.findAllByServiceAndRegionAndZone(service,region,zone,page);
    }
}
