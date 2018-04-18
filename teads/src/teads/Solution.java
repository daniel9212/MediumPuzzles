package teads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of adjacency relations
 
        // HashMap for the structure of the Graph
        Map<Integer,ArrayList<Integer>> graphMap = new HashMap<Integer,ArrayList<Integer>>();
        
        for (int i = 0; i < n; i++) {
            int xi = in.nextInt(); // the ID of a person which is adjacent to yi
            int yi = in.nextInt(); // the ID of a person which is adjacent to xi
            
            // Add ids to the graphMap
            createGraphMap(xi,yi,graphMap);
        }
        
        // ArrayList for the Graph
        List<Person> graph = new ArrayList<Person>();
        
        // Create an auxiliary HashMap to correlate the ids with their hashcode
        Map<Integer,Person> hashCodes = new HashMap<Integer,Person>();
        
        // Add persons to the graph
        for(Integer key : graphMap.keySet()){
            graph.add(new Person((int) key));
        }

        // Initialize the auxiliary map
        for(Person person : graph){
            hashCodes.put(person.getId(),person);
        }
        
        // Add the neigbor list for each person
        for(Person person : graph){
            for(Integer item : graphMap.get(person.getId())){
                person.addNeighbor(hashCodes.get(item));
            }
            
        }
        
        // Calculate the longest path from an arbitrary leaf
        for(Person person : graph){
            if(person.getNeighbors().size() == 1){
                graphTraverse(person,true);
                break;
            }
        }
        
        // Calculate the longest path of the Graph
        graphTraverse(lastPerson, false);
        
        float longestPath = longestPath0;
        
        // Calculate the maxim impact
        int maximImpact = Math.round(longestPath/2);
        System.out.println(maximImpact);
    }
    
    
    
    public static int path = 0, longestPath0 = 0;
    public static Person lastPerson = null;
    
    public static void graphTraverse(Person person, boolean visited){
        person.setVisited(visited);
        if(person.getNeighbors().size() == 1)
            if(person.getNeighbors().get(0).isVisited() == visited){
                if(longestPath0 < path){
                    longestPath0 = path;
                    lastPerson = person;
                }
                return;
            } 
            
        for(Person currPerson : person.getNeighbors()){
            if(currPerson.isVisited() != visited){
                path++;
                graphTraverse(currPerson, visited);
                path--;
            
            }
        }
    }
    
    
    
    
    public static void createGraphMap(int x, int y, Map<Integer,ArrayList<Integer>> graphMap){
        boolean xInMap = graphMap.containsKey(x);
        boolean yInMap = graphMap.containsKey(y);
        
        if(!(xInMap || yInMap)){
            ArrayList<Integer> value1 = new ArrayList<Integer>();
            ArrayList<Integer> value2 = new ArrayList<Integer>();
            value1.add(y);
            value2.add(x);
            graphMap.put(x,value1);
            graphMap.put(y,value2);
        }else if(!yInMap){
            graphMap.get(x).add(y);
            ArrayList<Integer> value = new ArrayList<Integer>();
            value.add(x);
            graphMap.put(y,value);
        }else if(!xInMap){
            graphMap.get(y).add(x);
            ArrayList<Integer> value = new ArrayList<Integer>();
            value.add(y);
            graphMap.put(x,value);
        }else{
            graphMap.get(x).add(y);
            graphMap.get(y).add(x);
        }
    }
}
