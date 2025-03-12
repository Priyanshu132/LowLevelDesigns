public class TechEmployee extends Employee{

    @Override
    int salaryPerMonth() {
        return 80_000;
    }

    @Override
    int salaryPerYear() {
        return salaryPerMonth() * 12;
    }
}
