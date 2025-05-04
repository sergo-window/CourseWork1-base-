public class EmployeeBook {
    private final Employee[] employees;
    private int size;

    public EmployeeBook() {
        this.employees = new Employee[10];
        this.size = 0;
    }

    public void addEmployee(String fullName, int department, int salary) {
        if (size < employees.length) {
            employees[size++] = new Employee(fullName, department, salary);
        } else {
            System.out.println("\nНЕЛЬЗЯ ДОБАВИТЬ СОТРУДНИКА, ВАКАНСИЙ НЕТ!");
        }
    }

    public void indexingSalary() {
        System.out.println("\nПОСЛЕ ИНДЕКСАЦИИ ЗАРПЛАТЫ:");
        double indexSalary;
        double indexPercent = 10;
        for (Employee employee : employees) {
            indexSalary = employee.getSalary() + employee.getSalary() * indexPercent / 100;
            employee.setSalary((int) indexSalary);
            System.out.println(employee);
        }
    }

    public void printAllEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }


    public double calculateSumSalary() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += employees[i].getSalary();
        }
        return sum;
    }

    public Employee findEmployeeWithMinSalary() {
        if (size == 0) return null;

        Employee employeeWithMinSalary = employees[0];
        for (int i = 1; i < size; i++) {
            if (employees[i].getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employees[i];
            }
        }
        return employeeWithMinSalary;
    }

    public Employee findEmployeeWithMaxSalary() {
        if (size == 0) return null;

        Employee employeeWithMaxSalary = employees[0];
        for (int i = 1; i < size; i++) {
            if (employees[i].getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employees[i];
            }
        }
        return employeeWithMaxSalary;
    }

    public double calculateAverageSalary() {
        return size > 0 ? calculateSumSalary() / size : 0;
    }

    public void printFullNames() {
        System.out.println("\nФ.И.О. СОТРУДНИКОВ:");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i].getFullName());
        }
    }

    public void findEmployeeWithMinSalaryInDepartment(int departmentNumber) {
        Employee employeeWithMinSalaryInDepartment = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                if (employeeWithMinSalaryInDepartment == null || employee.getSalary() < employeeWithMinSalaryInDepartment.getSalary()) {
                    employeeWithMinSalaryInDepartment = employee;
                }
            }
        }
        if (employeeWithMinSalaryInDepartment != null) {
            System.out.println("\nСОТРУДНИК С МИНИМАЛЬНОЙ ЗАРПЛАТОЙ В ОТДЕЛЕ " + departmentNumber + ": " + employeeWithMinSalaryInDepartment.getFullName() +
                    ", зарплата " + (double) employeeWithMinSalaryInDepartment.getSalary());
        } else {
            System.out.println("\nВ ОТДЕЛЕ " + departmentNumber + " НЕТ СОТРУДНИКОВ!");
        }
    }

    public void findEmployeeWithMaxSalaryInDepartment(int departmentNumber) {
        Employee employeeWithMaxSalaryInDepartment = null;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                if (employeeWithMaxSalaryInDepartment == null || employee.getSalary() > employeeWithMaxSalaryInDepartment.getSalary()) {
                    employeeWithMaxSalaryInDepartment = employee;
                }
            }
        }
        if (employeeWithMaxSalaryInDepartment != null) {
            System.out.println("\nСОТРУДНИК С МАКСИМАЛЬНОЙ ЗАРПЛАТОЙ В ОТДЕЛЕ " + departmentNumber + ": " + employeeWithMaxSalaryInDepartment.getFullName() +
                    ", зарплата " + (double) employeeWithMaxSalaryInDepartment.getSalary());
        } else {
            System.out.println("\nВ ОТДЕЛЕ " + departmentNumber + " НЕТ СОТРУДНИКОВ!");
        }
    }

    public void calculateSumSalaryInDepartment(int departmentNumber) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                sum += employee.getSalary();
            }
        }
        System.out.println("\nСУММА ЗАТРАТ НА ЗАРПЛАТУ ПО ОТДЕЛУ " + departmentNumber + " СОСТАВЛЯЕТ: " + (double) sum);
    }

    public void calculateAverageSalaryInDepartment(int departmentNumber) {
        int sum = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                sum += employee.getSalary();
                count++;
            }
        }
        double averageSalary = count > 0 ? (double) sum / count : 0;
        System.out.println("\nСРЕДНЯЯ ЗАРПЛАТА ПО ОТДЕЛУ " + departmentNumber + " СОСТАВЛЯЕТ: " + averageSalary);
        System.out.println("Количество сотрудников в отделе " + departmentNumber + " составляет: " + count + " человека");
    }

    public void indexingSalaryInDepartment(int departmentNumber, double percent) {
        System.out.println("\nЗАРПЛАТА СОТРУДНИКОВ ОТДЕЛА " + departmentNumber + " ПОСЛЕ ИНДЕКСАЦИИ НА " + percent + " %:");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                double indexingSalary = employee.getSalary() + employee.getSalary() * percent / 100;
                employee.setSalary((int) indexingSalary);
                System.out.println(employee.getFullName() + ": " + indexingSalary);
            }
        }
    }

    public void printEmployeesInDepartment(int departmentNumber) {
        System.out.println("\nСОТРУДНИКИ ОТДЕЛА " + departmentNumber + ":");
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == departmentNumber) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }

    public void printEmployeesWithSmallSalary(double criterionSalary) {
        System.out.println("\nСОТРУДНИКИ С ЗАРПЛАТОЙ МЕНЬШЕ " + criterionSalary + " :");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < criterionSalary) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }

    public void printEmployeesWithBigSalary(double criterionSalary) {
        System.out.println("\nСОТРУДНИКИ С ЗАРПЛАТОЙ БОЛЬШЕ " + criterionSalary + " :");
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= criterionSalary) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }

    public void addNewEmployee() {
        if (size < employees.length) {
            employees[size] = new Employee("Фёдоров Фёдор Фёдорович", 5, 71000);
            size++;
            System.out.println("\nНОВЫЙ СОТРУДНИК УСПЕШНО ДОБАВЛЕН");
        } else {
            System.out.println("\nНЕЛЬЗЯ ДОБАВИТЬ СОТРУДНИКА, ВАКАНСИЙ НЕТ!");
        }
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee != null && employee.getId() == id) {
                employees[i] = employees[size - 1];
                employees[size - 1] = null;
                size--;
                System.out.println("\nСОТРУДНИК С id=" + id + " УСПЕШНО УДАЛЁН");
            }
        }
    }

    public Employee searchEmployee(int id) {
        for (int i = 0; i < size; i++) {
            Employee employee = employees[i];
            if (employee != null && employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void searchAndPrintEmployee(int id) {
        Employee employee = searchEmployee(id);  // Используем первый метод
        if (employee != null) {
            System.out.println("\nНАЙДЕН СОТРУДНИК: "
                    + employee.getFullName()
                    + ", id=" + employee.getId()
                    + ", отдел " + employee.getDepartment()
                    + ", зарплата " + (double) employee.getSalary());
        } else {
            System.out.println("\nСОТРУДНИК С id=" + id + " НЕ НАЙДЕН!");
        }
    }
}