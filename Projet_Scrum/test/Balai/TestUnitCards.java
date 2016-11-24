package Balai;

import org.junit.Test;

/**
 * Created by PC-Dylan on 22/11/2016.
 */
public class TestUnitCards {

    @Test
    public void testUnitTypeCarte(){
        CarteMagieNoire card = new CarteMagieNoire();
    }

    @Test
    public void testUnitEffetCarte(){
        CarteMagieNoire carte = new CarteMagieNoire();
        Joueur j = new Joueur();
        carte.attacheJoueur(j);

    }
    @Test
    public void test(){

    }

}
