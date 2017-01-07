package Balai.Vue;

import Balai.Controller.Controller;
import Balai.Partie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by malonesk on 07/01/17.
 */
public class View extends JFrame {
    private Partie partie;
    private Controller controller;

    public JPanel plateau;
    public JPanel de1, de2, de3, de4, de5, de6, de7, de8, de9; // les symboles de 9 des
    public JPanel panelMainSort, panelMainAcro, panelSymboleDes, panelSymboleFormule; //panel conteneurs
    public JButton lancerDes, piocher, soumettreFormule; //boutons d'actions
    public JButton pluie, eclair, etoile, oeil, toile, oreille, tetedemort, arraignee, choc;//symbole du joueur pour formules
    public JLabel symboleCache;
    public JButton rectif, attraction, doublejeu, ventarriere, oublirep, decret, blocage, mauvaissort,brouillagem; //sorts
    public JButton tonneau, looping, volinv; //acrobaties
    public JPanel sorc_rouge, sorc_vert, sorc_bleu, sorc_gris, sorc_jaune, sorc_violette;

    public int width, height;
    public Insets insets;
    public final int[][] coordonnees={{103,565},{127,459},{228,257},{48,187},{172,150},{309,83},{344,151},{326,278},{453,215},{491,115},{582,102},{703,112},{704,228},{575,289},{400,322},{417,429},{535,351},{651,309},{724,346},{571,411},{692,435},{580,492},{512,514},{573,572},{696,587}};
    public View(Partie partie) {
        this.partie=partie;
        controller=new Controller(this,partie);
        this.setLayout(null);
        this.setTitle("Du Balai !");
        this.setSize(1280, 1080);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setController(controller);

        attraction= new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/attraction.png"));
        blocage=    new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/blocage.png"));
        brouillagem=new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/brouillardmagiquepng"));
        decret=     new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/decret.png"));
        doublejeu=  new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/doublejeu.png"));
        looping=    new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/looping.png"));
        mauvaissort=new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/mauvaissort.png"));
        oublirep=   new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/oublirepare.png"));
        rectif=     new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/rectification.png"));
        tonneau=    new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/tonneau.png"));
        ventarriere=new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/ventarriere.png"));
        volinv=     new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/volinverse.png"));

        sorc_rouge=new JPanel();
        sorc_rouge.add(new JLabel(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/lachaudasse.png")));
        sorc_vert=new JPanel();
        sorc_vert.add(new JLabel(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/sorciere_verte.png")));
        sorc_violette=new JPanel();
        sorc_violette.add(new JLabel(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/sorciere_violette.png")));
        sorc_jaune=new JPanel();
        sorc_jaune.add(new JLabel(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/sorciere_jaune.png")));
        sorc_bleu=new JPanel();
        sorc_bleu.add(new JLabel(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/sorciere_bleue.png")));
        sorc_gris=new JPanel();
        sorc_gris.add(new JLabel(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/sorcier_gris.png")));

        pluie=      new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/biiih_pluie.png"));
        eclair=     new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/boulga_eclair.png"));
        etoile=     new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/foulz_etoile.png"));
        oeil=       new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/glou_oeil.png"));
        toile=      new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/lashla_toile.png"));
        oreille=    new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/meuf_oreille.png"));
        tetedemort= new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/minh_tetedemort.png"));
        arraignee=  new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/sha_araignee.png"));
        choc=       new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/zaam_choc.png"));

        symboleCache = new JLabel(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/symbole_cache.png"));

        insets = this.getInsets();
        width=this.getWidth();
        height=this.getHeight();

        // Placement du plateau
        plateau = new JPanel();
        plateau.add(new JLabel(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/plateau.png")));
        plateau.setPreferredSize(new Dimension(760,604));
        Dimension sizePlateau = plateau.getPreferredSize();
        plateau.setBounds(insets.left, insets.top, sizePlateau.width,  sizePlateau.height);

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x=e.getX();
                int y=e.getY();
                System.out.println(x+","+y);//these co-ords are relative to the component
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.add(plateau);
        this.setVisible(true);
    }






    public void setController(Controller controller) {
        this.controller = controller;
    }
    public static void main(String args[]) {
        Partie p = new Partie();
        View v = new View(p);
    }
}
