import java.util.List;

public class Student {

    private int rollNumber;
    private int batchStartYear;
    private int batchEndYear;
    private String firstName;
    private String middleName;
    private String lastName;
    private String fatherName;
    private String motherName;
    private String mobileNumber;
    private List<String> subjects;

    public Student(StudentBuilder studentBuilder){
        rollNumber = studentBuilder.rollNumber;
        batchEndYear = studentBuilder.batchEndYear;
        batchStartYear = studentBuilder.batchStartYear;
        firstName = studentBuilder.firstName;
        middleName = studentBuilder.middleName;
        lastName = studentBuilder.lastName;
        fatherName = studentBuilder.fatherName;
        motherName = studentBuilder.motherName;
        mobileNumber = studentBuilder.mobileNumber;
        subjects = studentBuilder.subjects;
    }

    public Student(Builder studentBuilder){
        rollNumber = studentBuilder.rollNumber;
        batchEndYear = studentBuilder.batchEndYear;
        batchStartYear = studentBuilder.batchStartYear;
        firstName = studentBuilder.firstName;
        middleName = studentBuilder.middleName;
        lastName = studentBuilder.lastName;
        fatherName = studentBuilder.fatherName;
        motherName = studentBuilder.motherName;
        mobileNumber = studentBuilder.mobileNumber;
        subjects = studentBuilder.subjects;
    }

    public static StudentBuilder builder(){
        return new StudentBuilder();
    }

    public static Builder builder1(){
        return new Builder();
    }


    public int getBatchEndYear() {
        return batchEndYear;
    }

    public int getBatchStartYear() {
        return batchStartYear;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setBatchEndYear(int batchEndYear) {
        this.batchEndYear = batchEndYear;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setBatchStartYear(int batchStartYear) {
        this.batchStartYear = batchStartYear;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "Student{" +
                "batchEndYear=" + batchEndYear +
                ", rollNumber=" + rollNumber +
                ", batchStartYear=" + batchStartYear +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", subjects=" + subjects +
                '}';
    }

    static class Builder{
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

        public Builder setMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public Builder setBatchEndYear(int batchEndYear) {
            this.batchEndYear = batchEndYear;
            return this;
        }

        public Builder setBatchStartYear(int batchStartYear) {
            this.batchStartYear = batchStartYear;
            return this;
        }

        public Builder setFatherName(String fatherName) {
            this.fatherName = fatherName;
            return this;
        }

        public Builder setSubjects(List<String> subjects) {
            this.subjects = subjects;
            return this;
        }

        public Builder setRollNumber(int rollNumber) {
            this.rollNumber = rollNumber;
            return this;
        }

        public Builder setMotherName(String motherName) {
            this.motherName = motherName;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Student build(){
            return new Student(this);
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "batchEndYear=" + batchEndYear +
                    ", rollNumber=" + rollNumber +
                    ", batchStartYear=" + batchStartYear +
                    ", firstName='" + firstName + '\'' +
                    ", middleName='" + middleName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", fatherName='" + fatherName + '\'' +
                    ", motherName='" + motherName + '\'' +
                    ", mobileNumber='" + mobileNumber + '\'' +
                    ", subjects=" + subjects +
                    '}';
        }
    }
}
