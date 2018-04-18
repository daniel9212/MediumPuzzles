package bender;

public class Teleporter{
    private int xLocation;
    private int yLocation;
    private boolean visited = false;
    
    public Teleporter(int x, int y){
        this.xLocation = x;
        this.yLocation = y;
    }
    
    public int getXLocation(){
        return xLocation;
    }
    
    public int getYLocation(){
        return yLocation;
    }
    
    public boolean isVisited(){
        return visited;
    }
    
    public void setVisited(boolean visited){
        this.visited = visited;
    }
}
