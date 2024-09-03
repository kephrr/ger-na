package soft.afric.ger_na.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import soft.afric.ger_na.data.entities.Report;
import soft.afric.ger_na.data.entities.Service;

public interface IServiceRepository extends JpaRepository<Service,Long> {
}
