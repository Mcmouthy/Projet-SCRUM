package Balai;

/**
 * Created by PC-Dylan on 22/11/2016.
 */
public abstract class CarteMagieNoire {

    protected Type type;

    public CarteMagieNoire() {}
    public CarteMagieNoire(Type type)
    {
        this.type = type;
    }

    /*public void attacheJoueur(Joueur j)
    {
        j.addCard(this);
    }*/

    public abstract Type getType();
    public abstract boolean isAcrobatie();
    public abstract boolean isSortilege();
}
