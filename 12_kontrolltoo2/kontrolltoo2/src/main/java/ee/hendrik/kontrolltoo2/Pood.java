package ee.hendrik.kontrolltoo2;


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
public class Pood {
    @Id
    private String nimetus;
    private int avamine;
    private int sulgemine;
    private int kylastajateArv;
}
