package soft.afric.ger_na.data.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import soft.afric.ger_na.data.entities.Report;
import soft.afric.ger_na.data.entities.User;

import java.util.List;

public interface IReportRepository extends JpaRepository<Report,Long> {
    List<Report> findAllByUser(User user);
}
