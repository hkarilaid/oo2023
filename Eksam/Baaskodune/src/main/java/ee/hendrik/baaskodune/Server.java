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
public class Server {
    @Id
    private int id;
    private String nimi;
    private double hind;
    private int kettaBayd;
    private double energiaKasutus;
}
