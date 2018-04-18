package onTheShouldersOfGiants;

import java.util.ArrayList;

public class Node{
    private int value;
    private ArrayList<Node> childs;
    private int parentsNum = 0;         //the number of parents of every node
    
    public static int path = 1;         //the current path
    public static int longestPath = 1;
    
    public Node(int value){
        this.value = value;
        childs = new ArrayList<Node>();
    }
    
    public void addNode(Node child){
        childs.add(child);
    }
    
    public void increaseParentsNum(){
        this.parentsNum++;
    }
    
    public int getParentsNum(){
        return parentsNum;
    }
    
    public ArrayList<Node> getChilds(){
        return childs;
    }
    
    public int getValue(){
        return value;
    }
}

