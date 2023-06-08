package me.nurtilek2005.homework_3.task2;

public abstract class Employee implements Comparable<Employee> {
    protected String name;
    protected String surname;
    protected int experience;
    protected double salary; // Ставка заработной платы

    public Employee(String name, String surname, double salary) {
        this(name, surname, salary, 0);
    }

    public Employee(String name, String surname, double salary, int experience) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getSalary() {
        return salary;
    }

    public int getExperience() {
        return experience;
    }

    public void increaseExperience() {
        this.experience++;
    }

    /**
     * Расчет среднемесячной заработной платы
     */
    public abstract double calculateSalary();

    @Override
    public int compareTo(Employee o) {
        int res = name.compareTo(o.name);
        if (res == 0) {
            return Double.compare(calculateSalary(), o.calculateSalary());
        }
        return res;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Сотрудник; Среднемесячная заработная плата (фиксированная месячная оплата): %.2f (руб.); Стажа - %d",
                surname, name, calculateSalary(), getExperience());
    }
}

