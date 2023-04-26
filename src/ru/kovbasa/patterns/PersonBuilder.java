package ru.kovbasa.patterns;

import ru.kovbasa.patterns.model.Person;

public class PersonBuilder {

    private String name;
    private String surname;
    private int age;
    private boolean hasAge;
    private String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalStateException("Возраст не может быть отрицательным!");
        }

        this.age = age;
        this.hasAge = true;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || name.isBlank()) {
            throw new IllegalStateException("Имя не указано!");
        }
        if (surname == null || surname.isBlank()) {
            throw new IllegalStateException("Фамилия не указана!");
        }

        Person person = new Person(name, surname);
        if (hasAge) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }

        person.setAddress(address);
        return person;
    }
}
