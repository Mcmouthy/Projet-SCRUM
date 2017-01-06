package Balai;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
    private boolean fermecouvercle;
    private boolean parfaiteOrange;
    private boolean parfaiteNoire;

    private ArrayList<Sortilege> main = new ArrayList<>();
    private ArrayList<Acrobatie> mainAcrobatie = new ArrayList<>();
    private Set<Des.symbole> formule= new HashSet<>();
    private Set<Des.symbole> mainCarteFormule= new HashSet<>();
    private boolean malediction;


    public Joueur(String nom) {
        this.nom=nom;
        points=0;
        parfaiteOrange=false;
        parfaiteNoire=false;
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

    public void setParfaiteNoire(boolean parfaiteNoire) {
        this.parfaiteNoire = parfaiteNoire;
    }

    public void setParfaiteOrange(boolean parfaiteOrange) {
        this.parfaiteOrange = parfaiteOrange;
    }

    public boolean isParfaiteNoire() {
        return parfaiteNoire;
    }

    public boolean isParfaiteOrange() {
        return parfaiteOrange;
    }

    public String getNom() {
        return nom;
    }

    public int getPosition() {
        return position;
    }

    public boolean getFermecouvercle() {
        return fermecouvercle;
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

    public void setFermecouvercle(boolean fermecouvercle) {
        this.fermecouvercle = fermecouvercle;
    }

    public int getPoints() {
        return points;
    }

    public Set<Des.symbole> getFormule() {
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
        mainCarteFormule.removeAll(mainCarteFormule);
        mainCarteFormule.add(Des.symbole.ECLAIR);
        mainCarteFormule.add(Des.symbole.ARAIGNEE);
        mainCarteFormule.add(Des.symbole.OREILLE);
        mainCarteFormule.add(Des.symbole.TETEDEMORT);
        mainCarteFormule.add(Des.symbole.CHOC);
        mainCarteFormule.add(Des.symbole.PLUIE);
        mainCarteFormule.add(Des.symbole.OEIL);
        mainCarteFormule.add(Des.symbole.TOILE);
        mainCarteFormule.add(Des.symbole.ETOILE);
    }

    public Set<Des.symbole> getMainCarteFormule() {
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
