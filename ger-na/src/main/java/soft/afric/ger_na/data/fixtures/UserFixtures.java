package soft.afric.ger_na.data.fixtures;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import soft.afric.ger_na.data.entities.User;
import soft.afric.ger_na.data.enums.RoleUser;
import soft.afric.ger_na.data.repositories.IUserRepository;

@Order(3)
//@Component
@RequiredArgsConstructor
public class UserFixtures implements CommandLineRunner {
    private final IUserRepository repository;
    /*
     * private String nom;
     * private String telephone;
     * private String password;
     * private RoleUser role;
    */
    @Override
    public void run(String... args) throws Exception {
        String[] personnes = {"Aly GUEYE","Tom Hardy","Brandon DIENG","Marc Escufon","Cam Thomas","Abdoulaye DIAW"};
        for(int i=0; i<personnes.length; i++){
            repository.save(User.builder().nom(personnes[i]).telephone(i%2==0?"77"+i+"99009"+i:"78"+i+"11001"+i).password("passer").role(RoleUser.Personne) .build());
        }
        String[] entreprises = {"Delivery .Inc","Wave","Market Placket","Back Market"};
        for(int j=0; j<entreprises.length; j++){
            repository.save(User.builder().nom(entreprises[j]).telephone("77"+j+"99009"+j).password("corporate").role(RoleUser.Entreprise) .build());
        }
    }
}
