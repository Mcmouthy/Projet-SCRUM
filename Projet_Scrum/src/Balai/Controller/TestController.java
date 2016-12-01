package Balai.Controller;

import Balai.Joueur;
import Balai.Partie;
import Balai.Vue.TestVue;

import javax.swing.*;
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
            vue.actualise();
        }
        else if(((((JButton)e.getSource()).getText()).equals("Commencer"))){ //si on clique sur commencer
            vue.panneau=vue.chargePlateau();
            vue.add(vue.panneau);


        }


    }

}
