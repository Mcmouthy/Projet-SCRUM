package Balai;

/**
 * Created by PC-Dylan on 22/11/2016.
 */
public class CarteMagieNoire {

    private Effet effet;

    public CarteMagieNoire()
    {

    }

    public CarteMagieNoire(Effet effet)
    {
        this.effet = effet;
    }

    public Effet getEffet()
    {
        return effet;
    }

    public void attacheJoueur(Joueur j)
    {
        j.addCard(this);
    }

    public enum Effet {TONNEAU,RECTIFICATION,VOLINVERSE,ATTRACTION,DOUBLEJEU,VENTARRIERE,OUTILREPARE,DECRET,BLOCAGE,
        MAUVAISSORT,BROUILLARDMAGIQUE,LOOPING}
}
