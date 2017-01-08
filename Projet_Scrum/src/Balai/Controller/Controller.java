package Balai.Controller;

import Balai.*;
import Balai.Exceptions.PiocheVideException;
import Balai.Vue.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by malonesk on 07/01/17.
 */
public class Controller implements ActionListener {
    private Partie partie;
    private View vue;
    public Controller(View view, Partie partie) {

        this.partie=partie;
        this.vue=view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (((((JButton)e.getSource()).getName()).equals("rectif")) || ((((JButton)e.getSource()).getName()).equals("rectif2"))){ //il me faut la suite de vue pour faire
            vue.removeCarteFromPanel(partie.getlistejoueur().get(partie.getJoueurCourant()).removeCarteFromMain(Type.RECTIFICATION));
            System.out.print("rectif");

        }
        if(((((JButton)e.getSource()).getName()).equals("attraction")) || ((((JButton)e.getSource()).getName()).equals("attraction2")) ){
            Sortilege.sortAttraction(partie.getlistejoueur().get(partie.getJoueurCourant()),partie.getlistejoueur());
            vue.removeCarteFromPanel(partie.getlistejoueur().get(partie.getJoueurCourant()).removeCarteFromMain(Type.ATTRACTION));

            System.out.println("attraction");

        }

        if(((((JButton)e.getSource()).getName()).equals("doublejeu")) || ((((JButton)e.getSource()).getName()).equals("doublejeu2")) || ((((JButton)e.getSource()).getName()).equals("doublejeu3"))){ //Ne pas oublier de faire la verif lors de l'entrée d'une formule pour double jeu
            Sortilege.sortDoubleJeu(partie.getlistejoueur().get(partie.getJoueurCourant()));
            vue.removeCarteFromPanel(partie.getlistejoueur().get(partie.getJoueurCourant()).removeCarteFromMain(Type.DOUBLEJEU));
            System.out.println("doubleJeu");


        }

        if(((((JButton)e.getSource()).getName()).equals("oublirep")) || ((((JButton)e.getSource()).getName()).equals("oublirep2"))){ //il me faut la suite de vue pour faire
            vue.removeCarteFromPanel(partie.getlistejoueur().get(partie.getJoueurCourant()).removeCarteFromMain(Type.OUTILREPARE));
            System.out.println("oublirep");

        }

        if(((((JButton)e.getSource()).getName()).equals("decret")) ||((((JButton)e.getSource()).getName()).equals("decret2")) ){ //peut pas faire sans la partie réseau
            vue.removeCarteFromPanel(partie.getlistejoueur().get(partie.getJoueurCourant()).removeCarteFromMain(Type.DECRET));
            System.out.println("decret");
        }
        if(((((JButton)e.getSource()).getName()).equals("blocage"))){
            partie.setBlocage(partie.getlistejoueur().get(partie.getJoueurCourant()).getPosition());
            vue.removeCarteFromPanel(partie.getlistejoueur().get(partie.getJoueurCourant()).removeCarteFromMain(Type.BLOCAGE));
            System.out.println("blocage");
        }

        if(((((JButton)e.getSource()).getName()).equals("ventarriere")) ||((((JButton)e.getSource()).getName()).equals("ventarriere2")) || ((((JButton)e.getSource()).getName()).equals("ventarriere3"))){
            Sortilege.sortVentArriere(partie.getlistejoueur().get(partie.getJoueurCourant()));
            vue.removeCarteFromPanel(partie.getlistejoueur().get(partie.getJoueurCourant()).removeCarteFromMain(Type.VENTARRIERE));
            System.out.println("ventarriere");

        }

        if(((((JButton)e.getSource()).getName()).equals("mauvaissort"))){
            for (int i=0;i<partie.getlistejoueur().size();i++){
                if(partie.getlistejoueur().get(i).getPosition()==1){
                    Sortilege.sortMauvaisSort(partie.getlistejoueur().get(i));

                }

            }
            vue.removeCarteFromPanel(partie.getlistejoueur().get(partie.getJoueurCourant()).removeCarteFromMain(Type.MAUVAISSORT));
            System.out.println("mauvaissort");

        }
        if(((((JButton)e.getSource()).getName()).equals("brouillagem")) || ((((JButton)e.getSource()).getName()).equals("brouillagem2"))){
            vue.removeCarteFromPanel(partie.getlistejoueur().get(partie.getJoueurCourant()).removeCarteFromMain(Type.BROUILLARDMAGIQUE));
            System.out.println("brouillard");


        }

        if(((((JButton)e.getSource()).getName()).equals("pioche"))){
            try {
                CarteMagieNoire carte = (partie.piocher(partie.getlistejoueur().get(partie.getJoueurCourant())));
                System.out.println(carte.getType().toString());
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
            partie.getlistejoueur().get(partie.getJoueurCourant()).addFormule(Des.symbole.TOILE);
            vue.setPanelSymbolFormule(vue.toile);
        }
        if(((((JButton)e.getSource()).getName()).equals("eclair"))){
            partie.getlistejoueur().get(partie.getJoueurCourant()).addFormule(Des.symbole.ECLAIR);
            vue.setPanelSymbolFormule(vue.eclair);

        }
        if(((((JButton)e.getSource()).getName()).equals("arraignee"))){
            partie.getlistejoueur().get(partie.getJoueurCourant()).addFormule(Des.symbole.ARAIGNEE);
            vue.setPanelSymbolFormule(vue.arraignee);

        }

        if(((((JButton)e.getSource()).getName()).equals("pluie"))){
            partie.getlistejoueur().get(partie.getJoueurCourant()).addFormule(Des.symbole.PLUIE);
            vue.setPanelSymbolFormule(vue.pluie);

        }
        if(((((JButton)e.getSource()).getName()).equals("etoile"))){
            partie.getlistejoueur().get(partie.getJoueurCourant()).addFormule(Des.symbole.ETOILE);
            vue.setPanelSymbolFormule(vue.etoile);

        }
        if(((((JButton)e.getSource()).getName()).equals("oeil"))){
            partie.getlistejoueur().get(partie.getJoueurCourant()).addFormule(Des.symbole.OEIL);
            vue.setPanelSymbolFormule(vue.oeil);

        }
        if(((((JButton)e.getSource()).getName()).equals("oreille"))){
            partie.getlistejoueur().get(partie.getJoueurCourant()).addFormule(Des.symbole.OREILLE);
            vue.setPanelSymbolFormule(vue.oreille);

        }
        if(((((JButton)e.getSource()).getName()).equals("tetedemort"))){
            partie.getlistejoueur().get(partie.getJoueurCourant()).addFormule(Des.symbole.TETEDEMORT);
            vue.setPanelSymbolFormule(vue.tetedemort);

        }
        if(((((JButton)e.getSource()).getName()).equals("choc"))){
            partie.getlistejoueur().get(partie.getJoueurCourant()).addFormule(Des.symbole.CHOC);
            vue.setPanelSymbolFormule(vue.choc);

        }
        if(((((JButton)e.getSource()).getName()).equals("soumettre"))){


        }




        }
}
