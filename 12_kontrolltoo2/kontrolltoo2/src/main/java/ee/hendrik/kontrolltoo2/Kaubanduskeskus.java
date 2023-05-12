package ee.hendrik.kontrolltoo2;

import jakarta.persistence.*;
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
public class Kaubanduskeskus {
    @Id
    private String nimi;

    @ManyToMany
    private List<Pood> poed;

}
