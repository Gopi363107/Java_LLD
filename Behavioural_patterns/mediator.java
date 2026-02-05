//ChatRoom  
//client  side
import java.util.List;
import java.util.ArrayList;

public class mediator{
    
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        User u1 = new ChatUser(chatRoom, "Gopi");
        User u2 = new ChatUser(chatRoom, "Arun");
        User u3 = new ChatUser(chatRoom, "Kumar");

        chatRoom.addUser(u1);
        chatRoom.addUser(u2);
        chatRoom.addUser(u3);

        u1.send("Hello everyone!");
    }
}

// mediator interface
interface ChatMediator{
    void sendMessage(String  msg,User user);
}

//concrete  mediator 
class ChatRoom implements ChatMediator{
    private List<User> users = new ArrayList<>();

    public void addUser(User user){
        users.add(user);
    }

    @Override
    public void sendMessage(String msg , User user){

        for(User u : users){
            if(u != user){
                u.receive(msg);
            }
        }
    }
}

// collegue user
abstract class User{
    protected ChatMediator mediator;
    protected String name;

    User(ChatMediator mediator , String name){
        this.mediator = mediator;
        this.name = name;
    }

    abstract void send(String msg);
    abstract void receive(String msg);
}

// concrete collegeue 
class ChatUser extends User{

    ChatUser(ChatMediator mediator,String name){
        super(mediator , name);
    }

    @Override
    void send(String msg){
        System.out.println(name + " sends : "+ msg);
        mediator.sendMessage(msg , this);
    }

    @Override
    void receive(String msg){
        System.out.println(name + " receives : " + msg);
    }
}