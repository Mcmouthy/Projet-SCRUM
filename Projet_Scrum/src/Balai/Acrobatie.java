package Balai;

/**
 * Created by Sami on 22/11/2016.
 */
public class Acrobatie extends CarteMagieNoire {

    private int value;
    @Deprecated
     /* Plutôt utiliser la méthode statique CarteMagieNoire.carteFactory(Type type)
     * */
    protected Acrobatie(Type type)  {
        super(type);
        switch (type) {
            case TONNEAU:
                value = 2;
                break;
            case VOLINVERSE:
                value = 1;
                break;
            case LOOPING:
                value = 3;
                break;
        }
    }

    public Type getType()
    {
        return type;
    }

    public int getValue() {
        return value;
    }
    public boolean isAcrobatie() {return true;}
    public boolean isSortilege() {return false;}
}
