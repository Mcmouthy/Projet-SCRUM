package Balai.Vue;

import Balai.*;
import Balai.Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by malonesk on 07/01/17.
 */
public class View extends JFrame {
    private Partie partie;
    private Controller controller;

    public JPanel plateau;
    public JPanel de1, de2, de3, de4, de5, de6, de7, de8, de9; // les symboles de 9 des
    public JPanel panelMainSort, panelMainAcro, panelSymboleDes, panelSymboleFormule, panelValidationFormule; //panel conteneurs
    public JButton lancerDes, piocher, soumettreFormule; //boutons d'actions
    public JButton pluie, eclair, etoile, oeil, toile, oreille, tetedemort, arraignee, choc;//symbole du joueur pour formules
    public JLabel symboleCache, formuleCourante;
    public JButton rectif, rectif2, attraction, attraction2, doublejeu, doublejeu2, doublejeu3, ventarriere, ventarriere2, ventarriere3, oublirep, oublirep2, decret, decret2, blocage, mauvaissort,brouillagem,brouillagem2; //sorts
    public JButton tonneau, tonneau2, tonneau3,  looping, looping2, volinv, volinv2, volinv3, volinv4; //acrobaties
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

        attraction=     new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/attraction.png"));
        attraction2=    new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/attraction.png"));
        blocage=        new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/blocage.png"));
        brouillagem=    new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/brouillardmagique.png"));
        brouillagem2=   new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/brouillardmagique.png"));
        decret=         new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/decret.png"));
        decret2=        new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/decret.png"));
        doublejeu=      new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/doublejeu.png"));
        doublejeu2=      new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/doublejeu.png"));
        doublejeu3=      new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/doublejeu.png"));
        looping=        new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/looping.png"));
        looping2=        new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/looping.png"));
        mauvaissort=    new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/mauvaissort.png"));
        oublirep=       new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/oublirepare.png"));
        oublirep2=       new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/oublirepare.png"));
        rectif=         new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/rectification.png"));
        rectif2=         new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/rectification.png"));
        tonneau=        new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/tonneau.png"));
        tonneau2=        new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/tonneau.png"));
        tonneau3=        new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/tonneau.png"));
        ventarriere=    new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/ventarriere.png"));
        ventarriere2=    new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/ventarriere.png"));
        ventarriere3=    new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/ventarriere.png"));
        volinv=         new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/volinverse.png"));
        volinv2=         new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/volinverse.png"));
        volinv3=         new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/volinverse.png"));
        volinv4=         new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/volinverse.png"));
        this.add(attraction);
        this.add(attraction2);
        this.add(blocage);
        this.add(brouillagem);
        this.add(brouillagem2);
        this.add(decret);
        this.add(decret2);
        this.add(doublejeu);
        this.add(doublejeu2);
        this.add(doublejeu3);
        this.add(looping);
        this.add(looping2);
        this.add(mauvaissort);
        this.add(oublirep);
        this.add(oublirep2);
        this.add(rectif);
        this.add(rectif2);
        this.add(tonneau);
        this.add(tonneau2);
        this.add(tonneau3);
        this.add(ventarriere);
        this.add(ventarriere2);
        this.add(ventarriere3);
        this.add(volinv);
        this.add(volinv2);
        this.add(volinv3);
        this.add(volinv4);


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
        pluie.setPreferredSize(new Dimension(86,127));
        eclair=     new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/boulga_eclair.png"));
        eclair.setPreferredSize(new Dimension(86,127));
        etoile=     new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/foulz_etoile.png"));
        etoile.setPreferredSize(new Dimension(86,127));
        oeil=       new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/glou_oeil.png"));
        oeil.setPreferredSize(new Dimension(86,127));
        toile=      new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/lashla_toile.png"));
        toile.setPreferredSize(new Dimension(86,127));
        oreille=    new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/meuf_oreille.png"));
        oreille.setPreferredSize(new Dimension(86,127));
        tetedemort= new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/minh_tetedemort.png"));
        tetedemort.setPreferredSize(new Dimension(86,127));
        arraignee=  new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/sha_araignee.png"));
        arraignee.setPreferredSize(new Dimension(86,127));
        choc=       new JButton(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/zaam_choc.png"));
        choc.setPreferredSize(new Dimension(86,127));
        symboleCache = new JLabel(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/symbole_cache.png"));

        this.add(pluie);
        this.add(eclair);
        this.add(etoile);
        this.add(oeil);
        this.add(toile);
        this.add(oreille);
        this.add(tetedemort);
        this.add(arraignee);
        this.add(choc);
        this.add(symboleCache);

        formuleCourante=new JLabel(); // DANS CONTROLER : update formuleCourante en fonction des boutons symboles joueurs sur lesquels le joueur a cliqué
        this.add(formuleCourante);

        insets = this.getInsets();
        width=this.getWidth();
        height=this.getHeight();

        // Placement du plateau
        plateau = new JPanel();
        plateau.add(new JLabel(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/plateau.png")));
        plateau.setPreferredSize(new Dimension(760,604));
        Dimension sizePlateau = plateau.getPreferredSize();
        plateau.setBounds(insets.left, insets.top, sizePlateau.width,  sizePlateau.height);
        this.add(plateau);


        //Placement et initilisation du panel symbole des dés (init avec symbole caches)
        panelSymboleDes = new JPanel();
        panelSymboleDes.setBackground(Color.WHITE);
        panelSymboleDes.setLayout(new BoxLayout(panelSymboleDes,BoxLayout.X_AXIS));
        panelSymboleDes.add(new JLabel("LES DES "));
        panelSymboleDes.add(new JLabel(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/symbole_cache.png")));
        panelSymboleDes.add(new JLabel(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/symbole_cache.png")));
        panelSymboleDes.add(new JLabel(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/symbole_cache.png")));
        panelSymboleDes.add(new JLabel(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/symbole_cache.png")));
        panelSymboleDes.add(new JLabel(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/symbole_cache.png")));
        panelSymboleDes.add(new JLabel(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/symbole_cache.png")));
        panelSymboleDes.add(new JLabel(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/symbole_cache.png")));
        panelSymboleDes.add(new JLabel(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/symbole_cache.png")));
        panelSymboleDes.add(new JLabel(new ImageIcon("Projet_Scrum/src/Balai/Vue/Assets/symbole_cache.png")));
        panelSymboleDes.setPreferredSize(new Dimension(760,50));
        Dimension sizePanSymbDes = panelSymboleDes.getPreferredSize();
        panelSymboleDes.setBounds(insets.left, sizePlateau.height, sizePlateau.width-200,sizePanSymbDes.height);
        this.getContentPane().add(symboleCache);
        this.getContentPane().add(panelSymboleDes);

        //Placement du bouton lancer les dés
        lancerDes = new JButton("Lancer dés");
        lancerDes.setPreferredSize(new Dimension(200,50));
        lancerDes.setBounds(insets.left+sizePlateau.width-200, insets.top+sizePlateau.height, 200, 50);
        this.add(lancerDes);

        //Placement du panel symbole formule joueur
        panelSymboleFormule = new JPanel();
        panelSymboleFormule.setLayout(new BoxLayout(panelSymboleFormule, BoxLayout.X_AXIS));
        panelSymboleFormule.add(pluie);
        panelSymboleFormule.add(eclair);
        panelSymboleFormule.add(etoile);
        panelSymboleFormule.add(oeil);
        panelSymboleFormule.add(toile);
        panelSymboleFormule.add(oreille);
        panelSymboleFormule.add(tetedemort);
        panelSymboleFormule.add(arraignee);
        panelSymboleFormule.add(choc);
        panelSymboleFormule.setPreferredSize(new Dimension(this.width-200,130));
        Dimension panSymbFormSize = panelSymboleFormule.getPreferredSize();
        panelSymboleFormule.setBounds(insets.left,insets.top+sizePlateau.height+sizePanSymbDes.height,this.width-200,panSymbFormSize.height);

        this.add(panelSymboleFormule);

        //Placement du bouton action Soumettre Formule
        soumettreFormule=new JButton("Soumettre formule");
        soumettreFormule.setPreferredSize(new Dimension(200,130));
        Dimension sizeButFormule = soumettreFormule.getPreferredSize();
        soumettreFormule.setBounds(insets.left+panSymbFormSize.width, insets.top+sizePlateau.height+sizePanSymbDes.height, sizeButFormule.width, sizeButFormule.height);
        this.add(soumettreFormule);

        //Placement du panel de rappel de formule avant validation (bouton soumettre)
        panelValidationFormule=new JPanel();
        panelValidationFormule.setLayout(new BoxLayout(panelValidationFormule, BoxLayout.X_AXIS));
        panelValidationFormule.setBackground(Color.green);
        panelValidationFormule.add(new JLabel("Ma formule : "));
        panelValidationFormule.add(formuleCourante);
        panelValidationFormule.setPreferredSize(new Dimension(sizeButFormule.width, 50));
        Dimension sizePanValidForm = panelValidationFormule.getPreferredSize();
        panelValidationFormule.setBounds(insets.left, insets.top+sizePlateau.height+sizePanSymbDes.height+sizeButFormule.height, this.width, sizePanValidForm.height);

        this.add(panelValidationFormule);

        //Placement du panel main Sortileges
        panelMainSort = new JPanel();
        panelMainSort.setPreferredSize(new Dimension(this.width-sizePlateau.width, sizePlateau.height));
        panelMainSort.setLayout(new GridLayout(6,2));
        panelMainSort.setBackground(Color.WHITE);

        //panelMainSort.add(blocage);
        //panelMainSort.add(decret);
        //panelMainSort.add(decret2);
        /*
        panelMainSort.add(doublejeu);
        panelMainSort.add(mauvaissort);
        panelMainSort.add(oublirep);
        panelMainSort.add(rectif);
        panelMainSort.add(ventarriere);
        panelMainSort.add(tonneau);
        panelMainSort.add(looping);
        panelMainSort.add(volinv);
        */
            // titre du panel
            JPanel titreMainSort = new JPanel();
            titreMainSort.setBackground(Color.WHITE);
            titreMainSort.add(new JLabel("Votre main de carte sortilège"));
            titreMainSort.setPreferredSize(new Dimension(this.width-sizePlateau.width, 40));
            titreMainSort.setBounds(insets.left+sizePlateau.width, insets.top, panelMainSort.getPreferredSize().width, 40);
            this.add(titreMainSort);
        panelMainSort.setBounds(insets.left+sizePlateau.width, insets.top+40, panelMainSort.getPreferredSize().width, panelMainSort.getPreferredSize().height);
        this.add(panelMainSort);

        //Placement du panel main Acrobatie
        panelMainAcro = new JPanel();
        panelMainAcro.setPreferredSize(new Dimension(this.width-200, this.height-(sizeButFormule.height+sizePanSymbDes.height+sizePlateau.height+sizePanValidForm.height+panSymbFormSize.height)));
        Dimension sizePanelMainAcro = panelMainAcro.getPreferredSize();
        panelMainAcro.setLayout(new BoxLayout(panelMainAcro,BoxLayout.X_AXIS));
        panelMainAcro.add(new JLabel("VOS CARTES BONUS "));

        //add


        panelMainAcro.setBounds(insets.left, insets.top+sizeButFormule.height+sizePanSymbDes.height+sizePlateau.height+sizePanValidForm.height, sizePanelMainAcro.width-200, sizePanelMainAcro.height );
        this.add(panelMainAcro);

        //Placement du bouton Piocher
        piocher = new JButton("Piocher une carte");
        piocher.setPreferredSize(new Dimension(200,sizePanelMainAcro.height));
        piocher.setBounds(insets.left+sizePanelMainAcro.width, insets.top+sizeButFormule.height+sizePanSymbDes.height+sizePlateau.height+sizePanValidForm.height, 200, sizePanelMainAcro.height);
        this.add(piocher);




        /*


        TEST : A SUPPRIMER QUAND LE CONTROLLER SERA FAIT


         */
        /*
        addCarteToPanel(new Acrobatie(Balai.Type.TONNEAU));
        addCarteToPanel(new Sortilege(Balai.Type.ATTRACTION));
        addCarteToPanel(new Sortilege(Balai.Type.VOLINVERSE));
        addCarteToPanel(new Sortilege(Balai.Type.ATTRACTION));
        */



        this.setVisible(true);
    }



    public void setController(Controller controller) {
        this.controller = controller;
    }
    public void addCarteToPanel(CarteMagieNoire carte) { //appelée quand clic sur boutton Piocher
        String nomCarte = carte.toString();

        switch (nomCarte) {
            case "TONNEAU" :
                addMainAcroFactory("tonneau");
                break;
            case "RECTIFICATION" :
                addMainSortFactory("rectif");
                break;
            case "VOLINVERSE" :
                addMainAcroFactory("volinv");
                break;
            case "ATTRACTION" :
                addMainSortFactory("attraction");
                break;
            case "DOUBLEJEU" :
                addMainSortFactory("doublejeu");
                break;
            case "OUTILREPARE" :
                addMainSortFactory("oublirep");
                break;
            case "DECRET" :
                addMainSortFactory("decret");
                break;
            case "BLOCAGE" :
                addMainSortFactory("blocage");
                break;
            case "MAUVAISSORT" :
                addMainSortFactory("mauvaissort");
                break;
            case "BROUILLARDMAGIQUE" :
                addMainSortFactory("brouillagem");
                break;
            case "LOOPING" :
                addMainAcroFactory("looping");
                break;
        }

    }
    public void addMainSortFactory(String nomCarte) {
        int nbCartes=0;
        for (Component jb : this.panelMainSort.getComponents()) {
                if (jb instanceof JButton) {
                    if (((JButton) jb).getName() != null && ((JButton) jb).getName().equals(nomCarte)) {
                        nbCartes = 1;
                    }
                    if (jb.getName() != null && jb.getName().equals(nomCarte + "2")) {
                        nbCartes = 2;
                    }
                }
        }
        System.out.println();
        switch (nbCartes) {
            case 0 :
                panelMainSort.add(getButtonByName(nomCarte));
                break;
            case 1 :
                panelMainSort.add(getButtonByName(nomCarte+'2'));
                break;
            case 2 :
                panelMainSort.add(getButtonByName(nomCarte+'3'));
                break;
        }

        this.add(panelMainSort);
        SwingUtilities.updateComponentTreeUI(this);
    }
    public void addMainAcroFactory(String nomCarte) {
        int nbCartes=0;
        for (Component jb : this.panelMainAcro.getComponents()) {
            if (jb instanceof JButton) {
                if (((JButton) jb).getName() != null && ((JButton) jb).getName().equals(nomCarte)) {
                    nbCartes = 1;
                }
                if (jb.getName() != null && jb.getName().equals(nomCarte + "2")) {
                    nbCartes = 2;
                }
                if (jb.getName() != null && jb.getName().equals(nomCarte + "3")) {
                    nbCartes = 3;
                }
            }
        }
        System.out.println();
        switch (nbCartes) {
            case 0 :
                panelMainAcro.add(getButtonByName(nomCarte));
                break;
            case 1 :
                panelMainAcro.add(getButtonByName(nomCarte+'2'));
                break;
            case 2 :
                panelMainAcro.add(getButtonByName(nomCarte+'3'));
                break;
            case 3 :
                panelMainAcro.add(getButtonByName(nomCarte+'4'));
                break;
        }

        this.add(panelMainAcro);

        SwingUtilities.updateComponentTreeUI(this);
    }
    public JButton getButtonByName(String name) {
        switch (name) {
            case "attraction" :
                attraction.setName("attraction");
                return attraction;
            case "attraction2" :
                attraction2.setName("attraction2");
                return attraction2;
            case "blocage" :
                blocage.setName("blocage");
                return blocage;
            case "brouillagem" :
                brouillagem.setName("brouillagem");
                return brouillagem;
            case "brouillagem2" :
                brouillagem2.setName("brouillagem2");
                return brouillagem2;
            case "decret" :
                decret.setName("decret");
                return decret;
            case "decret2" :
                decret2.setName("decret2");
                return decret2;
            case "doublejeu" :
                doublejeu.setName("doublejeu");
                return doublejeu;
            case "doublejeu2" :
                doublejeu2.setName("doublejeu2");
                return doublejeu2;
            case "doublejeu3" :
                doublejeu3.setName("doublejeu3");
                return doublejeu3;
            case "looping" :
                looping.setName("looping");
                return looping;
            case "looping2" :
                looping2.setName("looping2");
                return looping2;
            case "mauvaissort" :
                mauvaissort.setName("mauvaissort");
                return mauvaissort;
            case "oublirep" :
                oublirep.setName("oublirep");
                return oublirep;
            case "oublirep2" :
                oublirep2.setName("oublirep2");
                return oublirep2;
            case "rectif" :
                rectif.setName("rectif");
                return rectif;
            case "rectif2" :
                rectif2.setName("rectif2");
                return rectif2;
            case "tonneau" :
                tonneau.setName("tonneau");
                return tonneau;
            case "tonneau2" :
                tonneau2.setName("tonneau2");
                return tonneau2;
            case "tonneau3" :
                tonneau3.setName("tonneau3");
                return tonneau3;
            case "ventarriere" :
                ventarriere.setName("ventarriere");
                return ventarriere;
            case "ventarriere2" :
                ventarriere2.setName("ventarriere2");
                return ventarriere2;
            case "ventarriere3" :
                ventarriere3.setName("ventarriere3");
                return ventarriere3;
            case "volinv" :
                volinv.setName("volinv");
                return volinv;
            case "volinv2" :
                volinv2.setName("volinv2");
                return volinv2;
            case "volinv3" :
                volinv3.setName("volinv3");
                return volinv3;
            case "volinv4" :
                volinv4.setName("volinv4");
                return volinv4;
        }
        System.out.print("GetButtonByName - View");
        return null;
    }

    public void setMainSortPanel(List<Sortilege> lc) { //appelée quand changement de tour (prend en param main sortilege du joueur du tour
        for (CarteMagieNoire c : lc) {
            addCarteToPanel(c);
        }
    }
    public void setMainAcrobatiePanel(List<Acrobatie> lc) { //appelée quand changement de tour (prend en param main acrobatie du joueur du tour
        for (CarteMagieNoire c : lc) {
            addCarteToPanel(c);
        }
    }





    public void setActionListener(ActionListener l){
        attraction.addActionListener(l);
        attraction2.addActionListener(l);

        blocage.addActionListener(l);
        brouillagem.addActionListener(l);
        brouillagem2.addActionListener(l);
        decret.addActionListener(l);
        decret2.addActionListener(l);
        doublejeu.addActionListener(l);
        doublejeu2.addActionListener(l);
        doublejeu3.addActionListener(l);

        mauvaissort.addActionListener(l);
        oublirep.addActionListener(l);
        oublirep2.addActionListener(l);

        rectif.addActionListener(l);
        rectif2.addActionListener(l);

        ventarriere.addActionListener(l);
        ventarriere2.addActionListener(l);
        ventarriere3.addActionListener(l);
        piocher.setName("pioche");
        piocher.addActionListener(l);

    }
    public static void main(String args[]) {
        Partie p = new Partie();
        Joueur j = new Joueur();

        p.ajouterJoueur(j);
        View v = new View(p);
        v.setActionListener(v.controller);
        v.setMainSortPanel(j.getMain());
        v.setMainAcrobatiePanel(j.getMainAcrobatie());

    }
}
