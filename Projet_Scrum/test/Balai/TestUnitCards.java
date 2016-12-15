package Balai;

import org.junit.Assert;
import org.junit.Test;

import javax.accessibility.AccessibleStateSet;

/**
 * Created by PC-Dylan on 22/11/2016.
 */
public class TestUnitCards {

    @Test
    public void testUnitCreationPioche(){
        Pioche pioche=new Pioche();
        pioche.init();
        CarteMagieNoire carteCourante;
        int nbAcrobatie=0;
        int nbSortilege=0;
        Assert.assertEquals(pioche.taille(),27); // il y a 27 cartes dans la pioches
        for (int i=0;i<27;i++){
            carteCourante =pioche.piocherCarte();
            if (carteCourante instanceof Acrobatie ){
                nbAcrobatie+=1;
            }
            else if(carteCourante instanceof Sortilege){
                nbSortilege+=1;
            }
        }
        Assert.assertEquals(nbAcrobatie,9); //Il doit y avoir 9 cartes acrobatie dans la pioche
        Assert.assertEquals(nbSortilege,18); //Il doit y avoir 18 cartes sortilege dans la pioche
    }



    @Test
    public void testUnitCompositionPioche(){
        Pioche pioche=new Pioche();
        pioche.init(); //init créé une pioche de 27 cartes et les mélanges
        CarteMagieNoire carteCourante;
        int nbTonneau=0;
        int nbRectification=0;
        int nbVolInverse=0;
        int nbAttraction=0;
        int nbDoubleJeu=0;
        int nbVentArriere=0;
        int nbOutilRepare=0;
        int nbDecret=0;
        int nbBlocage=0;
        int nbMauvaisSort=0;
        int nbBrouillardMagique=0;
        int nbLooping=0;
        for (int i=0;i<27;i++){
            carteCourante =pioche.piocherCarte();
            switch (carteCourante.getType()){
                case TONNEAU:
                    nbTonneau+=1;
                    break;
                case RECTIFICATION:
                    nbRectification+=1;
                    break;
                case VOLINVERSE:
                    nbVolInverse+=1;
                    break;
                case ATTRACTION:
                    nbAttraction+=1;
                    break;
                case DOUBLEJEU:
                    nbDoubleJeu+=1;
                    break;
                case VENTARRIERE:
                    nbVentArriere+=1;
                    break;
                case OUTILREPARE:
                    nbOutilRepare+=1;
                    break;
                case DECRET:
                    nbDecret+=1;
                    break;
                case BLOCAGE:
                    nbBlocage+=1;
                    break;
                case MAUVAISSORT:
                    nbMauvaisSort+=1;
                    break;
                case BROUILLARDMAGIQUE:
                    nbBrouillardMagique+=1;
                    break;
                case LOOPING:
                    nbLooping+=1;
                    break;
            }
        }
        Assert.assertEquals(nbTonneau,3);
        Assert.assertEquals(nbRectification,2);
        Assert.assertEquals(nbVolInverse,4);
        Assert.assertEquals(nbAttraction,2);
        Assert.assertEquals(nbDoubleJeu,3);
        Assert.assertEquals(nbVentArriere,3);
        Assert.assertEquals(nbOutilRepare,2);
        Assert.assertEquals(nbDecret,2);
        Assert.assertEquals(nbBlocage,1);
        Assert.assertEquals(nbMauvaisSort,1);
        Assert.assertEquals(nbBrouillardMagique,2);
        Assert.assertEquals(nbLooping,2);
    }



    @Test
    public void testUnitEffetCarte(){
        CarteMagieNoire carte = new Sortilege(Type.ATTRACTION);
        Joueur j = new Joueur();
       // carte.attacheJoueur(j); // En réalité cette méthode n'est pas utile

    }
    @Test
    public void testUnitCardsToString() {
        CarteMagieNoire carte = new Sortilege(Type.ATTRACTION);
        Assert.assertTrue(carte.toString().equals("ATTRACTION"));
    }
    @Test
    public void testUnitCardsIsAcrobatie() {
        CarteMagieNoire carteA = new Acrobatie(Type.LOOPING);
        CarteMagieNoire carteS = new Sortilege(Type.ATTRACTION);
        Assert.assertTrue(carteA.isAcrobatie());
        Assert.assertFalse(carteS.isAcrobatie());
        Assert.assertFalse(carteA.isSortilege());
        Assert.assertTrue(carteS.isSortilege());
    }

    @Test
    public void testUnitGetValueAcrobatie() {
        CarteMagieNoire c = new Acrobatie(Type.TONNEAU);
        Assert.assertEquals(((Acrobatie)c).getValue(), 2);
    }

    @Test
    public void testUnitVentArriere(){
        CarteMagieNoire c= new Sortilege(Type.VENTARRIERE);
        Joueur j= new Joueur("oui");
        j.setPosition(5);
        j.setRangCourse(2);
        Sortilege.sortVentArriere(j);
        Assert.assertEquals(j.getPosition(),7);
    }

    @Test
    public void testUnitMauvaisSort(){
        CarteMagieNoire c= new Sortilege(Type.MAUVAISSORT);
        Joueur j= new Joueur("toto");
        j.setPosition(10);
        j.setRangCourse(1);
        Sortilege.sortMauvaisSort(j);
        Assert.assertEquals(j.getPosition(),7);
    }

}
