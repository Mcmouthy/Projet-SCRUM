package Balai;

/**
 * Created by PC-Dylan on 22/11/2016.
 */
public abstract class CarteMagieNoire {

    protected Type type;

    protected CarteMagieNoire() {}
    protected CarteMagieNoire(Type type)
    {
        this.type = type;
    }

    /*public void attacheJoueur(Joueur j)
    {
        j.addCard(this);
    }*/

    public static CarteMagieNoire carteFactory(Type type) {
        if((type == Type.LOOPING) || (type == Type.VOLINVERSE) || (type == Type.TONNEAU))
            return new Acrobatie(type);
        else
            return new Sortilege(type);
    }

    public abstract Type getType();
    public abstract boolean isAcrobatie();
    public abstract boolean isSortilege();
}
