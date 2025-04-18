public class Main {
    private static final Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        System.out.println("КНИГА СОТРУДНИКОВ");
        employees[0] = new Employee("Александров Александр Александрович", 1, 55000);
        employees[1] = new Employee("Андреев Андрей Андреевич", 1, 75000);
        employees[2] = new Employee("Александрова Александра Александровна", 2, 45000);
        employees[3] = new Employee("Антонов Антон Антонович", 2, 85000);
        employees[4] = new Employee("Антонова Антонина Антоновна", 3, 43000);
        employees[5] = new Employee("Борисов Борис Борисович", 3, 86000);
        employees[6] = new Employee("Владимиров Владимир Владимирович", 4, 104000);
        employees[7] = new Employee("Владимирова Влада Владимировна", 4, 97000);
        employees[8] = new Employee("Сергеев Сергей Сергеевич", 5, 57000);
        employees[9] = new Employee("Тихонов Тихон Тихонович", 5, 79000);
        {
            double indexSalary;
            double indexPercent = 10;
            for (Employee employee : employees) {
                indexSalary = employee.getSalary() + employee.getSalary() * indexPercent / 100;
                employee.setSalary((int) indexSalary);
                System.out.println(employee);
            }
        }
        System.out.println("Общая сумма затрат на зарплату " + calculateSumSalary() + " в месяц");
        System.out.println("Сотрудник с минимальной зарплатой: " + findEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной зарплатой: " + findEmployeeWithMaxSalary());
        System.out.println("Средняя зарплата сотрудников: " + calculateAverageSalary());
        System.out.println("Ф.И.О. сотрудников:");
        printFullNames();
    }

    private static double calculateSumSalary() {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    private static Employee findEmployeeWithMinSalary() {
        Employee employeeWithMinSalary = null;
        for (Employee employee : employees) {
            if (employeeWithMinSalary == null || employee.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }
        return employeeWithMinSalary;
    }

    private static Employee findEmployeeWithMaxSalary() {
        Employee employeeWithMaxSalary = null;
        for (Employee employee : employees) {
            if (employeeWithMaxSalary == null || employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employee;
            }
        }
        return employeeWithMaxSalary;
    }

    private static double calculateAverageSalary() {
        return calculateSumSalary() / employees.length;
    }

    private static void printFullNames() {
        for (Employee employee : employees) {
            System.out.println(employee.getFullName());
        }
    }
}