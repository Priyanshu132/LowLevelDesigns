public class ProductEmployee extends Employee{

    @Override
    int salaryPerMonth() {
        return 1_00_000;
    }

    @Override
    int salaryPerYear() {
        return salaryPerMonth() * 12;
    }
}
