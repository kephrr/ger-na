package soft.afric.ger_na.data.fixtures;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import soft.afric.ger_na.data.repositories.IReportRepository;

@Order(4)
////@Component
@RequiredArgsConstructor
public class ReportFixtures implements CommandLineRunner {
    private final IReportRepository repository;
    @Override
    public void run(String... args) throws Exception {
        String[] details = {"J'étais en règle mais on m'a quand-même demandé de l'argent","Il m'ont fait attendre 3h, et demandé de payer pour aller plus vite"};

    }
}
