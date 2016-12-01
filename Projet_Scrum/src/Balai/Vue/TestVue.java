package Balai.Vue;

import Balai.Controller.TestController;
import Balai.Partie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.BoxLayout.Y_AXIS;

/**
 * Created by Antonin on 24/11/2016.
 */
public class TestVue extends JFrame{
        private Partie partie;
        private TestController controller;
        public JTextField textField;
        public JButton button;
        public JPanel panneau;
        public JPanel panelInferieur;
        public JButton commencer;
        public JPanel plateau;
        public JLabel[] nomJoueurs={new JLabel("Joueur 1 :"),new JLabel("Joueur 2 :"),new JLabel("Joueur 3 :"),new JLabel("Joueur 4 :"),new JLabel("Joueur 5 :"),new JLabel("Joueur 6 :")};
        public JLabel[] casePlateau;
        public List<JLabel> liste;


        public TestVue(Partie partie){
            this.partie=partie;
            controller=new TestController(this,partie);

            this.setTitle("Test Vue");

            this.setSize(400, 500);

            this.setLocationRelativeTo(null);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            panneau=buildContentPane();
            this.add(panneau);
            //setController(controller);


            this.setVisible(true);

        }

        private JPanel buildContentPane(){

            panelInferieur = new JPanel();
            panelInferieur.setLayout(new BoxLayout(panelInferieur,Y_AXIS));

            JLabel titre=new JLabel("Nom du joueur");

            button=new JButton("Ajouter");
            button.setSize(30,15);

            textField = new JTextField();
            textField.setColumns(10);
            textField.setSize(10,2);
            panelInferieur.add(titre);
            panelInferieur.add(textField);
            panelInferieur.add(button);
            liste=new ArrayList<>();
            for (int i=0;i<6;i++){
                panelInferieur.add(nomJoueurs[i]);
            }
            commencer=new JButton("Commencer");
            panelInferieur.add(commencer);

            return panelInferieur;
        }
        public JPanel chargePlateau(){ //création de la grille du plateau, j'arrive pas à l'afficher...
            plateau=new JPanel();       //voir le controller pour des précisions
            casePlateau=new JLabel[24];
            plateau.setLayout(new GridLayout(6,4,2,2));
            for (int i=0;i<24;i++){
                casePlateau[i]=new JLabel(i-2+""); // on met les numéro dans les cases
                plateau.add(casePlateau[i]);
            }
            
            plateau.setBackground(Color.RED);
            return plateau;
        }
        public void actualise(){


            nomJoueurs[partie.getlistejoueur().size()-1].setText("Joueur "+partie.getlistejoueur().size()+" : "+partie.getlistejoueur().get(partie.getlistejoueur().size()-1).getNom());

            SwingUtilities.updateComponentTreeUI(this);
        }
        public void setController(ActionListener listener){
            button.addActionListener(listener);
            commencer.addActionListener(listener);
        }




        public static void main(String[] args){
            Partie partie=new Partie();
            TestVue vue=new TestVue(partie);




        }





}

