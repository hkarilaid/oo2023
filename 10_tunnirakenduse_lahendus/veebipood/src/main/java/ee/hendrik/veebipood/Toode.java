package ee.hendrik.veebipood;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity     // andmebaasitabelik defineerimine
public class Toode { // andmebaasi nimi on klassi nimi
    @Id
    private int id;  // standard on panna andmebaasi ID long
    private String nimi;
    private double hind;


}
