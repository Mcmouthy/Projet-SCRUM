package Balai;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC-Dylan on 22/11/2016.
 */
public class Joueur {

    private String nom;
    private int position;
    private int rangCourse;
    private boolean expert;
    private boolean novice;
    List<CarteMagieNoire> main;

    public Joueur(String nom) {
        this.nom=nom;
        main = new ArrayList<CarteMagieNoire>();
    }

    public Joueur() {
        nom=null;
        main = new ArrayList<CarteMagieNoire>();
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

    public void addCard(CarteMagieNoire card) {
        main.add(card);
    }
    public void removeCard(CarteMagieNoire card) {main.remove(card); }
    public void removeCardAtIndex(int i) {main.remove(i); }

    public void utiliser()
    {

    }

    public List<CarteMagieNoire> getMain() {
        return main;
    }
}
