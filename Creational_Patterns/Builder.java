import java.util.*;

public class Builder{
    public static void main(String args[]){
        User user =new User.UserBuilder("Gopi",20).setId("GE83N").build();
        User user1 =new User.UserBuilder("Aathi",19).setId("DE532").setAddress("Chennai").build();
        User user2 =new User.UserBuilder("Thamizh",20).setAddress("Bangalore").build();
        User user3 =new User.UserBuilder("Satheesh",20).setId("6837H").build();

        System.out.println(user);
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
    }
}

class User{
    private  final String name;
    private final int age;
    private final String address;
    private final String id;

    public User(UserBuilder user){
        this.name = user.name;
        this.age = user.age;
        this.address = user.address;
        this.id = user.id;

    }
    @Override
    public String toString(){
        return "User {name ='" + name+ "',age = ' " +age+ " ',address=' "+address+" ' ,id = '"+id+" '}";
    }

    //UserBuilder
    static class UserBuilder{
        private final String name;
        private final int age;
        private String address;
        private String id;

        public UserBuilder(String name , int age){
            if (name == null || age <= 0) {
                throw new IllegalStateException("Name and age are mandatory");
            }
            this.name = name;
            this.age = age;
        }

        public UserBuilder setAddress(String address){
            this.address = address;
            return this;
        }

        public UserBuilder setId(String id){
            this.id = id;
            return this;
        }

        public User build(){
            if (name == null || age <= 0) {
                throw new IllegalStateException("Name and age are mandatory");
            }
            return new User(this);
        }
    }
}