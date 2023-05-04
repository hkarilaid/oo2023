package ee.hendrik.baaskodune;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SSD {
    @Id
    private int id;
    private String nimi;
    private double hind;
    private double suurus;
    private double energiaKasutus;
    private int garantii;
}
