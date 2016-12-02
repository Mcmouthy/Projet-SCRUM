package Balai;

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

}
