package ru.netology.person;

public interface PersonBuilder {
    PersonBuilder setName(String name);

    PersonBuilder setSurname(String surname);

    PersonBuilder setAge(int age);

    PersonBuilder setAddress(String address);

    Person build();
}
