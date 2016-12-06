package Balai.Vue;

import Balai.Controller.TestController;
import Balai.Joueur;
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
       // public JPanel tabBord; //le tableau de bord depuis lequel le joueur peut se deplacer
        public JTextField moveValue; // la valeur de deplacement d'un joueur
        public JTextPane position; //affiche la position actuelle du joueur
        public JButton move;

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
            move=new JButton("Move");
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
       public JPanel chargePlateau(){
            plateau=new JPanel();
            casePlateau=new JPanel[25];
            plateau.setLayout(new GridLayout(6,4,2,2));
            for (int i=0;i<25;i++){
                casePlateau[i]=new JPanel();// on met les numéro dans les cases
                casePlateau[i].setLayout(new BoxLayout(casePlateau[i],Y_AXIS));
                casePlateau[i].add(new JLabel(i-2+""));
                for (int j=0;j<partie.getlistejoueur().size();j++){
                    if(partie.getlistejoueur().get(j).getPosition()==i-2){
                        casePlateau[i].add(new JLabel(partie.getlistejoueur().get(j).getNom()));

                    }
                }
                casePlateau[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                plateau.add(casePlateau[i],SwingConstants.CENTER);
            }
            plateau.add(new JPanel().add(new JLabel("Arrivé"),SwingConstants.CENTER));
            
            plateau.setBackground(Color.RED);
            return plateau;
        }

        public JPanel chargeTableauBord() {
            JPanel letabBord=new JPanel();
            JPanel panel=new JPanel();
            moveValue = new JTextField("Entrer la valeur de votre déplacement");
            letabBord.setLayout(new BorderLayout());
            letabBord.add((moveValue), BorderLayout.NORTH);
            letabBord.add((move), BorderLayout.CENTER);
            position = new JTextPane();
            position.setText("position = "+partie.getlistejoueur().get(0).getPosition());
            letabBord.add((position), BorderLayout.SOUTH);
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
            move.addActionListener(listener);
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
            Joueur j= new Joueur("DIEU");
            partie.ajouterJoueur(j);
            TestVue vue=new TestVue(partie);




        }





}

