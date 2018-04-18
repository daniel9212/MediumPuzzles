package skynetRevolution;

import java.util.Scanner;

public class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int L = in.nextInt();
        int E = in.nextInt(); 
        
        Node[] nodes = new Node[N];
        
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); 
            int N2 = in.nextInt();
            
            if(nodes[N1] == null){
                nodes[N1] = new Node(N1);
            }
            if(nodes[N2] == null){
                nodes[N2] = new Node(N2);
            }
            nodes[N1].addNode(nodes[N2]);
            nodes[N2].addNode(nodes[N1]);
        }
       
        Node[] gateways = new Node[E];
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt();
            gateways[i] = nodes[EI];
        }


        while (true) {
            int SI = in.nextInt();
            int node1 = -1;
            int node2 = -1;
            
            for(int i=0; i<gateways.length; i++){
                if(gateways[i].getNeighbours().contains(nodes[SI])){
                    node1 = SI;
                    node2 = gateways[i].getValue();
                    break;
                }
            }

            if(node1<0 || node2<0){
                int index = (int) Math.random()*nodes[SI].getNeighbours().size();
                node1 = SI;
                node2 = nodes[SI].getNeighbours().get(index).getValue();
                System.out.println(node1+" "+node2);
            }else{
                System.out.println(node1+" "+node2);
            }
            
        }
    }
}