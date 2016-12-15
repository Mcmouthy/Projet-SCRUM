package Balai;

import Balai.Exceptions.SortieTableauException;
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

    @Test
    public void testSetMainFormule(){
        Joueur j=new Joueur("");
        j.setMainCarteFormule();
        Assert.assertEquals(j.getMainCarteFormule().size(),9);
        Assert.assertEquals(j.getMainCarteFormule().get(0), Des.symbole.ECLAIR);
        Assert.assertEquals(j.getMainCarteFormule().get(1), Des.symbole.ARAIGNEE);
        Assert.assertEquals(j.getMainCarteFormule().get(2), Des.symbole.OREILLE);
        Assert.assertEquals(j.getMainCarteFormule().get(3), Des.symbole.TETEDEMORT);
        Assert.assertEquals(j.getMainCarteFormule().get(4), Des.symbole.CHOC);
        Assert.assertEquals(j.getMainCarteFormule().get(5), Des.symbole.PLUIE);
        Assert.assertEquals(j.getMainCarteFormule().get(6), Des.symbole.OEIL);
        Assert.assertEquals(j.getMainCarteFormule().get(7), Des.symbole.TOILE);
        Assert.assertEquals(j.getMainCarteFormule().get(8), Des.symbole.ETOILE);

    }

    @Test
    public void testAddToFormule(){
        Joueur j = new Joueur("toto");
        j.setMainCarteFormule();
        j.addToFormule(Des.symbole.ARAIGNEE);
        Assert.assertEquals(j.getFormule().size(),1);
        Assert.assertEquals(j.getMainCarteFormule().size(),8);
    }


}
