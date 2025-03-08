import java.util.List;

public class StudentBuilder {

    int rollNumber;

    int batchStartYear;
    int batchEndYear;
    String firstName;
    String middleName;
    String lastName;
    String fatherName;
    String motherName;
    String mobileNumber;
    List<String> subjects;


    public StudentBuilder setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
        return this;
    }

    public StudentBuilder setBatchEndYear(int batchEndYear) {
        this.batchEndYear = batchEndYear;
        return this;
    }

    public StudentBuilder setBatchStartYear(int batchStartYear) {
        this.batchStartYear = batchStartYear;
        return this;
    }

    public StudentBuilder setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public StudentBuilder setSubjects(List<String> subjects) {
        this.subjects = subjects;
        return this;
    }

    public StudentBuilder setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
        return this;
    }

    public StudentBuilder setMotherName(String motherName) {
        this.motherName = motherName;
        return this;
    }

    public StudentBuilder setMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public StudentBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public StudentBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public Student build(){
        return new Student(this);
    }
}
