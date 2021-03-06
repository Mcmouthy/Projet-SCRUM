package Balai;

import java.util.List;
import java.util.Random;

/**
 * Created by Sami on 22/11/2016.
 */
public class Sortilege extends CarteMagieNoire {

    public static Random loto=new Random();

    @Deprecated
    /* Plutôt utiliser la méthode statique CarteMagieNoire.carteFactory(Type type)
     * */
    public Sortilege(Type type)
    {
        this.type = type;

        // GERER LES EXEPTIONS !!!!!!
    }
    public Type getType()
    {
        return type;
    }
    public boolean isAcrobatie() {return false;}
    public boolean isSortilege() {return true;}

    public static void sortVentArriere(Joueur j) {
        j.setPosition(j.getPosition()+j.getRangCourse());
    }

    public static void sortMauvaisSort(Joueur j) {
        j.setPosition(j.getPosition()-3);
    }

    public static int sortAttraction(Joueur j, List<Joueur> list) {

        for (Joueur l:list){
            if ((!l.equals(j)) && l.getPosition()>j.getPosition()){ l.setPosition(l.getPosition()-1);}

            else if((!l.equals(j)) && l.getPosition()<j.getPosition()){l.setPosition(l.getPosition()+1);}
        }
        return 1;
    }

    public static  void sortDoubleJeu(Joueur j){
        j.setDoubleJeuActive(true);
    }



    public static void sortOubliRepare(Joueur j, Des.symbole etoile) {
        j.addToFormule(etoile);
    }
}
