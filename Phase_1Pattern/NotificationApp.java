public class NotificationApp {
    public static void main(String[] args) {
        Notification notify =  NotificationFactory.createNotification(NotificationType.WHATSAPP);
        notify.notifyUser();

        Notification notify1 =  NotificationFactory.createNotification(NotificationType.EMAIL);
        notify1.notifyUser();

        Notification notify2 =  NotificationFactory.createNotification(NotificationType.SMS);
        notify2.notifyUser();
    }
}
// factory pattern used
interface Notification{
    void notifyUser();
}

class EmailNotification implements Notification{
    @Override
    public void notifyUser(){
        System.out.println("EMAIL message sending.");
    }
}

class SMSNotification implements Notification{
    @Override
    public void notifyUser(){
        System.out.println("SMS message sending.");
    }
}

class WhatsappNotification implements Notification{
    @Override
    public void notifyUser(){
        System.out.println("Whatsapp message sending.");
    }
}
enum NotificationType{
    EMAIL ,
    SMS ,
    WHATSAPP
}

class NotificationFactory{

    public static Notification createNotification(NotificationType type){
        return switch(type) {
            case EMAIL -> new EmailNotification();
            case SMS -> new SMSNotification();
            case WHATSAPP -> new WhatsappNotification();
        };
    }
}

