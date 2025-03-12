public class Main {
    public static void main(String[] args) {

        Employee tech = EmployeeFactory.getTypeOfEmployee(EmployeeType.TECH);

        Employee product = EmployeeFactory.getTypeOfEmployee(EmployeeType.PRODUCT);

        Employee finance = EmployeeFactory.getTypeOfEmployee(EmployeeType.FINANCE);

        System.out.println("TECH PER YEAR SALARY : "+tech.salaryPerYear());
        System.out.println("PRODUCT PER YEAR SALARY : "+product.salaryPerYear());
        System.out.println("FINANCE PER YEAR SALARY : "+finance.salaryPerYear());

    }
}