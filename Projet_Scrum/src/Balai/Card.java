package Balai;

/**
 * Created by PC-Dylan on 22/11/2016.
 */
public class Card {

    private Effet effet;

    public Card()
    {

    }

    public Card(Effet effet)
    {
        this.effet = effet;
    }
    //Pas nécéssaire, je comprends pas à quoi ça sert ?
    public void attacheJoueur(Joueur j) {

    }

    public  enum Effet {TONNEAU,RECTIFICATION,VOLINVERSE,ATTRACTION,DOUBLEJEU,VENTARRIERE,OUTILREPARE,DECRET,BLOCAGE,
        MAUVAISSORT,BROUILLARDMAGIQUE,LOOPING}
    public enum TYPE{ACCROBATIE,SORTILEGE}


}
