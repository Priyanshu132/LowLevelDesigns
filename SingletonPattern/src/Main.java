import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, UnCloneableClassException {

        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        System.out.println("One Way : "+databaseConnection.hashCode());

        Singleton singleton = Singleton.getInstance();
        System.out.println("Specific Way In Java : "+singleton.hashCode());

        Singleton breakSingleton = null; // To avoid this Use Enum , as we can't call enum constructor using reflection
        // Break Singleton
        Constructor[] constructors = Singleton.class.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            // Below code will destroy the singleton
            // pattern
            constructor.setAccessible(true);
            breakSingleton = (Singleton)constructor.newInstance();
            break;
        }
        System.out.println("Break Singleton Pattern using Reflection "+breakSingleton.hashCode());

        // Break Singleton using Serializable
        // To overcome this issue, we have to implement the method readResolve() method.
        try {
            ObjectOutput out = new ObjectOutputStream(
                    new FileOutputStream("file.text"));
            out.writeObject(singleton);
            out.close();

            // deserialize from file to object
            ObjectInput in = new ObjectInputStream(
                    new FileInputStream("file.text"));

            Singleton instance2
                    = (Singleton)in.readObject();
            in.close();

            System.out.println("Serializable hashCode:- "
                    + instance2.hashCode());
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        // Throw exception while Cloning
        try{
            Singleton clone = singleton.clone();
            System.out.println("Clone : "+clone.hashCode());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}