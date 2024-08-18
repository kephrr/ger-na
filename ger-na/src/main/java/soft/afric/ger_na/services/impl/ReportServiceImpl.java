package soft.afric.ger_na.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import soft.afric.ger_na.api.dto.request.ReportCreateDto;
import soft.afric.ger_na.data.entities.Report;
import soft.afric.ger_na.data.entities.User;
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
    public List<Report> findAllByUser(Long id) {
        return repository.findAllByUser(userRepository.getReferenceById(id));
    }

    @Override
    public int create(ReportCreateDto dto) {
        return 0;
    }
}
