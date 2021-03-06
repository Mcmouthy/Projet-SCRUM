package Balai;

import Balai.Exceptions.PiocheVideException;

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

        cartes.add(CarteMagieNoire.carteFactory(Type.TONNEAU));
        cartes.add(CarteMagieNoire.carteFactory(Type.TONNEAU));
        cartes.add(CarteMagieNoire.carteFactory(Type.TONNEAU));

        cartes.add(CarteMagieNoire.carteFactory(Type.RECTIFICATION));
        cartes.add(CarteMagieNoire.carteFactory(Type.RECTIFICATION));

        cartes.add(CarteMagieNoire.carteFactory(Type.VOLINVERSE));
        cartes.add(CarteMagieNoire.carteFactory(Type.VOLINVERSE));
        cartes.add(CarteMagieNoire.carteFactory(Type.VOLINVERSE));
        cartes.add(CarteMagieNoire.carteFactory(Type.VOLINVERSE));

        cartes.add(CarteMagieNoire.carteFactory(Type.ATTRACTION));
        cartes.add(CarteMagieNoire.carteFactory(Type.ATTRACTION));

        cartes.add(CarteMagieNoire.carteFactory(Type.DOUBLEJEU));
        cartes.add(CarteMagieNoire.carteFactory(Type.DOUBLEJEU));
        cartes.add(CarteMagieNoire.carteFactory(Type.DOUBLEJEU));

        cartes.add(CarteMagieNoire.carteFactory(Type.VENTARRIERE));
        cartes.add(CarteMagieNoire.carteFactory(Type.VENTARRIERE));
        cartes.add(CarteMagieNoire.carteFactory(Type.VENTARRIERE));

        cartes.add(CarteMagieNoire.carteFactory(Type.OUTILREPARE));
        cartes.add(CarteMagieNoire.carteFactory(Type.OUTILREPARE));

        cartes.add(CarteMagieNoire.carteFactory(Type.DECRET));
        cartes.add(CarteMagieNoire.carteFactory(Type.DECRET));

        cartes.add(CarteMagieNoire.carteFactory(Type.BLOCAGE));

        cartes.add(CarteMagieNoire.carteFactory(Type.MAUVAISSORT));

        cartes.add(CarteMagieNoire.carteFactory(Type.BROUILLARDMAGIQUE));
        cartes.add(CarteMagieNoire.carteFactory(Type.BROUILLARDMAGIQUE));

        cartes.add(CarteMagieNoire.carteFactory(Type.LOOPING));
        cartes.add(CarteMagieNoire.carteFactory(Type.LOOPING));

        this.melanger();

    }
    public void melanger(){

        ArrayList<CarteMagieNoire> nouvelle = new ArrayList<>(this.cartes);
        Collections.shuffle(nouvelle);
        this.cartes.clear();
        this.cartes=nouvelle;
    }

    public CarteMagieNoire piocherCarte() throws PiocheVideException {
        if (cartes.size() > 0)
            return (cartes.remove(cartes.size() - 1));
        else throw new PiocheVideException();
    }

    public int taille() {
        return cartes.size();
    }
}
