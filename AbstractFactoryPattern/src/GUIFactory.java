public class GUIFactory {

    public static Factory createFactory(FactoryType factoryType){
        Factory factory = null;
        switch (factoryType){
            case MAC -> factory = new MacFactory();
            case WIN -> factory = new WinFactory();
            case LINUX -> factory = new LinuxFactory();
        }
        return factory;
    }
}
