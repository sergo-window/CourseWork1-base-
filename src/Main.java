public class Main {

    public static void main(String[] args) {
        System.out.println("\nКНИГА СОТРУДНИКОВ:");
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee("Александров Александр Александрович", 1, 55000);
        employeeBook.addEmployee("Андреев Андрей Андреевич", 1, 75000);
        employeeBook.addEmployee("Александрова Александра Александровна", 2, 45000);
        employeeBook.addEmployee("Антонов Антон Антонович", 2, 85000);
        employeeBook.addEmployee("Антонова Антонина Антоновна", 3, 43000);
        employeeBook.addEmployee("Борисов Борис Борисович", 3, 86000);
        employeeBook.addEmployee("Владимиров Владимир Владимирович", 4, 104000);
        employeeBook.addEmployee("Владимирова Влада Владимировна", 4, 97000);
        employeeBook.addEmployee("Сергеев Сергей Сергеевич", 5, 57000);
        employeeBook.addEmployee("Тихонов Тихон Тихонович", 5, 79000);

        employeeBook.printAllEmployees();
        employeeBook.indexingSalary();
        System.out.println("\nОБЩАЯ СУММА ЗАТРАТ НА ЗАРПЛАТУ: " + employeeBook.calculateSumSalary());
        System.out.println("\nСОТРУДНИК С МИНИМАЛЬНОЙ ЗАРПЛАТОЙ: " + employeeBook.findEmployeeWithMinSalary());
        System.out.println("\nСОТРУДНИК С МАКСИМАЛЬНОЙ ЗАРПЛАТОЙ: " + employeeBook.findEmployeeWithMaxSalary());
        System.out.println("\nСРЕДНЯЯ ЗАРПЛАТА СОТРУДНИКОВ: " + employeeBook.calculateAverageSalary());
        employeeBook.printFullNames();
        employeeBook.findEmployeeWithMinSalaryInDepartment(5);
        employeeBook.findEmployeeWithMaxSalaryInDepartment(5);
        employeeBook.calculateSumSalaryInDepartment(5);
        employeeBook.calculateAverageSalaryInDepartment(5);
        employeeBook.indexingSalaryInDepartment(5, 10);
        employeeBook.printEmployeesInDepartment(5);
        employeeBook.printEmployeesWithSmallSalary(70000);
        employeeBook.printEmployeesWithBigSalary(70000);
        employeeBook.addNewEmployee();
        employeeBook.removeEmployee(5);
        employeeBook.addNewEmployee();
        employeeBook.searchEmployee(4);
        employeeBook.searchAndPrintEmployee(4);
    }
}