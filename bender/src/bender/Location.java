package bender;

public class Location{
    private String location;
    private boolean inverter;
    private boolean breaker;
    private int state;
    
    public Location(int xLocation, int yLocation, boolean inverter, boolean breaker, int state){
        this.location = xLocation + "" + yLocation;
        this.inverter = inverter;
        this.breaker = breaker;
        this.state = state;
    }
    
    public String getLocation(){
        return location;
    }
    
    public boolean isInverter(){
        return inverter;
    }
    
    public boolean isBreaker(){
        return breaker;
    }
    
    public int getState(){
        return state;
    }
}