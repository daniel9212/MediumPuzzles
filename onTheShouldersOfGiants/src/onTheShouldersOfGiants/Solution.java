package onTheShouldersOfGiants;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
// Creating The Graph
        LinkedList<Node> graph = new LinkedList<Node>();
        
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            
// Initializing The Graph
            formGraph(x,y,graph);
        }
        
// Longest Path for a disconnected Graph
        int theLongestPath = 1;
        for(Node node : graph){
            if(node.getParentsNum() == 0){
                dfs(node);
                if(theLongestPath < node.longestPath){
                    theLongestPath = node.longestPath;
                }
            }
        }
        
        System.out.println(theLongestPath);
    }
    
// Calculating the longest path
  public static void dfs(Node root){
      if(root.getChilds().size() == 0){
          if(root.longestPath < root.path){
              root.longestPath = root.path;
          }
          return;
      } 
      
      for(Node child : root.getChilds()){
            child.path++;
            dfs(child);
            root.path--;
      }
  }
    
// Method for checking if the Node is already created in the Graph
    public static Node isInside(int value, LinkedList<Node> graph){
        for(Node node : graph){
            if(node.getValue() == value){
                return node;
            }
        }
        return null;
    }
    

// Method for adding Nodes to directed Graph
    public static void formGraph(int x, int y, LinkedList<Node> graph){
            Node node1 = isInside(x,graph);
            Node node2 = isInside(y,graph);
            
            if(node1 != null && node2 != null){
                node1.addNode(node2);
            }else if(node1 != null){
                node2 = new Node(y);
                graph.add(node2);
                node1.addNode(node2);
            }else if(node2 != null){
                node1 = new Node(x);
                graph.add(node1);
                node1.addNode(node2);
            }else{
                node1 = new Node(x);
                node2 = new Node(y);
                graph.add(node1);
                graph.add(node2);
                node1.addNode(node2);
            }
            
            node2.increaseParentsNum();
    }
}