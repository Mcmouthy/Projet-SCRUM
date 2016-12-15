package Balai;

import java.util.ArrayList;

/**
 * Created by PC-Dylan on 22/11/2016.
 */
public class Joueur {

    private String nom;
    private int position;
    private int rangCourse;
    private boolean expert;
    private boolean novice;
    private boolean maudit;
    private int points;

    private ArrayList<Sortilege> main = new ArrayList<>();
    private ArrayList<Acrobatie> mainAcrobatie = new ArrayList<>();
    private ArrayList<Des.symbole> formule= new ArrayList<>();
    private ArrayList<Des.symbole> mainCarteFormule= new ArrayList<>();
    private boolean malediction;


    public Joueur(String nom) {
        this.nom=nom;
        points=0;
    }

    public Joueur() {
        nom=null;
        points=0;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getNom() {
        return nom;
    }

    public int getPosition() {
        return position;
    }

    public int getRangCourse() {
        return rangCourse;
    }

    public void setRangCourse(int rangCourse) {
        this.rangCourse = rangCourse;
    }

    public void attributionPointArrive() {
        setPoints(getPoints()+25-(getRangCourse()-1));
    }

    private void setPoints(int pts) {
        points=pts;
    }

    public int getPoints() {
        return points;
    }

    public ArrayList<Des.symbole> getFormule() {
        return formule;
    }

    public void addMainAcrobatie(Acrobatie carte) {
        mainAcrobatie.add(carte);
    }

    public ArrayList<Sortilege> getMain()
    {
        return main;
    }

    public CarteMagieNoire addCarte(CarteMagieNoire carte) {
        if (carte.isAcrobatie()) {
            mainAcrobatie.add((Acrobatie) carte);
        }
        if (carte.isSortilege()) {
            main.add((Sortilege) carte);
        }

        return carte;
    }

    public void calculerScoreAcrobatie() {
        for (Acrobatie bonus : mainAcrobatie) setPoints(getPoints()+bonus.getValue());
    }

    public ArrayList<Acrobatie> getMainAcrobatie() {
        return mainAcrobatie;
    }

    public void addToFormule(Des.symbole etoile) {
        getFormule().add(etoile);
        getMainCarteFormule().remove(etoile);
    }

    public void setMainCarteFormule() {
        getMainCarteFormule().add(Des.symbole.ECLAIR);
        getMainCarteFormule().add(Des.symbole.ARAIGNEE);
        getMainCarteFormule().add(Des.symbole.OREILLE);
        getMainCarteFormule().add(Des.symbole.TETEDEMORT);
        getMainCarteFormule().add(Des.symbole.CHOC);
        getMainCarteFormule().add(Des.symbole.PLUIE);
        getMainCarteFormule().add(Des.symbole.OEIL);
        getMainCarteFormule().add(Des.symbole.TOILE);
        getMainCarteFormule().add(Des.symbole.ETOILE);
    }

    public ArrayList<Des.symbole> getMainCarteFormule() {
        return mainCarteFormule;
    }

    public boolean getMalediction() {
        return malediction;
    }

    public void setMalediction() {
        if (this.getRangCourse()==1) this.malediction=true;
        else this.malediction=false;
    }
}
