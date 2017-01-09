package Balai;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Balai.Des.symbole.*;

/**
 * Created by ddelacot on 02/12/2016.
 */
public class Des {
    public enum symbole{ // enum avec les symboles differents sur chaque dé
        ARAIGNEE,
        CHOC,
        OEIL,
        ECLAIR,
        PLUIE,
        TOILE,
        ETOILE,
        TETEDEMORT,
        OREILLE,
        ORANGE,
        NOIR
    }

    public static symbole[][] de1={{ARAIGNEE,CHOC,OEIL,ECLAIR,PLUIE,TOILE},{ORANGE,ORANGE,ORANGE,NOIR,NOIR,NOIR}};
    public static symbole[][] de2={{ARAIGNEE,ETOILE,TETEDEMORT,OEIL,PLUIE,CHOC},{ORANGE,ORANGE,ORANGE,NOIR,NOIR,NOIR}};
    public static symbole[][] de3={{PLUIE,ECLAIR,OEIL,TOILE,OREILLE,ETOILE},{ORANGE,ORANGE,ORANGE,NOIR,NOIR,NOIR}};
    public static symbole[][] de4={{PLUIE,OEIL,CHOC,TOILE,ECLAIR,OREILLE},{ORANGE,ORANGE,ORANGE,NOIR,NOIR,NOIR}};
    public static symbole[][] de5={{TOILE,OREILLE,ETOILE,TETEDEMORT,ARAIGNEE,CHOC},{ORANGE,ORANGE,ORANGE,NOIR,NOIR,NOIR}};
    public static symbole[][] de6={{TOILE,PLUIE,ECLAIR,OREILLE,ETOILE,TETEDEMORT},{ORANGE,ORANGE,ORANGE,NOIR,NOIR,NOIR}};
    public static symbole[][] de7={{CHOC,TETEDEMORT,ARAIGNEE,OEIL,PLUIE,ECLAIR},{ORANGE,ORANGE,ORANGE,NOIR,NOIR,NOIR}};
    public static symbole[][] de8={{TETEDEMORT,ETOILE,OREILLE,ARAIGNEE,CHOC,OEIL},{ORANGE,ORANGE,ORANGE,NOIR,NOIR,NOIR}};
    public static symbole[][] de9={{TOILE,OREILLE,ECLAIR,TETEDEMORT,ARAIGNEE,ETOILE},{ORANGE,ORANGE,ORANGE,NOIR,NOIR,NOIR}};
    public static List<symbole[][]> listeDes = new ArrayList<symbole[][]>();
    public static void setListeDes(){
        listeDes.clear();
        listeDes.add(de1);
        listeDes.add(de2);
        listeDes.add(de3);
        listeDes.add(de4);
        listeDes.add(de5);
        listeDes.add(de6);
        listeDes.add(de7);
        listeDes.add(de8);
        listeDes.add(de9);
    }
    public static symbole[] lanceDes() {
        symbole[] des = new symbole[18];
        int i=0;
        setListeDes();
        for (symbole[][] de : listeDes) {
            int rand = (int)Math.round(Math.random()*5);
            des[i]=de[0][rand];
            des[i+1]=de[1][rand];
            i+=2;
        }
        return des;
    }
    public static List<symbole> getSymbolesSansCouleur() { // a test
        symbole[] tab = symbole.values();
        List<symbole> ls = new ArrayList<>();
        for (int i=0; i<tab.length;i++) {
            ls.add(tab[i]);
        }
        ls.remove(symbole.ORANGE);
        ls.remove(symbole.NOIR);
        return ls;
    }

}
