package ru.netology.person;

public class PersonBuilderImpl implements PersonBuilder {

    private String name;
    private String surname;
    private int age = -1;
    private String address;

    @Override
    public PersonBuilderImpl setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public PersonBuilderImpl setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    @Override
    public PersonBuilderImpl setAge(int age) {
        if (age >= 0 && age <= 100) {
            this.age = age;
            return this;
        } else throw new IllegalArgumentException("Возраст не может быть отрицательным и больше 100 лет");
    }

    @Override
    public PersonBuilderImpl setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public Person build() {
        if (name != null && surname != null) {
            if (age != -1) {
                if (address != null) {
                    return new Person(name, surname, age, address);
                } else {
                    return new Person(name, surname, age);
                }
            } else if (address != null) {
                return new Person(name, surname, address);
            } else {
                return new Person(name, surname);
            }

        } else throw new IllegalStateException("Не хватает обязательных полей. Поле name и surname не может быть null");

    }
}
