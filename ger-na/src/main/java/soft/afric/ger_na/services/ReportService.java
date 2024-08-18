package soft.afric.ger_na.services;

import soft.afric.ger_na.api.dto.request.ReportCreateDto;
import soft.afric.ger_na.data.entities.Report;


import java.util.List;

public interface ReportService {
    List<Report> findAll();
    List<Report> findAllByUser(Long id);
    int create(ReportCreateDto dto);
}
