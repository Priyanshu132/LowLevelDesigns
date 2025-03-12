public class Main {
    public static void main(String[] args) {

        DatabaseConnection databaseConnection = DatabaseConnection.getInstance();
        System.out.println("One Way : "+databaseConnection.hashCode());

        Singleton singleton = Singleton.getInstance();
        System.out.println("Specific Way In Java : "+singleton.hashCode());


    }
}