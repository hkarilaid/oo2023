import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AutomaatTest {

    @Test
    public void kontrolli_kolmnurga_ymbermoot() {
        Kolmnurk kolmnurk = new Kolmnurk(5,6,7,8);
        assertEquals(21.0, kolmnurk.arvutaYmberMoot(), 0.1);
    }
}
