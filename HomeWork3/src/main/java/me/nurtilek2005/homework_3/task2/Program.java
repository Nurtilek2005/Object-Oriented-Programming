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
        int experience = random.nextInt(0, 10);
        switch (type) {
            case 0 -> {
                Rank[] ranks = Rank.values();
                Rank rank = ranks[random.nextInt(ranks.length)];
                employee = new Freelancer(randFirstName, randSurname, salary, experience, rank);
            }
            case 1 -> employee = new Worker(randFirstName, randSurname, salary, experience);
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
        return this.sortEmployees(employeeList, new SalaryComparator());
    }

    public List<Employee> sortEmployeesByExperience(List<Employee> employeeList) {
        return this.sortEmployees(employeeList, new ExperienceComparator());
    }

    private List<Employee> sortEmployees(List<Employee> employeeList, Comparator<Employee> comparator) {
        int size = employeeList.size();
        List<Employee> sortedList = new ArrayList<>(employeeList);
        sortedList.sort(comparator.reversed());
        return sortedList;
    }

    public void run() {
        List<Employee> employeeList = this.generateEmployees();
        System.out.println(this.sortEmployeesByExperience(employeeList));
    }

    public static void main(String[] args) {
        Program program = new Program();
        program.run();
    }
}
