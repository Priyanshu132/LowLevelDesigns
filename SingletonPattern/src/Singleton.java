public class Singleton {
    // Java specific
    // Inner class loaded only once when it is called
    private Singleton(){

    }
    public static Singleton getInstance(){
        return SingletonInner.INSTANCE;
    }

    private static class SingletonInner{
        public static final Singleton INSTANCE = new Singleton();
    }
}
