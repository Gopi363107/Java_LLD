import java.util.*;
//client code

public class Prototype_pattern{
    public static void main(String[] args) {
        
        Student s1 = new Student("Gopi" , 20);
        Student s2 = (Student) s1.clone();

        System.out.println(s1.name + " " + s1.age);
        System.out.println(s2.name);
    }
}

//prototype interface
interface Prototype{
    Prototype clone();
}

//concrete class

class Student implements Prototype{
    String name;
    int age;

    Student(String name , int age){
        this.name = name;
        this.age = age;
    }

    public Prototype clone(){
        return new Student(this.name , this.age);
    }

}



