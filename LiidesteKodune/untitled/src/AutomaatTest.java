import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class AutomaatTest {

    @Test
    public void kontrolli_kas_3liitrit_piima_maksab_3_eurot_kui_1l_on_1euro(){
        Jook piim = new Jook("Piim",1,3);
        assertEquals(3,piim.hinnad(), 0.0);
    }
    @Test
    public void kontrolli_kas_ostes_3l_piima_see_korrektselt_prinditakse(){
        Jook piim = new Jook("Piim",1,3);
        assertEquals("Oled ostnud 3L Piim",piim.maht());
    }
    @Test
    public void kontrolli_kas_12_250g_puuvilja_maksab_3_eurot_kui_1kg_on_1euro(){
        Puuvili oun = new Puuvili("Õun",1,12,0.25);
        assertEquals(3,oun.hinnad(),0.0);
    }
    @Test
    public void kontrolli_kas_ostes_12_250g_puuvilja_see_korrektselt_prinditakse(){
        Puuvili oun = new Puuvili("Õun",1,12,0.25);
        assertEquals("Oled ostnud 12tk Õun",oun.maht());
    }
    @Test
    public void kontrolli_kas_ostes_2_iphone4_tuleb_maksumus_1000_eurot(){
        Telefon iphone = new Telefon("iPhone4",500,2,"nutitelefon");
        assertEquals(1000,iphone.hinnad(),0.0);
    }
    @Test
    public void kontrolli_kas_ostes_2_iphone4_prinditakse_see_korrektselt(){
        Telefon iphone = new Telefon("iPhone4",500,2,"nutitelefon");
        assertEquals("Oled ostnud iPhone4 nutitelefon",iphone.maht());
    }
}
