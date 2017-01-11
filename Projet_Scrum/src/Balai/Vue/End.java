package Balai.Vue;

import Balai.Joueur;
import Balai.Partie;

import javax.swing.*;
import java.awt.*;

/**
 * Created by malonesk on 10/01/17.
 */
public class End extends JFrame{
    public Partie partie;
    public JPanel panScore;
    public JLabel[] scores;
    public Insets ins;

    public End(Partie p) {
        partie=p;
        panScore = new JPanel();
        panScore.setLayout(new BoxLayout(panScore, BoxLayout.Y_AXIS));
        scores = new JLabel[6];
        ins = this.getInsets();
        init();


    }
    public void init() {
        this.setLayout(null);
        this.setTitle("La partie est finie !");
        this.setSize(200,200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (int i=0;i<partie.getlistejoueur().size();i++) {
            partie.getlistejoueur().get(i).calculerScoreAcrobatie();
            scores[i]=new JLabel(partie.getlistejoueur().get(i).getNom()+" "+partie.getlistejoueur().get(i).getPoints());
            this.add(scores[i]);
            panScore.add(scores[i]);
        }
        panScore.setBounds(ins.left, ins.top, 200,200);
        this.add(panScore);
        this.setVisible(true);

    }
}
