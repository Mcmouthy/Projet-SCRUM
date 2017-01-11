package Balai;

import Balai.Exceptions.PiocheVideException;
import Balai.Exceptions.SortieTableauException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
//import org.mockito.Mockito;;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

    //bug : point virgule en trop dans la méthode nbJoueursAtSamePos()
    @Test
    public void testNombreJoueurAtSamePosition() throws SortieTableauException {
        Joueur j = new Joueur("Robert");
        Joueur j1 = new Joueur("Valérie");
        Joueur j2 = new Joueur("Stéphanie");
        Partie partie=new Partie();
        partie.ajouterJoueur(j1);
        partie.ajouterJoueur(j2);
        partie.ajouterJoueur(j);
        partie.init();

        Assert.assertEquals(partie.nbJoueurAtSamePos(j), 2);
        partie.deplaceJoueur(j1, 1);
        Assert.assertEquals(partie.nbJoueurAtSamePos(j), 1);
        partie.deplaceJoueur(j2, 2);
        Assert.assertEquals(partie.nbJoueurAtSamePos(j), 0);
    }

    //On ajoute plein de joueurs
    @Test
    public void testLimiteAjoutJoueurs()
    {
        Joueur j = new Joueur("Robert");
        Partie partie=new Partie();
        for(int i = 0; i < 666; i++)
            partie.ajouterJoueur(j);

        //On ne devrait pas pouvoir avoir 666 joueurs
        Assert.assertFalse(partie.getlistejoueur().size() == 666);

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
    public void testUnitDeplacementValide() throws Exception, SortieTableauException {
        Partie partie=new Partie();
        Joueur j=new Joueur("Polo");
        partie.ajouterJoueur(j);
        partie.init();
        partie.deplaceJoueur(j,3); //deplacement positif
        assertEquals(j.getPosition(),3);
        partie.deplaceJoueur(j,-1); //deplacement negatif
        assertEquals(j.getPosition(),2);
    }

    @Test
    public void TestUnitBlocage() throws Exception,SortieTableauException{
        Partie partie=new Partie();
        Joueur j=new Joueur("Polo");
        Joueur p=new Joueur("jean");
        partie.ajouterJoueur(j);
        partie.ajouterJoueur(p);
        partie.init();
        partie.deplaceJoueur(j,3);
        partie.setBlocage(0);
        partie.deplaceJoueur(p,4);
        assertEquals(p.getPosition(),3);

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
    public void testUnitTireCarte() throws PiocheVideException {
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

    @Test
    public void testUnitSetFin() {
        Partie p = new Partie();

        Assert.assertEquals(false , p.getFin());
        p.setFin(true);
        Assert.assertEquals(true, p.getFin());
    }

    @Test
    public void testGenereFormuleJeu(){
        List<Des.symbole[][]> listTest= new ArrayList<>();
        listTest.add(new Des.symbole[][]{{Des.symbole.ECLAIR},{Des.symbole.NOIR}});
        listTest.add(new Des.symbole[][]{{Des.symbole.ARAIGNEE},{Des.symbole.ORANGE}});
        listTest.add(new Des.symbole[][]{{Des.symbole.OREILLE},{Des.symbole.NOIR}});
        listTest.add(new Des.symbole[][]{{Des.symbole.ECLAIR},{Des.symbole.NOIR}});
        listTest.add(new Des.symbole[][]{{Des.symbole.TOILE},{Des.symbole.ORANGE}});
        listTest.add(new Des.symbole[][]{{Des.symbole.PLUIE},{Des.symbole.ORANGE}});
        listTest.add(new Des.symbole[][]{{Des.symbole.TETEDEMORT},{Des.symbole.ORANGE}});
        listTest.add(new Des.symbole[][]{{Des.symbole.OEIL},{Des.symbole.NOIR}});
        listTest.add(new Des.symbole[][]{{Des.symbole.OREILLE},{Des.symbole.ORANGE}});
        Partie p= new Partie();
        Assert.assertEquals(p.getFormuleJeu().size(),0);
        p.genereFormuleJeu();
        Assert.assertEquals(p.getFormuleJeu().size(),listTest.size());
    }

    @Test
    public void testGenereFormuleFinale(){
        ArrayList<Des.symbole[][]> listTest= new ArrayList<>();
        listTest.add(new Des.symbole[][]{{Des.symbole.ECLAIR},{Des.symbole.NOIR}});
        listTest.add(new Des.symbole[][]{{Des.symbole.ARAIGNEE},{Des.symbole.ORANGE}});
        listTest.add(new Des.symbole[][]{{Des.symbole.OREILLE},{Des.symbole.NOIR}});
        listTest.add(new Des.symbole[][]{{Des.symbole.ECLAIR},{Des.symbole.NOIR}});
        listTest.add(new Des.symbole[][]{{Des.symbole.TOILE},{Des.symbole.ORANGE}});
        listTest.add(new Des.symbole[][]{{Des.symbole.PLUIE},{Des.symbole.ORANGE}});
        listTest.add(new Des.symbole[][]{{Des.symbole.TETEDEMORT},{Des.symbole.ORANGE}});
        listTest.add(new Des.symbole[][]{{Des.symbole.OEIL},{Des.symbole.NOIR}});
        listTest.add(new Des.symbole[][]{{Des.symbole.OREILLE},{Des.symbole.ORANGE}});
        Partie p= new Partie();
        p.setFormuleJeu(listTest);
        p.genereFormulesFinales();
        assertEquals(p.getFormuleOrange().size(),4);
        assertEquals(p.getFormuleNoire().size(),2);
        assertEquals(p.getFormuleInterdit().size(),1);
        assertEquals(p.getFormuleJeu().size(),0);
    }

    @Test
    public void testFormuleParfaiteNoire(){
        Partie p = new Partie();
        Joueur j = new Joueur();
        Set<Des.symbole> formuleNoire = new HashSet<>();
        formuleNoire.add(Des.symbole.ECLAIR);
        formuleNoire.add(Des.symbole.OEIL);
        p.setFormuleNoire(formuleNoire);
        Set<Des.symbole> testvalideNoire = new HashSet<>();
        testvalideNoire.add(Des.symbole.ECLAIR);
        testvalideNoire.add(Des.symbole.OEIL);
        assertTrue(p.parfaite(testvalideNoire,j));
    }

    @Test
    public void testFormuleNonParfaiteNoire(){
        Partie p = new Partie();
        Joueur j = new Joueur();
        Set<Des.symbole> formuleNoire = new HashSet<>();
        formuleNoire.add(Des.symbole.ECLAIR);
        formuleNoire.add(Des.symbole.OEIL);
        p.setFormuleNoire(formuleNoire);
        Set<Des.symbole> testvalideNoire = new HashSet<>();
        testvalideNoire.add(Des.symbole.ECLAIR);
        assertFalse(p.parfaite(testvalideNoire,j));
    }

    @Test
    public void testFormuleParfaiteOrange(){
        Partie p = new Partie();
        Joueur j = new Joueur();
        Set<Des.symbole> formuleOrange = new HashSet<>();
        formuleOrange.add(Des.symbole.ECLAIR);
        formuleOrange.add(Des.symbole.OEIL);
        p.setFormuleOrange(formuleOrange);
        Set<Des.symbole> testvalideOrange = new HashSet<>();
        testvalideOrange.add(Des.symbole.ECLAIR);
        testvalideOrange.add(Des.symbole.OEIL);
        assertTrue(p.parfaite(testvalideOrange,j));
    }

    @Test
    public void testFormuleNonParfaiteOrange(){
        Partie p = new Partie();
        Joueur j = new Joueur();
        Set<Des.symbole> formuleOrange = new HashSet<>();
        formuleOrange.add(Des.symbole.ECLAIR);
        formuleOrange.add(Des.symbole.OEIL);
        p.setFormuleOrange(formuleOrange);
        Set<Des.symbole> testvalideOrange = new HashSet<>();
        testvalideOrange.add(Des.symbole.ECLAIR);
        assertFalse(p.parfaite(testvalideOrange,j));
    }

    @Test
    public void testFormulefausseFormuleEgaleValide(){
        Partie p = new Partie();
        Joueur j = new Joueur();
        Set<Des.symbole> formuleOrange = new HashSet<>();
        formuleOrange.add(Des.symbole.ECLAIR);
        formuleOrange.add(Des.symbole.OEIL);
        p.setFormuleOrange(formuleOrange);
        Set<Des.symbole> testvalide = new HashSet<>();
        testvalide.add(Des.symbole.ECLAIR);
        testvalide.add(Des.symbole.OEIL);
        assertFalse(p.isformulefausse(testvalide,formuleOrange,j));
    }

    @Test
    public void testFormulefausseFormuleEgaleNonValide(){
        Partie p = new Partie();
        Joueur j = new Joueur();
        Set<Des.symbole> formuleOrange = new HashSet<>();
        formuleOrange.add(Des.symbole.ECLAIR);
        formuleOrange.add(Des.symbole.OEIL);
        p.setFormuleOrange(formuleOrange);
        Set<Des.symbole> testvalide = new HashSet<>();
        testvalide.add(Des.symbole.ECLAIR);
        testvalide.add(Des.symbole.TOILE);
        assertTrue(p.isformulefausse(testvalide,formuleOrange,j));
    }

    @Test
    public void testFormulefausseFormuleInferieurValide(){
        Partie p = new Partie();
        Joueur j = new Joueur();
        Set<Des.symbole> formuleOrange = new HashSet<>();
        formuleOrange.add(Des.symbole.ECLAIR);
        formuleOrange.add(Des.symbole.OEIL);
        p.setFormuleOrange(formuleOrange);
        Set<Des.symbole> testvalide = new HashSet<>();
        testvalide.add(Des.symbole.ECLAIR);
        assertFalse(p.isformulefausse(testvalide,formuleOrange,j));
    }

    @Test
    public void testFormulefausseFormuleInferieurNonValide(){
        Partie p = new Partie();
        Joueur j = new Joueur();
        Set<Des.symbole> formuleOrange = new HashSet<>();
        formuleOrange.add(Des.symbole.ECLAIR);
        formuleOrange.add(Des.symbole.OEIL);
        p.setFormuleOrange(formuleOrange);
        Set<Des.symbole> testvalide = new HashSet<>();
        testvalide.add(Des.symbole.TOILE);
        assertTrue(p.isformulefausse(testvalide,formuleOrange,j));
    }

    @Test
    public void testFormulefausseFormuleSuperieur(){
        Partie p = new Partie();
        Joueur j= new Joueur();
        Set<Des.symbole> formuleOrange = new HashSet<>();
        formuleOrange.add(Des.symbole.ECLAIR);
        formuleOrange.add(Des.symbole.OEIL);
        p.setFormuleOrange(formuleOrange);
        Set<Des.symbole> testFausse = new HashSet<>();
        testFausse.add(Des.symbole.ECLAIR);
        testFausse.add(Des.symbole.OEIL);
        testFausse.add(Des.symbole.TOILE);
        assertTrue(p.isformulefausse(testFausse,formuleOrange,j));
    }

    @Test
    public void testReinitComposants(){
        Partie p = new Partie();
        Joueur k = new Joueur("toto");
        p.ajouterJoueur(k);
        k.setParfaiteOrange(true);
        k.setParfaiteNoire(true);
        k.setFermecouvercle(true);
        k.addToFormule(Des.symbole.ARAIGNEE);
        k.addToFormule(Des.symbole.ETOILE);

        Set<Des.symbole>formuleNoire = new HashSet<>();
        formuleNoire.add(Des.symbole.ARAIGNEE);
        Set<Des.symbole>formuleOrange = new HashSet<>();
        formuleNoire.add(Des.symbole.ETOILE);
        Set<Des.symbole>formuleInterdit = new HashSet<>();
        formuleNoire.add(Des.symbole.OEIL);

        ArrayList<Des.symbole[][]> listTest= new ArrayList<>();
        listTest.add(new Des.symbole[][]{{Des.symbole.ECLAIR},{Des.symbole.NOIR}});
        listTest.add(new Des.symbole[][]{{Des.symbole.ARAIGNEE},{Des.symbole.ORANGE}});
        listTest.add(new Des.symbole[][]{{Des.symbole.OREILLE},{Des.symbole.NOIR}});
        listTest.add(new Des.symbole[][]{{Des.symbole.ECLAIR},{Des.symbole.NOIR}});

        p.setFormuleOrange(formuleOrange);
        p.setFormuleNoire(formuleNoire);
        p.setFormuleInterdit(formuleInterdit);
        p.setFormuleJeu(listTest);

        p.reinitcomposant(p.getlistejoueur());

        assertEquals(p.getFormuleJeu().size(),0);
        assertEquals(p.getFormuleInterdit().size(),0);
        assertEquals(p.getFormuleNoire().size(),0);
        assertEquals(p.getFormuleOrange().size(),0);
        assertEquals(k.getFormule().size(),0);
        assertEquals(k.getMainCarteFormule().size(),9);

        assertFalse(k.isParfaiteNoire());
        assertFalse(k.isParfaiteOrange());
        assertFalse(k.getFermecouvercle());
    }


}
