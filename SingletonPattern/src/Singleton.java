import java.io.Serializable;

public class Singleton implements Serializable,Cloneable {
    // Java specific
    // Inner class loaded only once when it is called
    private Singleton(){

    }
    public static Singleton getInstance(){
        return SingletonInner.INSTANCE;
    }

    @Override
    public Singleton clone() {
        try {
            throw new UnCloneableClassException("This class can not be cloneable");
        } catch (UnCloneableClassException e) {
            throw new RuntimeException(e);
        }
    }

    private static class SingletonInner{
        public static final Singleton INSTANCE = new Singleton();
    }

    // implement readResolve method
    protected Object readResolve() { return SingletonInner.INSTANCE; }
}
