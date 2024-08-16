package soft.afric.ger_na.data.fixtures;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import soft.afric.ger_na.data.entities.Service;
import soft.afric.ger_na.data.repositories.IServiceRepository;

@Order(2)
//@Component
@RequiredArgsConstructor
public class ServiceFixtures implements CommandLineRunner {
    private final IServiceRepository repository;
    @Override
    public void run(String... args) throws Exception {
        String[] services = {"Douane","Police Nationale","Gendarmerie Nationale",
                            "Police des étrangers","Mairie","Notaire","Huissiers","Ecole supérieure",
                            "Tribunal de grandes instances","Cours d'appel","Cours supreme"};
        for(String s : services){
            repository.save(Service.builder().libelle(s).build());
        }
    }
}
