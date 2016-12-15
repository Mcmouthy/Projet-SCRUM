package Balai;

/**
 * Created by Sami on 22/11/2016.
 */
public class Sortilege extends CarteMagieNoire {

    protected Sortilege(Type type)
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
}
