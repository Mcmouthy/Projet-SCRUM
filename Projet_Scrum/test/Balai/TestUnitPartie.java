package Balai;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by PC-Dylan on 22/11/2016.
 */
public class TestUnitPartie {
    @Test
    public void testUnitAjouterJoueurPartie(){
        Joueur j = new Joueur("OUI");
        Joueur j1 = new Joueur("NON");
        Joueur j2 = new Joueur("NOUI");
        Partie partie=new Partie();
        partie.ajouterJoueur(j1);
        assertEquals(partie.getlistejoueur().get(0),j1);
    }



    @Test
    public void testUnitPartieInit(){
        Joueur j = new Joueur("OUI");
        Joueur j1 = new Joueur("NON");
        Joueur j2 = new Joueur("NOUI");
        Partie partie=new Partie();
        partie.ajouterJoueur(j);
        partie.ajouterJoueur(j1);
        partie.ajouterJoueur(j2);
        partie.init();
        assertEquals(j.getPosition(),0);
        assertEquals(j1.getPosition(),0);
        assertEquals(j2.getPosition(),0);
    }

    @Test
    public void testUnitDeplacementValide() throws Exception{
        Partie partie=new Partie();
        Joueur j=new Joueur("Polo");
        partie.ajouterJoueur(j);
        partie.init();
        partie.deplaceJoueur(j,3); //deplacement positif
        assertEquals(j.getPosition(),3);
        partie.deplaceJoueur(j,-1); //deplacement negatif
        assertEquals(j.getPosition(),2);
    }
    @Rule
    public ExpectedException truc=ExpectedException.none();
    @Test
    public void testUnitDeplacementException() throws SortieTableauException {
        Partie partie=new Partie();
        Joueur j=new Joueur("Polo");
        partie.ajouterJoueur(j);
        partie.init();
        partie.deplaceJoueur(j,-2);
        truc.expect(SortieTableauException.class);
        partie.deplaceJoueur(j,-1);
    }

    @Test
    public void testUnitPartieFinie() throws SortieTableauException {
        Partie partie=new Partie();
        Joueur j=new Joueur("Polo");
        partie.ajouterJoueur(j);
        j.setPosition(22);
        partie.deplaceJoueur(j,1);
        assertTrue(partie.getFin());
    }

    @Test
    public void testUnitComparePosition() {
        Partie partie=new Partie();
        Joueur j1, j2, j3;
        j1 = new Joueur();
        j2 = new Joueur();
        j3 = new Joueur();

        partie.ajouterJoueur(j1);
        partie.ajouterJoueur(j2);
        partie.ajouterJoueur(j3);
        partie.init();
        j1.setPosition(22);
        j2.setPosition(21);
        j3.setPosition(21);
        partie.comparePosition();
        assertEquals(j1.getRangCourse(),1);
        assertEquals(j2.getRangCourse(),2);
        assertEquals(j3.getRangCourse(),2);
    }

    @Test
    public void testUnitTireCarte(){
        Partie partie=new Partie();
        Joueur j=new Joueur();
        CarteMagieNoire carte;
        partie.init(); //ajouter dans la fonction la création d'une pioche
        carte=partie.piocher(j);
        Assert.assertEquals(partie.getPioche().taille(),26);
        if (carte.isSortilege()) {
            Assert.assertEquals(j.getMain().size(),1);
            Assert.assertEquals(j.getMain().get(0),carte);
        }
        else if (carte.isAcrobatie()) {
            Assert.assertEquals(j.getMainAcrobatie().size(),1);
            Assert.assertEquals(j.getMainAcrobatie().get(0),carte);
        }

    }

}
