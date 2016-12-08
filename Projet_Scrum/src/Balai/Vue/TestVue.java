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
        public JLabel[] nomJoueurs={new JLabel(new ImageIcon("/home/malonesk/LocalGit/Projet-SCRUM/Projet_Scrum/src/Balai/Vue/Assets/lachaudasse.png")),new JLabel(),new JLabel(),new JLabel(),new JLabel(),new JLabel()};
        public JPanel[] casePlateau;
        public List<JLabel> liste;
       // public JPanel tabBord; //le tableau de bord depuis lequel le joueur peut se deplacer
        public JTextField moveValue; // la valeur de deplacement d'un joueur
        public JTextPane position; //affiche la position actuelle du joueur
        public JButton move;
        public JPanel main;
        public JPanel mainAcrobatie;
        public JButton piocher;
        public JLabel bonus;

    //JLabel contenant les images des cartes
    public JLabel attraction;
    public JLabel blocage;
    public JLabel brouillardmagique;
    public JLabel decret;
    public JLabel doublejeu;
    public JLabel lachaudasse;
    public JLabel looping;
    public JLabel mauvaissort;
    public JLabel oublirepare;
    public JLabel rectification;
    public JLabel tonneau;
    public JLabel ventarriere;
    public JLabel volinverse;



    public TestVue(Partie partie){
            this.partie=partie;
            controller=new TestController(this,partie);

            this.setTitle("Test Vue");

            this.setSize(800, 860);

            this.setLocationRelativeTo(null);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            superPanneau=buildContentPane();
            this.add(superPanneau);
            setController(controller);

            attraction=new JLabel(new ImageIcon("/home/malonesk/LocalGit/Projet-SCRUM/Projet_Scrum/src/Balai/Vue/Assets/attraction.png"));
            blocage=new JLabel(new ImageIcon("/home/malonesk/LocalGit/Projet-SCRUM/Projet_Scrum/src/Balai/Vue/Assets/blocage.png"));
            brouillardmagique=new JLabel(new ImageIcon("/home/malonesk/LocalGit/Projet-SCRUM/Projet_Scrum/src/Balai/Vue/Assets/brouillardmagiquepng"));
            decret=new JLabel(new ImageIcon("/home/malonesk/LocalGit/Projet-SCRUM/Projet_Scrum/src/Balai/Vue/Assets/decret.png"));
            doublejeu=new JLabel(new ImageIcon("/home/malonesk/LocalGit/Projet-SCRUM/Projet_Scrum/src/Balai/Vue/Assets/doublejeu.png"));
            lachaudasse=new JLabel(new ImageIcon("/home/malonesk/LocalGit/Projet-SCRUM/Projet_Scrum/src/Balai/Vue/Assets/lachaudasse.png"));
            looping=new JLabel(new ImageIcon("/home/malonesk/LocalGit/Projet-SCRUM/Projet_Scrum/src/Balai/Vue/Assets/looping.png"));
            mauvaissort=new JLabel(new ImageIcon("/home/malonesk/LocalGit/Projet-SCRUM/Projet_Scrum/src/Balai/Vue/Assets/mauvaissort.png"));
            oublirepare=new JLabel(new ImageIcon("/home/malonesk/LocalGit/Projet-SCRUM/Projet_Scrum/src/Balai/Vue/Assets/oublirepare.png"));
            rectification=new JLabel(new ImageIcon("/home/malonesk/LocalGit/Projet-SCRUM/Projet_Scrum/src/Balai/Vue/Assets/rectification.png"));
            tonneau=new JLabel(new ImageIcon("/home/malonesk/LocalGit/Projet-SCRUM/Projet_Scrum/src/Balai/Vue/Assets/tonneau.png"));
            ventarriere=new JLabel(new ImageIcon("/home/malonesk/LocalGit/Projet-SCRUM/Projet_Scrum/src/Balai/Vue/Assets/ventarriere.png"));
            volinverse=new JLabel(new ImageIcon("/home/malonesk/LocalGit/Projet-SCRUM/Projet_Scrum/src/Balai/Vue/Assets/volinverse.png"));

        this.setVisible(true);

        }

        private JPanel buildContentPane(){

            panelInferieur = new JPanel();
            panelInferieur.setLayout(new BoxLayout(panelInferieur,Y_AXIS));

            JLabel titre=new JLabel("Nom du joueur");

            button=new JButton("Ajouter");
            button.setSize(30,15);
            move=new JButton("Move");
            main=new JPanel();
            main.setSize(100,50);
            piocher=new JButton("Piocher une carte");
            bonus=new JLabel();
            commencer=new JButton("Commencer");
            JLabel imPlateau = new JLabel(new ImageIcon("/home/malonesk/LocalGit/Projet-SCRUM/Projet_Scrum/src/Balai/Vue/Assets/plateau.png"));
            imPlateau.setSize(200,150);
            JPanel intro = new JPanel();
            intro.setLayout(new BorderLayout());
            textField = new JTextField();
            panelInferieur.add(titre);
            panelInferieur.add(textField);
            intro.add(button, BorderLayout.NORTH);
            intro.add(imPlateau, BorderLayout.CENTER);
            intro.add(commencer, BorderLayout.SOUTH);
            //panelInferieur.add(textField);
            //panelInferieur.add(button);
            panelInferieur.add(intro);
            liste=new ArrayList<>();
            for (int i=0;i<6;i++){
                switch(i) {
                    case 0 :
                        nomJoueurs[i].setOpaque(true);
                        nomJoueurs[i].setBackground(Color.WHITE);
                        break;
                    case 1 :
                        nomJoueurs[i].setOpaque(true);
                        nomJoueurs[i].setBackground(Color.yellow);
                        break;
                    case 2 :
                        nomJoueurs[i].setOpaque(true);
                        nomJoueurs[i].setBackground(Color.cyan);
                        break;
                    case  3 :
                        nomJoueurs[i].setOpaque(true);
                        nomJoueurs[i].setBackground(Color.gray);
                        break;
                    case 4 :
                        nomJoueurs[i].setOpaque(true);
                        nomJoueurs[i].setBackground(Color.GREEN);
                        break;
                    case 5 :
                        nomJoueurs[i].setOpaque(true);
                        nomJoueurs[i].setBackground(Color.PINK);
                        break;
                }
                panelInferieur.add(nomJoueurs[i]);
            }

            //panelInferieur.add(commencer);


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
                        //lachaudasse.setPreferredSize(new Dimension(5, 15));
                        //casePlateau[i].add(lachaudasse);
                    }
                }
                casePlateau[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                plateau.add(casePlateau[i],SwingConstants.CENTER);
            }
            plateau.add(new JPanel().add(new JLabel("Arrivé"),SwingConstants.CENTER));
            plateau.setPreferredSize(new Dimension(800, 800));
            plateau.setBackground(Color.MAGENTA);
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
        public JPanel chargeTabMainSortilege() {
            JPanel tabCarte=new JPanel();
            JPanel panel=new JPanel();
            main=new JPanel();
            main.setBackground(Color.WHITE);
            main.setLayout(new GridLayout(10,1));
            tabCarte.setLayout(new BorderLayout());
            main.add(new JLabel("Main du joueur"));
            tabCarte.setLayout(new BorderLayout());
            tabCarte.add((piocher), BorderLayout.NORTH);
            tabCarte.add((main), BorderLayout.CENTER);
            //tabCarte.add((bonus), BorderLayout.SOUTH);
            panel.add(tabCarte);
            panel.setSize(500,220);
            return panel;
        }
        public JPanel chargeTabMainAcrobatie() {
            JPanel tabCarte=new JPanel();
            JPanel panel=new JPanel();
            mainAcrobatie=new JPanel();
            mainAcrobatie.setBackground(Color.WHITE);
            mainAcrobatie.setLayout(new GridLayout(10,1));
            tabCarte.setLayout(new BorderLayout());
            mainAcrobatie.add(new JLabel("Cartes acrobatie du joueur"));
            tabCarte.setLayout(new BorderLayout());
            tabCarte.add((new JLabel("Bonus du joueur")),BorderLayout.NORTH);
            tabCarte.add((mainAcrobatie), BorderLayout.CENTER);
            bonus.setText("Points bonus : ");
            tabCarte.add((bonus), BorderLayout.SOUTH);
            panel.add(tabCarte);
            panel.setSize(500,200);
            return panel;
        }
        public JLabel ajoutCarteMain(String carte) {
           /* switch (carte) {
                case "ATTRACTION" :
                    main.add(attraction);
                    break;
            }
            */


            JLabel label = new JLabel(carte);
            return label;
        }
        public void ajouteJoueur(){


            nomJoueurs[partie.getlistejoueur().size()-1].setText("Joueur "+partie.getlistejoueur().size()+" : "+partie.getlistejoueur().get(partie.getlistejoueur().size()-1).getNom());
            SwingUtilities.updateComponentTreeUI(this);
        }
        public void setController(ActionListener listener){
            button.addActionListener(listener);
            move.addActionListener(listener);
            commencer.addActionListener(listener);
            piocher.addActionListener(listener);
        }
        public void actualise() {
            superPanneau.removeAll();
            superPanneau.add(chargePlateau());
            superPanneau.add(chargeTableauBord());
            superPanneau.add(chargeTabMainSortilege());
            superPanneau.add(chargeTabMainAcrobatie());
            setContentPane(superPanneau);
            SwingUtilities.updateComponentTreeUI(this);
        }




        public static void main(String[] args){
            Partie partie=new Partie();
            TestVue vue=new TestVue(partie);




        }





}

