package org.example;

import java.io.Serial;
import java.io.Serializable;

public class Person implements Serializable {

    private final static long serialVersionUID = 1L;
    private String name;
    private int age;
    private String occupation;
    private String email;

    public Person() {}

    public Person(String name, int age, String occupation, String email) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
