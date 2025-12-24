import java.util.*;
/*
🟡 Medium-Level OCP Question (DO THIS)

System: Notification System

👉 Requirements:

Send notification

Types:

Email
SMS
WhatsApp

❓ Task:

First think of OCP violation
Then design system following OCP
Use interface + implementation
Write a Main class

💡 Hint:

Notification → abstraction
Email / SMS / WhatsApp → extension
*/

public class NotificationSystem {
    public static void main(String[] args) {
        String message = "Hello I am Gopinath Founder & CEO of InfiLearn International School";

        NotificationType type = new WhatsApp();
        Message news = new Message();

        String sent = news.Send(type , message);
        System.out.println(sent);
        System.out.println("Message successfully sent.");
        
    }
}
// 1️⃣ Strategy Interface
interface NotificationType{
    String SendMessage(String message);
}

// 2️⃣ Concrete Implementations
class Email implements NotificationType{
    public String SendMessage(String message){
        System.out.println("Email Notification");
        return message;
    }
}

class SMS implements NotificationType{

    public String SendMessage(String message){
        System.out.println("SMS Notification");
        return message;
    }
}

class WhatsApp implements NotificationType{
    public String SendMessage(String message){
        System.out.println("WhatsApp Notification");
        return message;
    }
}
// Message class closed for modification it only open for extension
class Message {
    String Send(NotificationType notification , String message){
        return notification.SendMessage(message);
    }
}