package Controller;

import Balai.Joueur;
import Balai.Partie;
import Vue.TestVue;

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
        partie.ajouterJoueur(new Joueur(vue.textField.getText()));

        System.out.println(partie.getlistejoueur().size());
        vue.actualise();

    }

}
