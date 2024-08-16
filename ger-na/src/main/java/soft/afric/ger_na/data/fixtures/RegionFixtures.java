package soft.afric.ger_na.data.fixtures;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import soft.afric.ger_na.data.entities.Region;
import soft.afric.ger_na.data.repositories.IRegionRepository;

@Order(0)
//@Component
@RequiredArgsConstructor
public class RegionFixtures implements CommandLineRunner {
    private final IRegionRepository repository;
    @Override
    public void run(String... args) throws Exception {
        String[] regions = {"Dakar", "Sally","Saint-Louis","Touba","Diourbel", "Fatick", "Kaffrine", "Kaolack", "Kédougou", "Kolda", "Louga", "Matam", "Sédhiou", "Tambacounda", "Thiès", "Ziguinchor"};
        for(String r : regions){
            repository.save(Region.builder().libelle(r).build());
        }
    }
}
