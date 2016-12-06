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
    public JPanel superPanneau;
        public JPanel panneau;
        public JPanel panelInferieur;
        public JButton commencer;
        public JPanel plateau;
        public JLabel[] nomJoueurs={new JLabel("Joueur 1 :"),new JLabel("Joueur 2 :"),new JLabel("Joueur 3 :"),new JLabel("Joueur 4 :"),new JLabel("Joueur 5 :"),new JLabel("Joueur 6 :")};
        public JLabel[] casePlateau;
        public List<JLabel> liste;
        public JPanel tabBord; //le tableau de bord depuis lequel le joueur peut se deplacer


        public TestVue(Partie partie){
            this.partie=partie;
            controller=new TestController(this,partie);

            this.setTitle("Test Vue");

            this.setSize(400, 500);

            this.setLocationRelativeTo(null);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            superPanneau=buildContentPane();
            this.add(superPanneau);
            setController(controller);


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

        public JPanel chargeTableauBord() {
            JPanel letabBord=new JPanel();
            JPanel panel=new JPanel();
            JButton dep = new JButton("Move");
            JTextField valeurDep = new JTextField("Entrer la valeur de votre déplacement");
            letabBord.setLayout(new BorderLayout());
            letabBord.add((valeurDep), BorderLayout.NORTH);
            letabBord.add((dep), BorderLayout.CENTER);
            panel.setSize(20, 5);
            panel.add(letabBord);
            return panel;
        }
        public void ajouteJoueur(){


            nomJoueurs[partie.getlistejoueur().size()-1].setText("Joueur "+partie.getlistejoueur().size()+" : "+partie.getlistejoueur().get(partie.getlistejoueur().size()-1).getNom());
            SwingUtilities.updateComponentTreeUI(this);
        }
        public void setController(ActionListener listener){
            button.addActionListener(listener);
            commencer.addActionListener(listener);
        }
        public void actualise() {
            superPanneau.removeAll();
            superPanneau.add(chargePlateau());
            superPanneau.add(chargeTableauBord());
            setContentPane(superPanneau);
            SwingUtilities.updateComponentTreeUI(this);
        }




        public static void main(String[] args){
            Partie partie=new Partie();
            TestVue vue=new TestVue(partie);




        }





}

