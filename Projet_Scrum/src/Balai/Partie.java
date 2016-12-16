package Balai;

import Balai.Exceptions.PiocheVideException;
import Balai.Exceptions.SortieTableauException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by PC-Dylan on 22/11/2016.
 */
public class Partie {
    Random loto = new Random();
    private List<Joueur> listejoueur;
    private boolean fin;
    private Pioche pioche;
    private List<Des.symbole[][]> formuleJeu;

    public Partie(){
        listejoueur= new ArrayList<>();
        fin=false;
        pioche = new Pioche();
    }

    public void ajouterJoueur(Joueur j1) {
        listejoueur.add(j1);
    }

    public List<Joueur> getlistejoueur() {
        return listejoueur;
    }

    public void init() {
        pioche.init();
        for (Joueur j:listejoueur){
            j.setPosition(0);
            j.setRangCourse(1);
        }
    }

    public void deplaceJoueur(Joueur j, int i) throws SortieTableauException {
        if (j.getPosition()+i<-2) throw new SortieTableauException();
        else j.setPosition(j.getPosition() + i);
        if (j.getPosition()>22) {
            setFinPartie();
            j.attributionPointArrive();
        }
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

    public Pioche getPioche() {
        return pioche;
    }

    public CarteMagieNoire piocher(Joueur j) throws PiocheVideException {
        return j.addCarte(pioche.piocherCarte());
    }

    public List<Des.symbole[][]> getFormuleJeu() {
        return formuleJeu;
    }

    public void genereFormuleJeu() {
        Des.setListeDes();
        for(Des.symbole[][] de:Des.listeDes){
            int value=loto.nextInt(9);
            Des.symbole[][] tab = new Des.symbole[2][1];
            tab[0][0]=de[0][value];
            tab[1][0]=de[1][value];
            formuleJeu.add(tab);

        }
    }
}
