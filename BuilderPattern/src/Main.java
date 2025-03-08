public class Main {
    public static void main(String[] args) {

        Student student = Student
                .builder()
                .setRollNumber(30)
                .setFirstName("Priyanshu")
                .setLastName("Gupta")
                .setMobileNumber("7055825661")
                .setBatchStartYear(2018)
                .setBatchEndYear(2022)
                .build();

        Student student1 = Student.builder1().setBatchStartYear(258).build();

        System.out.println(student.toString());
        System.out.println(student1.toString());
    }
}