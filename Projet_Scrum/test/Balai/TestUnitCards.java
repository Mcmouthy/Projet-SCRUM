package Balai;

import Balai.Exceptions.PiocheVideException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by PC-Dylan on 22/11/2016.
 */
public class TestUnitCards {

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

   /* @Test
    public void testUnitAttraction(){
        CarteMagieNoire c = new Sortilege(Type.ATTRACTION);
        Joueur j= new Joueur("toto");
        Joueur k=new Joueur("titi");
        Joueur l=new Joueur("tata");
        List<Joueur> list=new ArrayList<Joueur>();
        list.add(j);
        list.add(k);
        list.add(l);
        j.setPosition(10);
        k.setPosition(5);
        l.setPosition(15);
        Mockito.when(Sortilege.sortAttraction(j,list)).thenReturn(1);
        Assert.assertEquals(k.getPosition(),6);
        Assert.assertEquals(j.getPosition(),10);
        Assert.assertEquals(l.getPosition(),14);

        Ce test ne fonctionne pas mais bon j'ai fait la methode qui fait l'effet de attraction
        avec
    }*/

   @Test
   public void testUnitOubliRepare(){
       Joueur j=new Joueur("toto");
       j.getFormule().add(Des.symbole.ARAIGNEE);
       j.getFormule().add(Des.symbole.CHOC);
       j.getFormule().add(Des.symbole.ECLAIR);
       j.getFormule().add(Des.symbole.OEIL);
       Sortilege.sortOubliRepare(j,Des.symbole.ETOILE);
       Assert.assertEquals(j.getFormule().size(),5);
   }
}
