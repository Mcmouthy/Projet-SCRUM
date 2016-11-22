package Balai;

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

}
