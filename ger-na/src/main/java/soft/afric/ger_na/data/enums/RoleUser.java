package soft.afric.ger_na.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleUser {
    Personne(0),Entreprise(1),Organisation(2);
    private final Integer index;
}
