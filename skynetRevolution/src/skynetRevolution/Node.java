package skynetRevolution;

import java.util.ArrayList;

public class Node{
    private int value;
    private ArrayList<Node> neighbours;
    
    public Node(int value){
        this.value = value;
        neighbours = new ArrayList<Node>();
    }
    
    public void addNode(Node node){
        this.neighbours.add(node);
    }
    
    public ArrayList<Node> getNeighbours(){
        return this.neighbours;
    }
    
    public int getValue(){
        return this.value;
    }
    
} 
