import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Automaattest {

    @Test
    public void kontrolli_kas_ringi_pindala_on_50_kui_raadius_on_4() {
        Ring testring = new Ring("TestRing",4);
        assertEquals(50.2, testring.arvutaPindala(), 0.1);
    }
    @Test
    public void kontrolli_kas_ringi_ymberm66t_on_25_kui_raadius_on_4() {
        Ring testring = new Ring("TestRing",4);
        assertEquals(25.1, testring.arvutaYmbermoot(), 0.1);
    }
    @Test
    public void kontrolli_kas_ruudu_pindala_on_25_kui_kylg_on_5() {
        Ruut testruut = new Ruut("TestRuut",5);
        assertEquals(25, testruut.arvutaPindala(), 0.1);
    }
    @Test
    public void kontrolli_kas_ruudu_ymberm66t_on_20_kui_kylg_on_5() {
        Ruut testruut = new Ruut("TestRuut",5);
        assertEquals(20, testruut.arvutaYmbermoot(), 0.1);
    }
    @Test
    public void kontrolli_kas_ristkyliku_pindala_on_8_kui_kyljed_on_4_ja_2() {
        Ristkylik testristkylik = new Ristkylik("TestRistkylik",4,2);
        assertEquals(8, testristkylik.arvutaPindala(), 0.1);
    }
    @Test
    public void kontrolli_kas_ristkyliku_ymberm66t_on_12_kui_kyljed_on_4_ja_2() {
        Ristkylik testristkylik = new Ristkylik("TestRistkylik",4,2);
        assertEquals(12, testristkylik.arvutaYmbermoot(), 0.1);
    }
    @Test
    public void kontrolli_kas_kolmnurga_pindala_on_5_kui_alus_on_5_ja_k6rgus_2() {
        Kolmnurk testkolmnurk = new Kolmnurk("TestKolmnurk",2,5,3,3);
        assertEquals(5, testkolmnurk.arvutaPindala(), 0.1);
    }
    @Test
    public void kontrolli_kas_kolmnurga_ymberm66t_on_11_kui_kyljed_on_3_3_5() {
        Kolmnurk testkolmnurk = new Kolmnurk("TestKolmnurk",2,5,3,3);
        assertEquals(11, testkolmnurk.arvutaYmbermoot(), 0.1);
    }
}
