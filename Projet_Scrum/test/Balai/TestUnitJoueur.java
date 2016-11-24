package Balai;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by PC-Dylan on 22/11/2016.
 */
public class TestUnitJoueur {
    @Test
    public void testUnitSetNom(){
        Joueur j= new Joueur();
        j.setNom("toto");
        assertEquals(j.getNom(),"toto");
    }

    @Test
    public void mainUnitTest(){
        Joueur j = new Joueur();
        Assert.assertTrue(j.getMain().isEmpty());
        CarteMagieNoire card = new CarteMagieNoire(CarteMagieNoire.Effet.LOOPING);
        j.addCard(card);
        Assert.assertEquals(j.getMain().size(), 1);
        Assert.assertEquals(j.getMain().get(0), card);
        j.removeCard(card);
        Assert.assertEquals(j.getMain().size(), 0);
    }
}
