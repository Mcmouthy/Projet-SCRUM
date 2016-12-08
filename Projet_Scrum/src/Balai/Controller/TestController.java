package Balai.Controller;

import Balai.CarteMagieNoire;
import Balai.Joueur;
import Balai.Partie;
import Balai.SortieTableauException;
import Balai.Vue.TestVue;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Antonin on 24/11/2016.
 */
public class TestController implements ActionListener{
    private Partie partie;
    private TestVue vue;

    public TestController(TestVue vue, Partie partie){
        this.partie=partie;
        this.vue=vue;




    }


    public void actionPerformed(ActionEvent e) {
        if (partie.getlistejoueur().size()<6 && ((((JButton)e.getSource()).getText()).equals("Ajouter"))){ //si on clique sur ajouter
            partie.ajouterJoueur(new Joueur(vue.textField.getText()));
            vue.ajouteJoueur();
        }
        else if(((((JButton)e.getSource()).getText()).equals("Commencer"))){ //si on clique sur commencer
            vue.actualise();

        }

        if (((((JButton)e.getSource()).getText()).equals("Move"))) {
            System.out.println(partie.getlistejoueur().get(0).getPosition());
            try {
                partie.deplaceJoueur(partie.getlistejoueur().get(0), Integer.parseInt(vue.moveValue.getText()));
                int valeurMove = Integer.parseInt(vue.moveValue.getText());
                int positionActuelle=partie.getlistejoueur().get(0).getPosition();
                vue.position.setText("position = "+(positionActuelle+valeurMove));
                SwingUtilities.updateComponentTreeUI(vue.position);
                vue.actualise();
                System.out.println(partie.getlistejoueur().get(0).getPosition());
            } catch (SortieTableauException e1) {
                e1.printStackTrace();
                JFrame popupMoveInterdit = new JFrame();
                JTextPane alerte=new JTextPane();
                alerte.setText("Deplacement hors du tableau");
                popupMoveInterdit.getContentPane().add(alerte);
                popupMoveInterdit.getContentPane().add(new JButton("Annuler"));
                popupMoveInterdit.setVisible(true);
            }
        }

        if (((((JButton)e.getSource()).getText()).equals("Piocher une carte"))) {
            int nbCarteMain=partie.getlistejoueur().get(0).getMain().size();
            int nbCarteMainAcrobatie=partie.getlistejoueur().get(0).getMainAcrobatie().size();
            if (partie.getPioche().taille()!=0) {
                partie.piocher(partie.getlistejoueur().get(0));
                //vue.main.setText(vue.main.getText()+"\n"+libelleCartePiochee);
                if (nbCarteMain < partie.getlistejoueur().get(0).getMain().size()) {
                    CarteMagieNoire cartePiochee = partie.getlistejoueur().get(0).getMain().get(partie.getlistejoueur().get(0).getMain().size() - 1);
                    vue.main.add(vue.ajoutCarteMain(cartePiochee.toString()), BorderLayout.CENTER);
                } else if (nbCarteMainAcrobatie < partie.getlistejoueur().get(0).getMainAcrobatie().size()) {
                    CarteMagieNoire carteAcrobatiePiochee = partie.getlistejoueur().get(0).getMainAcrobatie().get(partie.getlistejoueur().get(0).getMainAcrobatie().size() - 1);
                    vue.mainAcrobatie.add(vue.ajoutCarteMain(carteAcrobatiePiochee.toString()), BorderLayout.CENTER);
                }
            }
            else {
                partie.getlistejoueur().get(0).calculerScoreAcrobatie();
                vue.bonus.setText(vue.bonus.getText()+partie.getlistejoueur().get(0).getPoints());
                SwingUtilities.updateComponentTreeUI(vue.bonus);
            }
            SwingUtilities.updateComponentTreeUI(vue.main);
            SwingUtilities.updateComponentTreeUI(vue.superPanneau);
        }






    }

}
