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
    public void testUnitAttributionPointArrive() throws SortieTableauException {
        Partie partie = new Partie();
        Joueur j = new Joueur("Polo");
        Joueur j1 = new Joueur("OUI");
        partie.ajouterJoueur(j);
        partie.ajouterJoueur(j1);
        j.setPosition(22);
        j1.setPosition(19);
        j.setRangCourse(1);
        j1.setRangCourse(2);
        partie.deplaceJoueur(j,1);
        partie.deplaceJoueur(j1,1);
        assertEquals(25,j.getPoints());
        assertEquals(j1.getPoints(),0);

    }




}
