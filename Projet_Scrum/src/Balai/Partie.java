package Balai;

import Balai.Exceptions.PiocheVideException;
import Balai.Exceptions.SortieTableauException;

import java.util.*;

/**
 * Created by PC-Dylan on 22/11/2016.
 */
public class Partie {
    Random loto = new Random();
    private List<Joueur> listejoueur;
    private int joueurCourant;
    private boolean fin;
    private Pioche pioche;
    private ArrayList<Des.symbole[][]> formuleJeu;
    private Set<Des.symbole> formuleNoire; //on utilise des set car on ne veut pas de doublons
    private Set<Des.symbole> formuleOrange;
    private Set<Des.symbole> formuleInterdit;
    private int NoJoueurBlocage;
    private Des.symbole symbole[];

    public Partie(){
        joueurCourant=0;
        listejoueur= new ArrayList<>();
        fin=false;
        pioche = new Pioche();
        formuleJeu = new ArrayList<>();
        formuleNoire= new HashSet<>();
        formuleOrange= new HashSet<>();
        formuleInterdit=new HashSet<>();
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
    public Des.symbole[] getDesSymboles(){
        return symbole;
    }

    public void setDesSymbole(Des.symbole[] symboles){
        symbole=symboles;
    }
    public void deplaceJoueur(Joueur j, int i) throws SortieTableauException {
        if (j.getPosition()+i<-2) throw new SortieTableauException();
        //a tester (si la carte blocage est active)
        else if(j.getPosition()+i>listejoueur.get(NoJoueurBlocage).getPosition() && j.getPosition()<listejoueur.get(NoJoueurBlocage).getPosition()){j.setPosition(listejoueur.get(NoJoueurBlocage).getPosition());}
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
    public void setJoueurCourant(int i){joueurCourant=i;}
    public int getJoueurCourant(){return joueurCourant;}
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

    public ArrayList<Des.symbole[][]> genereFormuleJeu() {
        Des.setListeDes();
        for(Des.symbole[][] de:Des.listeDes){
            int value=loto.nextInt(6);
            Des.symbole[][] tab = new Des.symbole[2][1];
            tab[0][0]=de[0][value];
            tab[1][0]=de[1][value];
            formuleJeu.add(tab);
        }
        return formuleJeu;
    }

    public void genereFormulesFinales() {
        for (Des.symbole[][] d:formuleJeu){
            if (d[0][1]==Des.symbole.NOIR)formuleNoire.add(d[0][0]);
            else formuleOrange.add(d[0][0]);
            if (formuleNoire.contains(d[0][0]) && formuleOrange.contains(d[0][0])){
                formuleInterdit.add(d[0][0]);
                formuleNoire.remove(d[0][0]);
                formuleOrange.remove(d[0][0]);
            }
        }
        formuleJeu.removeAll(formuleJeu);
    }

    public void setFormuleJeu(ArrayList<Des.symbole[][]> formuleJeu) {
        this.formuleJeu = formuleJeu;
    }

    public boolean parfaite(Set<Des.symbole> atester){
        if (atester.equals(formuleNoire)){
            return true;
        }else if (atester.equals(formuleOrange)){
            return true;
        }
        return false;
    }

    public boolean isformulefausse(Set<Des.symbole> test,Set<Des.symbole> form){
        if (test.size()>form.size()) return true;
        if (test.size()<form.size()){
            for (Des.symbole symbole : test){
                if (!form.contains(symbole)) return true;
            }
            return false; // on retourne 0 pour en fait dire que la formule n'est pas fausse
        }
        if (test.size()==form.size()){
            if (parfaite(test)){
                return false;
            }else{
                return true;
            }
        }
        return true;
    }

    public void reinitcomposant(List<Joueur> listejoueur){
        for(Joueur j : listejoueur){
            j.setParfaiteOrange(false);
            j.setParfaiteNoire(false);
            j.setFermecouvercle(false);
            j.getFormule().removeAll(j.getFormule());
            j.setMainCarteFormule();
        }
        formuleNoire.removeAll(formuleNoire);
        formuleOrange.removeAll(formuleOrange);
        formuleInterdit.removeAll(formuleInterdit);
        formuleJeu.removeAll(formuleJeu);
    }

    public void tour() throws SortieTableauException, PiocheVideException {
        setFormuleJeu(genereFormuleJeu());
        genereFormulesFinales();
        for (Joueur j : listejoueur){
            //ici on fait les formules
            //je pense que cette methode devra se mettre dans le controleur
            j.setParfaiteNoire(parfaite(j.getFormule()));
            j.setParfaiteOrange(parfaite(j.getFormule()));
            if (isformulefausse(j.getFormule(),formuleOrange) && isformulefausse(j.getFormule(),formuleNoire)){
                deplaceJoueur(j,0);
            }else if(!isformulefausse(j.getFormule(),formuleOrange) && j.isParfaiteOrange()){
                deplaceJoueur(j,j.getFormule().size()+2);
            }else if (!isformulefausse(j.getFormule(),formuleOrange))deplaceJoueur(j,j.getFormule().size());
            else if (!isformulefausse(j.getFormule(),formuleNoire)){
                deplaceJoueur(j,j.getFormule().size());
                if (j.isParfaiteNoire()){
                    for (int i=0; i<j.getFormule().size();i++){
                        j.addCarte(pioche.piocherCarte());
                    }
                }
            }
        }
        //on applique les effets des cartes

    }

    public void setBlocage(int blocage) {
        this.NoJoueurBlocage = blocage;
    }

    public int getBlocage(){return NoJoueurBlocage;}

}
