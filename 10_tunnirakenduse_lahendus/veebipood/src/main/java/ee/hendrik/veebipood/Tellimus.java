package ee.hendrik.veebipood;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tellimus {
    @Id
    private int id;
    @ManyToOne
    private Isik tellija;
    @ManyToMany
    private List<Toode> tooted;
}
