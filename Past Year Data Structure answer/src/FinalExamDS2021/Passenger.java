package FinalExamDS2021;

public class Passenger{
    private String name;
    private String road;
    private double route;

    public Passenger(String name, String road) {
        this.name = name;
        this.road = road;
        this.route = Double.parseDouble(road.substring(5));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public double getRoute() {
        return route;
    }

    public void setRoute(double route) {
        this.route = route;
    }
}
