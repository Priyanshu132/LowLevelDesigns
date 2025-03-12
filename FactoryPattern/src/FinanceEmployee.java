public class FinanceEmployee extends Employee{

    @Override
    int salaryPerMonth() {
        return 50_000;
    }

    @Override
    int salaryPerYear() {
        return salaryPerMonth() * 12;
    }
}
