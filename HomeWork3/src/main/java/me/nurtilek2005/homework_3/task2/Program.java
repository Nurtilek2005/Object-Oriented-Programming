package me.nurtilek2005.homework_3.task2;

import java.util.*;

public class Program {
    /**
     * TODO: Переработать метод generateEmployee в рамках домашнего задания,
     *  метод должен генерировать рабочих (Employee) разных типов.
     */
    public Employee generateEmployee(){
        Employee employee = null;
        Random random = new Random();
        int type = random.nextInt(2);
        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };
        String randSurname = surnames[random.nextInt(surnames.length)];
        String randFirstName = names[random.nextInt(names.length)];
        int salary = random.nextInt(20000, 80000);
        switch (type) {
            case 0 -> {
                Rank[] ranks = Rank.values();
                Rank rank = ranks[random.nextInt(ranks.length)];
                employee = new Freelancer(randFirstName, randSurname, salary, rank);
            }
            case 1 -> employee = new Worker(randFirstName, randSurname, salary);
        }
        return employee;
    }

    public List<Employee> generateEmployees() {
        return this.generateEmployees(10);
    }

    public List<Employee> generateEmployees(int count) {
        List<Employee> employeeList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            employeeList.add(this.generateEmployee());
        }
        return employeeList;
    }

    public List<Employee> sortEmployeesBySalary(List<Employee> employeeList) {
        int size = employeeList.size();
        Comparator<Employee> comparator = new SalaryComparator();
        List<Employee> sortedList = new ArrayList<>(employeeList);
        for (int i = 0; i < size; i++) {
            Employee employee1 = employeeList.get(i);
            for (int j = i + 1; j < size; j++) {
                Employee employee2 = employeeList.get(j);
                int winner = comparator.compare(employee2, employee1);
                System.out.println(winner);
                if (winner > 0) {
                    sortedList.set(i, employee2);
                    sortedList.set(j, employee1);
                }
            }
        }
        return sortedList;
    }

    public void run() {
//        List<Employee> employeeList = this.generateEmployees();
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Worker("Андрей", "Андреевич", 7));
        employeeList.add(new Worker("Андрей", "Андреевич", 6));
        employeeList.add(new Worker("Андрей", "Андреевич", 5));
        employeeList.add(new Worker("Андрей", "Андреевич", 4));
        employeeList.add(new Worker("Андрей", "Андреевич", 3));
        employeeList.add(new Worker("Андрей", "Андреевич", 2));
        employeeList.add(new Worker("Андрей", "Андреевич", 1));
        System.out.println(this.sortEmployeesBySalary(employeeList));
        System.out.println(employeeList);
    }

    public static void main(String[] args) {
        Program program = new Program();
        program.run();
    }
}
