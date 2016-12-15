package Balai;

import Balai.Exceptions.PiocheVideException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Sami on 15/12/2016.
 */
public class TestUnitPioche {

    @Test
    public void testUnitCreationPioche() throws PiocheVideException {
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
    public void testUnitCompositionPioche() throws PiocheVideException {
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

    @Test(expected = PiocheVideException.class)
    public void testPiocheVide() throws PiocheVideException {
        Pioche p = new Pioche();
        for (int i = 0; i < 28; i++)
            p.piocherCarte();
    }



    //FAIRE LES TESTS SUPPLEMENTAIRES
}
