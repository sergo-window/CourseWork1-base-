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
        findEmployeeWithMinSalaryInDepartment(3);
        findEmployeeWithMaxSalaryInDepartment(3);
        calculateSumSalaryInDepartment(3);
        calculateAverageSalaryInDepartment(3);
        indexingSalaryInDepartment(3, 10);
        printEmployeesInDepartment(3);
        printEmployeesWithSmallSalary(70000);
        printEmployeesWithBigSalary(70000);
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

    private static void findEmployeeWithMinSalaryInDepartment(int departmentNumber) {
        Employee employeeWithMinSalaryInDepartment = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                if (employeeWithMinSalaryInDepartment == null || employee.getSalary() < employeeWithMinSalaryInDepartment.getSalary()) {
                    employeeWithMinSalaryInDepartment = employee;
                }
            }
        }
        if (employeeWithMinSalaryInDepartment != null) {
            System.out.println("Сотрудник с минимальной зарплатой в отделе " + departmentNumber + ": " + employeeWithMinSalaryInDepartment.getFullName() +
                    ", зарплата " + employeeWithMinSalaryInDepartment.getSalary() + " руб.");
        } else {
            System.out.println("В отделе " + departmentNumber + " нет сотрудников.");
        }
    }

    private static void findEmployeeWithMaxSalaryInDepartment(int departmentNumber) {
        Employee employeeWithMaxSalaryInDepartment = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                if (employeeWithMaxSalaryInDepartment == null || employee.getSalary() > employeeWithMaxSalaryInDepartment.getSalary()) {
                    employeeWithMaxSalaryInDepartment = employee;
                }
            }
        }
        if (employeeWithMaxSalaryInDepartment != null) {
            System.out.println("Сотрудник с максимальной зарплатой в отделе " + departmentNumber + ": " + employeeWithMaxSalaryInDepartment.getFullName() +
                    ", зарплата " + employeeWithMaxSalaryInDepartment.getSalary() + " руб.");
        } else {
            System.out.println("В отделе " + departmentNumber + " нет сотрудников.");
        }
    }

    private static void calculateSumSalaryInDepartment(int departmentNumber) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                sum += employee.getSalary();
            }
        }
        System.out.println("Сумма затрат на зарплату по отделу " + departmentNumber + " составляет: " + sum + " руб. в месяц");
    }

    private static void calculateAverageSalaryInDepartment(int departmentNumber) {
        int sum = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                sum += employee.getSalary();
                count++;
            }
        }
        double averageSalary = count > 0 ? (double) sum / count : 0;
        System.out.println("Средняя зарплата по отделу " + departmentNumber + " составляет: " + averageSalary + " руб. в месяц");
        System.out.println("Количество сотрудников в отделе " + departmentNumber + " составляет: " + count + " человека");
    }

    private static void indexingSalaryInDepartment(int departmentNumber, double percent) {
        System.out.println("Зарплата сотрудников отдела " + departmentNumber + " после индексации на " + percent + " %:");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                double indexingSalary = employee.getSalary() + employee.getSalary() * percent / 100;
                employee.setSalary((int) indexingSalary);
                System.out.println(employee.getFullName() + ": " + (int) indexingSalary + " руб.");
            }
        }
    }

    private static void printEmployeesInDepartment(int departmentNumber) {
        System.out.println("Сотрудники отдела " + departmentNumber + ":");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }

    private static void printEmployeesWithSmallSalary(int criterionSalary) {
        System.out.println("Сотрудникии с зарплатой меньше " + criterionSalary + ":");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < criterionSalary) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }

    private static void printEmployeesWithBigSalary(int criterionSalary) {
        System.out.println("Сотрудникии с зарплатой больше " + criterionSalary + ":");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= criterionSalary) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }
}