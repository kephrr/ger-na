package soft.afric.ger_na.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import soft.afric.ger_na.data.entities.Report;

public interface IReportRepository extends JpaRepository<Report,Long> {
}
