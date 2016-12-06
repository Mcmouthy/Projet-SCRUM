package Balai.Controller;

import Balai.Joueur;
import Balai.Partie;
import Balai.SortieTableauException;
import Balai.Vue.TestVue;

import javax.swing.*;
import javax.swing.text.JTextComponent;
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


    }

}
