package ee.hendrik.apiotskodune;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SSD {
    private String nimi;
    private double hind;
    private double suurus;
    private double energiaKasutus;
    private int garantii;
}
