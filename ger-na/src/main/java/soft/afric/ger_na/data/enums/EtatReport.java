package soft.afric.ger_na.data.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
@AllArgsConstructor
@Getter
public enum EtatReport {
    Archiver(0),
    Active(1);
    private final Integer index;
}
