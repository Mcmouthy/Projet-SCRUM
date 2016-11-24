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

    // compter le nb de joueur devant un autre
    public void comparePosition() {
        //au debut du jeu, tout les joueurs sont en 0 et sont classés premiers
        List<Joueur> listJ=new ArrayList<Joueur>();
        for (Joueur j : listejoueur) listJ.add(j);
        for (Joueur j : listejoueur) {
            int cptAhead=0;
            int indexJ = listJ.indexOf(j);
            listJ.remove(j);
            //on compare chaque j aux autres joueur
            for (Joueur p : listJ) {
                //si p est devant j, on increment le compteur
                if (j.getPosition()<p.getPosition()) cptAhead++;
            }
            //une fois j comparé aux autres, son rang est = au nb de joueur devant lui +1
            j.setRangCourse(cptAhead+1);
            listJ.add(indexJ,j);
        }
    }
}
