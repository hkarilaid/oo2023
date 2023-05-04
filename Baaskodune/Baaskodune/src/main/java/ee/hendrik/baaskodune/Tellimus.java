package ee.hendrik.baaskodune;

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
    @ManyToMany
    private List<Server> server;
    @ManyToMany
    private List<SSD> ssds;
}
