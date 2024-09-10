package soft.afric.ger_na.data.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import soft.afric.ger_na.data.entities.Service;

import java.util.List;
import java.util.Optional;

public interface IServiceRepository extends JpaRepository<Service,Long> {
    Optional<Service> findByIdAndIsActiveTrue(Long id);
    Page<Service> findAllByIsActiveTrue(Pageable pageable);
    List<Service> findAllByIsActiveTrue();
}
