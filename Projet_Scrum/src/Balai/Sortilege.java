package Balai;

/**
 * Created by Sami on 22/11/2016.
 */
public class Sortilege extends CarteMagieNoire {

    public Sortilege(Type type)
    {
        this.type = type;
    }
    public Type getType()
    {
        return type;
    }
    public boolean isAcrobatie() {return false;}
    public boolean isSortilege() {return true;}
}
