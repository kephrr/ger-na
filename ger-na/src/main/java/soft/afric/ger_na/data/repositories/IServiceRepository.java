package soft.afric.ger_na.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import soft.afric.ger_na.data.entities.Service;

public interface IServiceRepository extends JpaRepository<Service,Long> {
}
