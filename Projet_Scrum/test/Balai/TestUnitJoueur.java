package Balai;

import org.junit.Assert;
import org.junit.Test;

import javax.naming.PartialResultException;

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
    public void test(){

    }




}
