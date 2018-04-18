package telephoneNumbers;

import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Node root = new Node();
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            String telephone = in.next();
            root.add(telephone,0);
        }
        
        System.out.println(root.getCount());
    }
}