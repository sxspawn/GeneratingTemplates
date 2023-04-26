package ru.kovbasa.patterns.model;

import java.util.OptionalInt;

import ru.kovbasa.patterns.PersonBuilder;

public class Person {

    private final String name;
    private final String surname;
    private Integer age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this(name, surname);

        this.age = Integer.valueOf(age);
    }

    public boolean hasAge() {
        return this.age != null;
    }

    public boolean hasAddress() {
        return this.address != null && !this.address.isEmpty();
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public OptionalInt getAge() {
        return hasAge() ? OptionalInt.empty() : OptionalInt.of(this.age);
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        this.age = Integer.valueOf(age.intValue() + 1);
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAge(0)
                .setAddress(this.address);
    }

    @Override
    public String toString() {
        return "Person: {\r\n" +
                "  name: " + this.name + "\r\n" +
                "  surname: " + this.surname + "\r\n" +
                "  age: " + this.age + "\r\n" +
                "  address: " + this.address + "\r\n}";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}