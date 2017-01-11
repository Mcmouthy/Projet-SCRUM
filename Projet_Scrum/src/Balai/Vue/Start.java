package Balai.Vue;

import Balai.Controller.Controller;
import Balai.Joueur;
import Balai.Partie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by malonesk on 09/01/17.
 */
public class Start extends JFrame {
    public ArrayList<String> listJoueurs;
    public JButton ajouter;
    public JButton commencer;
    public JTextField[] nomJoueurs;;
    public JPanel panAjout, panShow, panNomJoueur;
    public JLabel titre, instruc1, instruc2;
    public JLabel[] sorcieres;
    public Insets ins;
    public Controller c;
    public Partie partie;
    public View vue;
    public String[] couleurSorc;
    public Start() {
        partie=new Partie();
        couleurSorc=new String[]{"rouge", "grise", "bleue", "jaune", "verte", "violette"};
        init();
        c= new Controller(this, partie);
        setActionListener(c);

    }

    private void init() {
        this.setLayout(null);
        this.setTitle("Du Balai !");
        this.setSize(600,1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ins=this.getInsets();
        listJoueurs=new ArrayList<>();
        ajouter=new JButton("Ajouter");
        ajouter.setName("add");
        this.add(ajouter);
        commencer = new JButton("Start");
        commencer.setName("st");
        nomJoueurs = new JTextField[6];
        for (int i=0;i<6;i++) {
            nomJoueurs[i]=new JTextField();
            nomJoueurs[i].setPreferredSize(new Dimension(250, 30));
            this.add(nomJoueurs[i]);
        }
        panAjout= new JPanel();
        panShow= new JPanel();
        panNomJoueur = new JPanel();
        sorcieres=new JLabel[6];
        for (int i=1;i<7;i++) {
            sorcieres[i-1]= new JLabel("Sorcière "+i+" "+"("+couleurSorc[i-1]+")");
        }
        titre = new JLabel("LE JEU DU BALAI !");
        instruc1 = new JLabel("Entrer les noms des joueurs");
        instruc2 = new JLabel("Les sorcières ont enfourché leur balai !");
        this.add(instruc2);
        setOnJframe();
        this.setVisible(true);
    }



    public void setOnJframe() {
        panAjout.setLayout(new BoxLayout(panAjout, BoxLayout.Y_AXIS));
        JPanel jp = new JPanel();
        jp.setPreferredSize(new Dimension(400, 200));
        Dimension sizejp = jp.getPreferredSize();
        jp.setLayout(new GridLayout(8,2));
        JPanel tit= new JPanel();
        tit.setBackground(Color.WHITE);
        tit.add("Center",titre);
        panAjout.add(tit);
        jp.add("Center", instruc1);
        jp.add(new JLabel("... des soricères !"));
        for (int i=0;i<6;i++) {
            this.add(sorcieres[i]);
            jp.add(sorcieres[i]);
            jp.add(nomJoueurs[i]);

        }
        jp.add("Center",ajouter);
        jp.setBounds(ins.left+100, ins.top+200, sizejp.width, sizejp.height);
        this.add(jp);
        //panAjout.add("Center",jp);

        panAjout.setBackground(Color.WHITE);
        panAjout.setPreferredSize(new Dimension(500, 600));
        Dimension size = panAjout.getPreferredSize();
        panAjout.setBounds(ins.left+50, ins.top+50, size.width, size.height);
        this.add(panAjout);

    }
    public void setNomJoueurOnPanel(String[] nomJoueurs) { //apellée par le constructeur
        panNomJoueur.setLayout(new BoxLayout(panNomJoueur, BoxLayout.Y_AXIS));
        panNomJoueur.add(instruc2);
        for (int i=0;i<nomJoueurs.length;i++) {
            JPanel jp = new JPanel();
            jp.add("Center",new JLabel(nomJoueurs[i]));
            jp.setBackground(Color.WHITE);
            panNomJoueur.add(jp);
        }
        commencer.setPreferredSize(new Dimension(100,50));
        Dimension sizeb = commencer.getPreferredSize();
        commencer.setBounds(ins.left+250,ins.top+675, sizeb.width, sizeb.height);
        panNomJoueur.setPreferredSize(new Dimension(500, 170));
        Dimension size = panNomJoueur.getPreferredSize();
        panNomJoueur.setBounds(ins.left+50, ins.top+750, size.width, size.height);
        panNomJoueur.setBackground(Color.WHITE);
        this.add(panNomJoueur);
        this.add(commencer);
        SwingUtilities.updateComponentTreeUI(this);
    }


    public void setActionListener(ActionListener l) {
        ajouter.addActionListener(l);
        commencer.addActionListener(l);
    }
}
