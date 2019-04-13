package edu.hust.se;

public class Person {
    private String name;
    public int age;

    @Override
    public String toString() {
        return "person{" +
                "name='" +name+'\''+
                ",age=" +age +
                '}';
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

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }
    public Person(){}

    public void show(){
        System.out.println("hello,i'm a person");
    }
    private String showNation(String nation){
        System.out.println("i'm from:"+nation);
        return nation;
    }
}
