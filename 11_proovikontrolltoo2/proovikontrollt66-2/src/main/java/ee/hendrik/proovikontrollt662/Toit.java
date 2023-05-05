package ee.hendrik.proovikontrollt662;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Toit {
    @Id
    private String nimetus;

    @ManyToMany
    private List<ToiduKomponent> toidukomponendid;
}
