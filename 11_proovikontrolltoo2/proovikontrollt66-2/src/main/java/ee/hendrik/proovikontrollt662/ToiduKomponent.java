package ee.hendrik.proovikontrollt662;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class ToiduKomponent {
    @Id
    private Long id;
    @ManyToOne
    private Toiduaine toiduaine;
    private int kogus;
}
