/*
    🎯 Strategy Pattern Example 
    Navigation / Route Planning System (Google Maps–like)

    This is excellent for Meta / Google interviews because it feels real.

    1️⃣ REQUIREMENTS (Start like an interviewer)
    Functional Requirements

    System should calculate route between source and destination

    Support multiple routing strategies:

        Fastest route
        Shortest distance
        Avoid tolls
        Avoid highways
        User can change route preference at runtime

    Non-Functional Requirements:

        Easy to add new routing algorithms
        No modification to existing route logic

    Follow SOLID principles
*/
// 🔹 Client Code
public class strategy_pattern {
    public static void main(String[] args) {
        NavigationSystem nav = new NavigationSystem();

        nav.setRouteStrategy(new FastestRoute());
        nav.buildRoute("Chennai", "Hydrabed");

        nav.setRouteStrategy(new AvoidHighwayRoute());
        nav.buildRoute("Bangalore", "Mumbai");

        nav.setRouteStrategy(new AvoidTollRoute());
        nav.buildRoute("Chennai", "Delhi");
    }
}

// 🔹 Strategy Interface
interface RouteStrategy{
    void calculateRoute(String source , String destination);
}

class FastestRoute implements RouteStrategy{

    public void calculateRoute(String source , String destination){
        System.out.println("Calculating fastest route from "+ source + " to "+ destination);
    }
}

class ShortestRoute implements RouteStrategy{

    public void calculateRoute(String source , String destination){
        System.out.println("Calculating shortest route from "+ source+" to "+destination);
    }
}

class AvoidTollRoute implements RouteStrategy{
    
    public void calculateRoute(String source , String destination){
        System.out.println("Calculation non toll route from "+source+ " to "+destination);
    }
}

class AvoidHighwayRoute implements RouteStrategy {
    public void calculateRoute(String source, String destination){
        System.out.println("Calculating route avoiding highways from " + source + " to " + destination);
    }
}


//🔹 Context Class

class NavigationSystem{
    private RouteStrategy routeStrategy;

    public void setRouteStrategy(RouteStrategy routeStrategy){
        this.routeStrategy = routeStrategy;
    }

    public void buildRoute(String src , String dest){
        routeStrategy.calculateRoute(src, dest);
    }
}

