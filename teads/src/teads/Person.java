package teads;

import java.util.ArrayList;

public class Person{
    private int id;
    private ArrayList<Person> neighbors;
    private boolean visited = false;
   
    public Person(int id){
        this.id = id;
        neighbors = new ArrayList<Person>();
    }
    
    public void setVisited(boolean visited){
        this.visited = visited;
    }
    
    public boolean isVisited(){
        return visited;
    }
    
    public void addNeighbor(Person person){
        neighbors.add(person);
    }
    
    public int getId(){
        return id;
    }
    
    public ArrayList<Person> getNeighbors(){
        return neighbors;
    }
}
