package telephoneNumbers;

public class Node{
    private static int count = -1;
    Node[] children = new Node[10];
    
    public Node(){
        count++;
    }
    
    public int getCount(){
        return count;
    }
    
    public int index(char c){
        return c - '0';
    }
    
    public Node getNode(char c){
        return children[index(c)];
    }
    
    public void setNode(Node node, char c){
        children[index(c)] = node;
    }
    
    public void add(String s, int i){
        if(i == s.length()) return;
        char current = s.charAt(i);
        Node newNode = getNode(current);
        if(newNode == null){
            newNode = new Node();
            setNode(newNode,current);
        }
        newNode.add(s,i+1);
    }
}