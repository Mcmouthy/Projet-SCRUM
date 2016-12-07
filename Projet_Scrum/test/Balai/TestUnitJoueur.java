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

    @Test
    public void testUnitAddCarteAcrobatie(){
        Joueur j = new Joueur("polo");
        Acrobatie a= new Acrobatie(Type.LOOPING);
        assertTrue(a.equals(j.addCarte(a)));
        assertTrue(j.getMainAcrobatie().size()==1);
        assertTrue(j.getMainAcrobatie().get(0).isAcrobatie());
    }

    @Test
    public void testUnitAddCarteSortilege(){
        Joueur j = new Joueur("polo");
        Sortilege s= new Sortilege(Type.BROUILLARDMAGIQUE);
        assertTrue(s.equals(j.addCarte(s)));
        assertTrue(j.getMain().size()==1);
        assertTrue(j.getMain().get(0).isSortilege());
    }

    @Test
    public void testUnitcalculerScoreAccrobatie(){
        Joueur j= new Joueur("paul");
        Acrobatie a = new Acrobatie(Type.LOOPING);
        j.addMainAcrobatie(a);
        j.calculerScoreAcrobatie();
        assertTrue(j.getPoints()==3);
    }




}
