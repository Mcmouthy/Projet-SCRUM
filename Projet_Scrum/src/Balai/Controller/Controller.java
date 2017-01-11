package Balai.Controller;

import Balai.*;
import Balai.Exceptions.PiocheVideException;
import Balai.Exceptions.SortieTableauException;
import Balai.Vue.End;
import Balai.Vue.Start;
import Balai.Vue.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

/**
 * Created by malonesk on 07/01/17.
 */
public class Controller implements ActionListener {
    private Partie partie;
    private View vue;
    private Start st;
    public boolean isAjouter, isCommencer;
    public Controller(View view, Partie partie) {

        this.partie=partie;
        this.vue=view;
    }

    public Controller(Start st, Partie partie) {

        this.partie=partie;
        this.st=st;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (((((JButton)e.getSource()).getName()).equals("rectif")) || ((((JButton)e.getSource()).getName()).equals("rectif2"))){ //il me faut la suite de vue pour faire
            vue.removeCarteFromPanel(partie.getlistejoueur().get(partie.getJoueurCourant()).removeCarteFromMain(Type.RECTIFICATION));

        }
        if(((((JButton)e.getSource()).getName()).equals("attraction")) || ((((JButton)e.getSource()).getName()).equals("attraction2")) ){
            Sortilege.sortAttraction(partie.getlistejoueur().get(partie.getJoueurCourant()),partie.getlistejoueur());
            vue.removeCarteFromPanel(partie.getlistejoueur().get(partie.getJoueurCourant()).removeCarteFromMain(Type.ATTRACTION));
            vue.placerJoueur(partie);

        }

        if(((((JButton)e.getSource()).getName()).equals("doublejeu")) || ((((JButton)e.getSource()).getName()).equals("doublejeu2")) || ((((JButton)e.getSource()).getName()).equals("doublejeu3"))){ //Ne pas oublier de faire la verif lors de l'entrée d'une formule pour double jeu
            Sortilege.sortDoubleJeu(partie.getlistejoueur().get(partie.getJoueurCourant()));
            vue.removeCarteFromPanel(partie.getlistejoueur().get(partie.getJoueurCourant()).removeCarteFromMain(Type.DOUBLEJEU));


        }

        if(((((JButton)e.getSource()).getName()).equals("oublirep")) || ((((JButton)e.getSource()).getName()).equals("oublirep2"))){ //il me faut la suite de vue pour faire
            vue.removeCarteFromPanel(partie.getlistejoueur().get(partie.getJoueurCourant()).removeCarteFromMain(Type.OUTILREPARE));

        }

        if(((((JButton)e.getSource()).getName()).equals("decret")) ||((((JButton)e.getSource()).getName()).equals("decret2")) ){ //peut pas faire sans la partie réseau
            vue.removeCarteFromPanel(partie.getlistejoueur().get(partie.getJoueurCourant()).removeCarteFromMain(Type.DECRET));
        }
        if(((((JButton)e.getSource()).getName()).equals("blocage"))){
            partie.setBlocage(partie.getlistejoueur().get(partie.getJoueurCourant()).getPosition());
            vue.removeCarteFromPanel(partie.getlistejoueur().get(partie.getJoueurCourant()).removeCarteFromMain(Type.BLOCAGE));
        }

        if(((((JButton)e.getSource()).getName()).equals("ventarriere")) ||((((JButton)e.getSource()).getName()).equals("ventarriere2")) || ((((JButton)e.getSource()).getName()).equals("ventarriere3"))){
            Sortilege.sortVentArriere(partie.getlistejoueur().get(partie.getJoueurCourant()));
            vue.removeCarteFromPanel(partie.getlistejoueur().get(partie.getJoueurCourant()).removeCarteFromMain(Type.VENTARRIERE));
            SwingUtilities.updateComponentTreeUI(vue);

        }

        if(((((JButton)e.getSource()).getName()).equals("mauvaissort"))){
            for (int i=0;i<partie.getlistejoueur().size();i++){
                if(partie.getlistejoueur().get(i).getPosition()==1){
                    Sortilege.sortMauvaisSort(partie.getlistejoueur().get(i));

                }

            }
            vue.removeCarteFromPanel(partie.getlistejoueur().get(partie.getJoueurCourant()).removeCarteFromMain(Type.MAUVAISSORT));

        }
        if(((((JButton)e.getSource()).getName()).equals("brouillagem")) || ((((JButton)e.getSource()).getName()).equals("brouillagem2"))){
            vue.removeCarteFromPanel(partie.getlistejoueur().get(partie.getJoueurCourant()).removeCarteFromMain(Type.BROUILLARDMAGIQUE));


        }

        if(((((JButton)e.getSource()).getName()).equals("pioche"))){
            try {
                CarteMagieNoire carte = (partie.piocher(partie.getlistejoueur().get(partie.getJoueurCourant())));
                vue.addCarteToPanel(carte);

            } catch (PiocheVideException e1) {
                e1.printStackTrace();
            }

        }

        if(((((JButton)e.getSource()).getName()).equals("des"))){
            vue.updateDes(Des.lanceDes());
        }
        if(((((JButton)e.getSource()).getName()).equals("cacher"))){
            vue.hideDes();
        }

        if(((((JButton)e.getSource()).getName()).equals("toile"))){
            partie.getlistejoueur().get(partie.getJoueurCourant()).addToFormule(Des.symbole.TOILE);
            vue.setPanelSymbolFormule(vue.toile);
        }
        if(((((JButton)e.getSource()).getName()).equals("eclair"))){
            partie.getlistejoueur().get(partie.getJoueurCourant()).addToFormule(Des.symbole.ECLAIR);
            vue.setPanelSymbolFormule(vue.eclair);

        }
        if(((((JButton)e.getSource()).getName()).equals("arraignee"))){
            partie.getlistejoueur().get(partie.getJoueurCourant()).addToFormule(Des.symbole.ARAIGNEE);
            vue.setPanelSymbolFormule(vue.arraignee);

        }

        if(((((JButton)e.getSource()).getName()).equals("pluie"))){
            partie.getlistejoueur().get(partie.getJoueurCourant()).addToFormule(Des.symbole.PLUIE);
            vue.setPanelSymbolFormule(vue.pluie);

        }
        if(((((JButton)e.getSource()).getName()).equals("etoile"))){
            partie.getlistejoueur().get(partie.getJoueurCourant()).addToFormule(Des.symbole.ETOILE);
            vue.setPanelSymbolFormule(vue.etoile);

        }
        if(((((JButton)e.getSource()).getName()).equals("oeil"))){
            partie.getlistejoueur().get(partie.getJoueurCourant()).addToFormule(Des.symbole.OEIL);
            vue.setPanelSymbolFormule(vue.oeil);

        }
        if(((((JButton)e.getSource()).getName()).equals("oreille"))){
            partie.getlistejoueur().get(partie.getJoueurCourant()).addToFormule(Des.symbole.OREILLE);
            vue.setPanelSymbolFormule(vue.oreille);

        }
        if(((((JButton)e.getSource()).getName()).equals("tetedemort"))){
            partie.getlistejoueur().get(partie.getJoueurCourant()).addToFormule(Des.symbole.TETEDEMORT);
            vue.setPanelSymbolFormule(vue.tetedemort);

        }
        if(((((JButton)e.getSource()).getName()).equals("choc"))){
            partie.getlistejoueur().get(partie.getJoueurCourant()).addToFormule(Des.symbole.CHOC);
            vue.setPanelSymbolFormule(vue.choc);

        }
        if(((((JButton)e.getSource()).getName()).equals("soumettre"))){
            if (partie.getFormuleOrange().size()!=0 || partie.getFormuleNoire().size()!=0){
                Joueur j=partie.getlistejoueur().get(partie.getJoueurCourant());
                j.setParfaiteNoire(partie.parfaite(j.getFormule(),j));
                j.setParfaiteOrange(partie.parfaite(j.getFormule(),j));
                if(partie.isformulefausse(j.getFormule(),partie.getFormuleNoire(),j) && partie.isformulefausse(j.getFormule(),partie.getFormuleOrange(),j)) vue.afficheFormuleFausse();

                if((!partie.isformulefausse(j.getFormule(),partie.getFormuleOrange(),j)) && j.isParfaiteOrange()){
                    try {
                        partie.deplaceJoueur(j,j.getFormule().size()+2);
                        vue.placerJoueur(partie);
                        SwingUtilities.updateComponentTreeUI(vue);
                    } catch (SortieTableauException e1) {
                        e1.printStackTrace();
                    }
                }else if (!partie.isformulefausse(j.getFormule(),partie.getFormuleOrange(),j)) try {
                    partie.deplaceJoueur(j,j.getFormule().size());
                    vue.placerJoueur(partie);
                    SwingUtilities.updateComponentTreeUI(vue);
                } catch (SortieTableauException e1) {
                    e1.printStackTrace();
                }
                else if (!partie.isformulefausse(j.getFormule(),partie.getFormuleNoire(),j)){
                    try {
                        partie.deplaceJoueur(j,j.getFormule().size());
                        vue.placerJoueur(partie);
                        SwingUtilities.updateComponentTreeUI(vue);
                    } catch (SortieTableauException e1) {
                        e1.printStackTrace();
                    }
                    if (j.isParfaiteNoire()){
                        for (int i=0; i<j.getFormule().size();i++){
                            try {
                                j.addCarte(partie.getPioche().piocherCarte());
                            } catch (PiocheVideException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                }
                vue.initPanelSymboleFormule();
                vue.resetCurrentChoixRestantFormule();
                vue.resetJLabelFormule();
                if (partie.getJoueurCourant()==partie.getlistejoueur().size()-1){
                    partie.reinitcomposant(partie.getlistejoueur());
                    vue.updateDes(Des.lanceDes());
                }
                partie.setJoueurCourant(partie.getJoueurCourant()+1);
                vue.afficheChangementTour();
                //partie.comparePosition();
                vue.setMainAcrobatiePanel(partie.getlistejoueur().get(partie.getJoueurCourant()).getMainAcrobatie());
                vue.setMainSortPanel(partie.getlistejoueur().get(partie.getJoueurCourant()).getMain());
                SwingUtilities.updateComponentTreeUI(vue);
            }else{
                vue.afficheErrorLancerNonFait();
            };
            if (partie.getFin()) {
                End end = new End(partie);
            }
        }

        if (((((JButton)e.getSource()).getText()).equals("Commencer"))) {
            if (isAjouter) {
                vue.setActionListener(this);
            }
        }
        if (((((JButton)e.getSource()).getText()).equals("Ajouter"))) {
            vue= new View(partie);
            String[] nomJoueurs = new String[6];
            for (int i=0;i<st.nomJoueurs.length;i++) {
                nomJoueurs[i]=st.nomJoueurs[i].getText();
            }
            st.setNomJoueurOnPanel(nomJoueurs);
            for (int j=0;j<nomJoueurs.length;j++) {

                if (!nomJoueurs[j].equals("")) {
                    partie.ajouterJoueur(new Joueur(nomJoueurs[j]));
                    /*





                     */
                    partie.getlistejoueur().get(j).setPosition(0);
                    /*





                     */
                    vue.setMainSortPanel(partie.getlistejoueur().get(j).getMain());

                    vue.setMainAcrobatiePanel(partie.getlistejoueur().get(j).getMainAcrobatie());

                    //v.setPanelSymbolFormule(v.eclair);

                }


            }
            vue.placerJoueur(partie);
            vue.setActionListener(this);
            isAjouter=true;
        }
    }
}
