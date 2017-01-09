package Balai;

import Balai.Des.symbole;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.mockito.Mockito;
import Balai.Des;

import static Balai.Des.symbole.*;

/**
 * Created by malonesk on 07/01/17.
 */
//tests basiques sur la taille de la liste de dés. Pas sûr que ça teste tout en profondeur
public class TestUnitDes {
    @Test
    public void testSetListeDes() {
        Des des = new Des();
        Assert.assertTrue(des.listeDes.size() == 0);
        des.lanceDes();
        Assert.assertTrue(des.listeDes.size() == 9);
        Assert.assertTrue(des.listeDes.get(0) != null);
    }

    //Ici il faudrait mocker, mais mockito le fait pas avec les méthodes static (powerMockito : https://github.com/powermock/powermock/wiki/MockitoUsage)
    @Test
    public void testLancerDes()
    {

    }

    @Test
    public void testGetSymboleSansCouleur() {
        List<symbole> ls = new ArrayList<symbole>() {{
            add(ARAIGNEE);
            add(CHOC);
            add(ECLAIR);
            add(ETOILE);
            add(OEIL);
            add(OREILLE);
            add(PLUIE);
            add(TETEDEMORT);
            add(TOILE);
        }};
        Assert.assertTrue(ls.containsAll(Des.getSymbolesSansCouleur()));
    }
}
