
/*
    Movie        → data
    Theater      → data
    Show         → data (with seat count)
    Booking      → data (show + seats booked)
    BookingService → logic (creates booking, updates show)
    Notification → output only
    Main         → flow controller

*/
public class BookMyShow {
    
    public static void main(String[] args) {

        Movie movie = new Movie("Intersteller");
        Theater theater = new Theater("PVR");

        Show show = new Show(650 , 50 , movie , theater);

        PricingStrategy silver = new SilverPricing();

        BookingService bookingService = new BookingService(silver);
        Booking booking = bookingService.bookSeats(show , 5 , SeatType.SILVER);

        if(booking != null){
            Notification notification = new Notification();
            notification.sendBookingConfirmation(booking);
        }
        
    }
}

class  Movie{
    private String movieName;

    Movie(String movieName){
        this.movieName=movieName;
    }

    String getMovie(){
        return  movieName;
    }
}

class Theater{
    private String theaterName;

    Theater(String theaterName){
        this.theaterName = theaterName;
    }

    String getTheater(){
        return theaterName;
    }
}

class Show{
    private int timeSlot;
    private int availableSeat;
    private Movie movie;
    private Theater theater;

    Show(int timeSlot,int availableSeat,Movie movieName,Theater theaterName){
        this.timeSlot = timeSlot;
        this.availableSeat = availableSeat;
        this.movie = movieName;
        this.theater = theaterName;
    }

    public void bookSeats(int seatsRequested){
        availableSeat =  availableSeat - seatsRequested;
    }

    int getTime(){
        return timeSlot;
    }

    int getAvailableSeats(){
        return availableSeat;
    }
}

class Booking{
    private Show show;
    private int seatsBooked;
    
    Booking(Show show , int n){
        this.show = show;
        this.seatsBooked = n;
    }

    Show getShow(){
        return show;
    }

    int getSeatsBooked(){
        return seatsBooked;
    }

    
}

class BookingService{
    
    private PricingStrategy pricingStrategy;

    BookingService(PricingStrategy pricingStrategy){
        this.pricingStrategy = pricingStrategy;
    }

    public Booking bookSeats(Show show , int seatsRequested ,  SeatType seatType){
        if(show.getAvailableSeats() < seatsRequested){
            System.out.println("Not enough seats available.");
            return null;
        }

        int pricePerSeat = pricingStrategy.calculatePrice(seatType);
        int totalAmount = pricePerSeat * seatsRequested;

        show.bookSeats(seatsRequested);

        Booking booking = new Booking(show,seatsRequested);

        System.out.println("Booking successful for " + seatsRequested + " seats in | " + seatType +" | Total amount in rupees : " + totalAmount );
        return booking;
    }
}

class Notification{
    public void sendBookingConfirmation(Booking booking){
        System.out.println("Booking tickets confirmed.");
    }
}

// strategy pattern used in the pricing strategy
/*
🔹 What is enum? (Super Simple)
An enum is a type that has a fixed set of values.

Real-world idea:
Traffic light can only be:

RED
YELLOW
GREEN

Nothing else.
That’s exactly what enum is for. */

interface PricingStrategy{
    int calculatePrice(SeatType seatType);
}
enum SeatType {
    SILVER,
    GOLD,
    PLATINUM
}
//🥈 SilverPricing
class SilverPricing implements PricingStrategy{
    @Override
    public int calculatePrice(SeatType seatType){
        return 99;
    }
}
//🥇 GoldPricing
class GoldPricing implements PricingStrategy{
    @Override
    public int calculatePrice(SeatType seatType){
        return 199;
    }
}

// 💎 PlatinumPricing
class PlatinumPricing implements PricingStrategy{
    @Override
    public int calculatePrice(SeatType seatType){
        return 299;
    }
}