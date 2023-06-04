package me.nurtilek2005.homework_3.task2;

import java.util.Arrays;
import java.util.Random;

public class Program {

    static Random random = new Random();

    /**
     * TODO: Переработать метод generateEmployee в рамках домашнего задания,
     *  метод должен генерировать рабочих (Employee) разных типов.
     */
    static Employee generateEmployee(){
        Employee employee = null;
        int type = random.nextInt(2);
        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };
        String randSurname = surnames[random.nextInt(surnames.length)];
        String randFirstName = names[random.nextInt(names.length)];
        int salary = random.nextInt(20000, 80000);
        switch (type) {
            case 0 -> {
                Freelancer.Rank[] ranks = Freelancer.Rank.values();
                Freelancer.Rank rank = ranks[random.nextInt(ranks.length)];
                employee = new Freelancer(randFirstName, randSurname, salary, rank);
            }
            case 1 -> employee = new Worker(randFirstName, randSurname, salary);
        }
        return employee;
    }

    /**
     * TODO: Придумать новые состояния для наших сотрудников
     *   Придумать несколько Comparator'ов для сортировки сотрудников
     *   по фамилии + имени или по возрасту + уровню зп.
     */
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++)
        {
            employees[i] = generateEmployee();
        }
        Arrays.sort(employees);
        for (Employee employee: employees) {
            System.out.println(employee);
        }
    }
}
