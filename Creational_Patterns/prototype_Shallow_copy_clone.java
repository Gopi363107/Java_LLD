public class prototype_Shallow_copy_clone {
    public static void main(String[] args) {
        Examiner e1 = new Examiner("Adithya" , 48 , "DH943VD8" , 1999);
        Examiner e2 = (Examiner) e1.clone();

        // the problem in shallow copy if we make the changes it also affect the main object
        e1.name = "Thamizh";

        System.out.println(e1.name + " " + e1.age + " " + e1.id + " " + e1.year);
        System.out.println(e2.name + " " + e2.age + " " + e2.id + " " + e2.year);
    }
}

// UPSC interface
interface UPSC{
    UPSC clone();
}

// Examiner class 
class Examiner implements UPSC{

    String name;
    int age;
    String id;
    int year;

    Examiner(String name ,int age , String id , int year){
        this.name = name;
        this.age = age;
        this.id = id;
        this.year = year;
    }

    public UPSC clone(){
        return new Examiner(this.name , this.age , this.id , this.year);
    }
}

