package org.example;

public class Persons {
    public Persons(Integer id, String Name, Integer salary) {
        this.id = id;
        this.name = Name;
        this.salary = salary;
    }

    Integer id;

    String name;
    Integer salary;

    @Override
    public String toString() {
        return "Persons{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", Salary=" + salary +
                '}';
    }
}
