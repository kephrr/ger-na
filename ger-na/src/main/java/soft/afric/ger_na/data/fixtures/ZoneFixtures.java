package soft.afric.ger_na.data.fixtures;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import soft.afric.ger_na.data.entities.Region;
import soft.afric.ger_na.data.entities.Zone;
import soft.afric.ger_na.data.repositories.IRegionRepository;
import soft.afric.ger_na.data.repositories.IZoneRepository;

import java.util.Optional;

@Order(1)
//@Component
@RequiredArgsConstructor
public class ZoneFixtures implements CommandLineRunner{
    private final IZoneRepository repository;
    private final IRegionRepository regionRepository;
    @Override
    public void run(String... args) throws Exception {
        String[] dakarZones = {"Point E","Fann","Amitié 1","Amitié 2",
                "Sacré-Coeurt","Ouest-Foire","HLM 1", "HLM 2", "HLM 3", "Zone A","Zone B",
                "Colobane", "Fass", "Sicap-Karack", "Sicap-Baobab","Liberté 1",
                "Liberté 2", "Liberté 3","Liberté 4","Liberté 5","Liberté 6",
                "Bel Air", "La corniche", "Hann","Grand Dakar","YOFF","Sahm","Almadies"};
        String[] thiesZones = {"Grand-Stanting","Madina Fall","Diakhao","Mbour 1","Mbour 2","Mbour 3","Nguith","Hersent",
                          "Fahu","Thiès Nones","Thialy","Cité Lamy","Mbambara","Silmang"};
        String[] salyZones = {"Niakh Niakhal", "Bambara","Velingara","Tapé",
                "Golf","Extension"};

        setRegion("Dakar", dakarZones);
        setRegion("Thiès", thiesZones);
        setRegion("Sally", salyZones);
    }

    public void setRegion(String libelle, String[] values){
        Region region;
        region = regionRepository.findByLibelle(libelle).orElseThrow();
        for(String d : values){
            Zone z = Zone.builder().libelle(d).build();
            z.setRegion(region);
            repository.save(z);
        }
    }
}
