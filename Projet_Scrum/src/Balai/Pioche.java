package Balai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Sami on 22/11/2016.
 */
public class Pioche {
    List<CarteMagieNoire> cartes;
    Random rand = new Random();

    public Pioche()
    {
        cartes = new ArrayList<CarteMagieNoire>();
        init();
    }

    public void init() {
        cartes.clear();

        cartes.add(new Acrobatie(Type.TONNEAU));
        cartes.add(new Acrobatie(Type.TONNEAU));
        cartes.add(new Acrobatie(Type.TONNEAU));

        cartes.add(new Sortilege(Type.RECTIFICATION));
        cartes.add(new Sortilege(Type.RECTIFICATION));

        cartes.add(new Acrobatie(Type.VOLINVERSE));
        cartes.add(new Acrobatie(Type.VOLINVERSE));
        cartes.add(new Acrobatie(Type.VOLINVERSE));
        cartes.add(new Acrobatie(Type.VOLINVERSE));

        cartes.add(new Sortilege(Type.ATTRACTION));
        cartes.add(new Sortilege(Type.ATTRACTION));

        cartes.add(new Sortilege(Type.DOUBLEJEU));
        cartes.add(new Sortilege(Type.DOUBLEJEU));
        cartes.add(new Sortilege(Type.DOUBLEJEU));

        cartes.add(new Sortilege(Type.VENTARRIERE));
        cartes.add(new Sortilege(Type.VENTARRIERE));
        cartes.add(new Sortilege(Type.VENTARRIERE));

        cartes.add(new Sortilege(Type.OUTILREPARE));
        cartes.add(new Sortilege(Type.OUTILREPARE));

        cartes.add(new Sortilege(Type.DECRET));
        cartes.add(new Sortilege(Type.DECRET));

        cartes.add(new Sortilege(Type.BLOCAGE));

        cartes.add(new Sortilege(Type.MAUVAISSORT));

        cartes.add(new Sortilege(Type.BROUILLARDMAGIQUE));
        cartes.add(new Sortilege(Type.BROUILLARDMAGIQUE));

        cartes.add(new Acrobatie(Type.LOOPING));
        cartes.add(new Acrobatie(Type.LOOPING));

        Collections.shuffle(cartes);
    }

    public CarteMagieNoire piocherCarte() {
        int i = rand.nextInt(taille());
        return cartes.remove(i);
    }

    public int taille() {
        return cartes.size();
    }
}
