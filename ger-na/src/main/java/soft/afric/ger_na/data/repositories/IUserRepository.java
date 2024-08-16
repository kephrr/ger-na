package soft.afric.ger_na.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import soft.afric.ger_na.data.entities.User;

public interface IUserRepository extends JpaRepository<User, Long> {
}
