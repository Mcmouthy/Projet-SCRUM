package Balai;

/**
 * Created by PC-Dylan on 22/11/2016.
 */
public class Joueur {

    private String nom;
    private int position;
    private int rangCourse;
    private boolean expert;
    private boolean novice;
    private int points;


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

}