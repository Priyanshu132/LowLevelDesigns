import java.util.Objects;

public class DatabaseConnection {

    private static DatabaseConnection INSTANCE;

    private DatabaseConnection(){

    }
    // double Checked locking system
    public static DatabaseConnection getInstance(){
        if(Objects.isNull(INSTANCE)){
            synchronized (DatabaseConnection.class){
                if(Objects.isNull(INSTANCE))
                    INSTANCE = new DatabaseConnection();
            }
        }

        return INSTANCE;
    }
}
