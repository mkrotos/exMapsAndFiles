package com.krotos;

public class Employee {
    String name;
    String surname;
    String position;
    long id;

    public Employee(String name, String surname, String position, long id) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.id = id;
    }
    public String toString(){
        return id+": "+ name+" "+surname+" "+position;
    }
}
