package soft.afric.ger_na.data.fixtures;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import soft.afric.ger_na.data.entities.Report;
import soft.afric.ger_na.data.enums.EtatReport;
import soft.afric.ger_na.data.repositories.IRegionRepository;
import soft.afric.ger_na.data.repositories.IReportRepository;
import soft.afric.ger_na.data.repositories.IServiceRepository;
import soft.afric.ger_na.data.repositories.IZoneRepository;

import java.util.Date;


@Order(4)
//@Component
@RequiredArgsConstructor
public class ReportFixtures implements CommandLineRunner {
    private final IReportRepository reportRepository;
    private final IZoneRepository zoneRepository;
    private final IServiceRepository serviceRepository;
    private final IRegionRepository regionRepository;
    

    public void run(String... args) throws Exception {
        Long[] services = {2L,5L,5L, 4L,4L,3L, 2L,5L,4L};
        Long[] zones = {1L, 2L, 2L, 1L,14L,2L, 29L,5L,4L};
        Long[] regions = {1L, 2L, 2L, 1L,14L,2L, 2L,5L,4L};
        String[] telephones = {"784555525", "784555500", "784775525",
                                "784555525","784555525","784555525",
                                "784555525","784555525","784555525"};
        String[] lieu = {
                "A côté du casino","A la reception","Au service de résidence",
                "Dans le bureau du DG","Dans le bureau du DG","Au service 2",
                "A côté du casino","Dans le bureau du DG","A la reception"
        };
        Double[] montant ={
                1000.0, 2000.0, 2500.0,
                2000.0, 3000.0, 1500.0,
                5000.0, 1000.0, 2000.0
        };
        String[] details = {
                "J'étais en règle mais on m'a quand-même demandé de l'argent", "Il m'ont fait attendre 3h, et demandé de payer pour aller plus vite", "On m'a demandé de payer pour avoir mon certificat de résidence plus rapidement",
                "J'étais en règle mais on m'a quand-même demandé de l'argent", "Il m'ont fait attendre 3h, et demandé de payer pour aller plus vite", "On m'a demandé de payer pour avoir mon certificat de résidence plus rapidement",
                "J'étais en règle mais on m'a quand-même demandé de l'argent", "Il m'ont fait attendre 3h, et demandé de payer pour aller plus vite", "On m'a demandé de payer pour avoir mon certificat de résidence plus rapidement"};
        for(int i = 0; i<details.length; i++){
            reportRepository.save(
                    Report.builder()
                            .details(details[i])
                            .date(new Date())
                            .zone(zoneRepository.findById(zones[i]).orElse(null))
                            .service(serviceRepository.findById(services[i]).orElse(null))
                            .lieu(lieu[i])
                            .etat(EtatReport.Active)
                            .montant(montant[i])
                            .region(regionRepository.findById(regions[i]).orElse(null))
                            .telephone(telephones[i])
                            .build());
        }
    }
}
