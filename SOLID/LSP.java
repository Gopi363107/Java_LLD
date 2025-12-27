import java.util.*;
// Liskov Substitution Principle
public class LSP {
    public static void main(String[] args) {
        Flyable bird1 = new Peacock();
        bird1.fly();

        Flyable bird2 = new Peagon();
        bird2.fly();

        Flyable bird3 = new Eagle();
        bird3.fly();
    }
}

interface Flyable{
    void fly();
}

class Peacock implements Flyable{
    @Override
    public void fly(){
        System.out.println("Peacock can fly.");
    }
}

class Peagon implements Flyable{
    @Override
    public void fly(){
        System.out.println("peagon can fly.");
    }
}

class Eagle implements Flyable{
    @Override
    public void fly(){
        System.out.println("eagle can fly above the sky.");
    }
}