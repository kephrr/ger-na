package soft.afric.ger_na.data.fixtures;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import soft.afric.ger_na.data.entities.Report;
import soft.afric.ger_na.data.enums.EtatReport;
import soft.afric.ger_na.data.repositories.IReportRepository;
import soft.afric.ger_na.data.repositories.IServiceRepository;
import soft.afric.ger_na.data.repositories.IZoneRepository;

import java.util.Date;

@Order(4)
//@Component
@RequiredArgsConstructor
public class ReportFixtures implements CommandLineRunner {
    private final IReportRepository repository;
    private final IZoneRepository zoneRepository;
    private final IServiceRepository serviceRepository;
    

    public void run(String... args) throws Exception {
        Long[] services = {2L,5L,5L};
        Long[] zones = {1L, 2L, 2L};
        String[] lieu = {"A côté du casino","A la reception","Au service de résidence"};
        Double[] montant ={1000.0, 2000.0, 2500.0};
        String[] details = {"J'étais en règle mais on m'a quand-même demandé de l'argent", "Il m'ont fait attendre 3h, et demandé de payer pour aller plus vite", "On m'a demandé de payer pour avoir mon certificat de résidence plus rapidement"};
        for(int i = 0; i<details.length; i++){
            repository.save(
                    Report.builder()
                            .details(details[i])
                            .date(new Date())
                            .zone(zoneRepository.findById(zones[i]).orElse(null))
                            .service(serviceRepository.findById(services[i]).orElse(null))
                            .lieu(lieu[i])
                            .etat(EtatReport.Active)
                            .montant(montant[i])
                            .build());
        }
    }
}
