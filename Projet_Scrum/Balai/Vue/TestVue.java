package Vue;

import Balai.Partie;
import Controller.TestController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Antonin on 24/11/2016.
 */
public class TestVue extends JFrame{
        private Partie partie;
        private TestController controller;
        public JTextField textField;
        public JButton button;
        public JPanel panneau;

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
            setController(controller);


            this.setVisible(true);

        }
        private JPanel buildContentPane(){
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            JLabel titre=new JLabel("Nom du joueur");
            button=new JButton("Ajouter");

            textField = new JTextField();
            textField.setColumns(10);
            panel.add(titre);
            panel.add(textField);
            panel.add(button);
            liste=new ArrayList<>();



            return panel;
        }
        public void actualise(){


            panneau.add(new JLabel("Joueur "+partie.getlistejoueur().size()+" "+partie.getlistejoueur().get(partie.getlistejoueur().size()-1).getNom()));

            this.add(panneau);
            SwingUtilities.updateComponentTreeUI(this);
        }
        public void setController(ActionListener listener){
            button.addActionListener(listener);

        }




        public static void main(String[] args){
            Partie partie=new Partie();
            TestVue vue=new TestVue(partie);




        }





}

