public class EmployeeFactory {

    public static Employee getTypeOfEmployee(EmployeeType employeeType) {

        switch (employeeType){
            case TECH -> {
                return new TechEmployee();
            }
            case PRODUCT -> {
                return new ProductEmployee();
            }
            case FINANCE -> {
                return new FinanceEmployee();
            }
            default -> {
                return null;
            }
        }
    }
}
