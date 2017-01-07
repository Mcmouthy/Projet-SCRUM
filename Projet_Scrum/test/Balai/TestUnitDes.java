package Balai;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by malonesk on 07/01/17.
 */
public class TestUnitDes {
    @Test
    public void testSetListeDes() {

    }

    @Test
    public void testGetSymboleSansCouleur() {
        List<Des.symbole> ls = new ArrayList<Des.symbole>(){{
            add(Des.symbole.ARAIGNEE);
            add(Des.symbole.CHOC);
            add(Des.symbole.ECLAIR);
            add(Des.symbole.ETOILE);
            add(Des.symbole.OEIL);
            add(Des.symbole.OREILLE);
            add(Des.symbole.PLUIE);
            add(Des.symbole.TETEDEMORT);
            add(Des.symbole.TOILE);
        }};
        Assert.assertTrue(ls.containsAll(Des.getSymbolesSansCouleur()));
    }
}
