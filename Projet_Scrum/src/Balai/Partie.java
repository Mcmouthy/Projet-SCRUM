package Balai;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC-Dylan on 22/11/2016.
 */
public class Partie {
    private List<Joueur> listejoueur;
    private boolean fin;

    public Partie(){
        listejoueur= new ArrayList<>();
        fin=false;
    }

    public void ajouterJoueur(Joueur j1) {
        listejoueur.add(j1);
    }

    public List<Joueur> getlistejoueur() {
        return listejoueur;
    }

    public void init() {
        for (Joueur j:listejoueur){
            j.setPosition(0);
        }
    }

    public void deplaceJoueur(Joueur j, int i) throws SortieTableauException{
        if (j.getPosition()+i<-2) throw new SortieTableauException();
        else j.setPosition(j.getPosition() + i);
        if (j.getPosition()>22) setFinPartie();
    }

    private void setFinPartie() {
        fin=true;
    }

    public boolean getFin(){
        return fin;
    }


    public void setFin(boolean fin) {
        this.fin = fin;
    }
}
