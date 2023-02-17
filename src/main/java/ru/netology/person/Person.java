package ru.netology.person;

import java.util.Objects;
import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    private OptionalInt age = OptionalInt.empty();
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this(name, surname);
        this.age = OptionalInt.of(age);
    }

    public Person(String name, String surname, int age, String address) {
        this(name, surname, age);
        this.address = address;
    }

    public Person(String name, String surname, String address) {
        this(name, surname);
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age.getAsInt();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    public boolean hasAge() {
        return age.isPresent();
    }

    public boolean hasAddress() {
        return address != null;
    }

    @Override
    public String toString() {
        if (hasAge()) {
            if (hasAddress()) {
                return String.format("Имя: %s, фамилия: %s, возраст: %d, адрес: %s.", name, surname, getAge(), address);
            } else {
                return String.format("Имя: %s, фамилия: %s, возраст: %d.", name, surname, getAge());
            }
        } else if (hasAddress()) {
            return String.format("Имя: %s, фамилия: %s, адрес: %s.", name, surname, address);
        } else {
            return String.format("Имя: %s, фамилия: %s.", name, surname);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(age, person.age) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilderImpl();
        personBuilder.setSurname(surname).setAddress(address);
        return personBuilder;
    }
}
