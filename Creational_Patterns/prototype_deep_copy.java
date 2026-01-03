public class prototype_deep_copy {
    public static void main(String[] args) {
        Address add1 = new Address("Chennai");

        Student s1 = new Student("Aathi" , add1);
        Student s2 =  s1.clone();

        System.out.println("Original student city : " + s1.address.city);
        System.out.println("Cloned student city : " + s2.address.city);

        s2.address.city = "Bangalore";

        System.out.println("Original student city : " + s1.address.city);
        System.out.println("Cloned student city : " + s2.address.city);

    }
}
class Address{
    String city;

    Address(String city){
        this.city = city;
    }
}
class Student{
    String name;
    Address address;

    Student(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Student clone(){
        return new Student(
            this.name,
            new Address(this.address.city) // deep copy
        );
    }
}

