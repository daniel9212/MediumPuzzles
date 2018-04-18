package theGift;

import java.util.Scanner;

public class Solution {
    
    public static void main(String args[]) {
        
        HeapSort hp = new HeapSort();
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c = in.nextInt();
        long budgetOfPart = 0;
        int[] budgets = new int[n];
        for (int i = 0; i < n; i++) {
            int b = in.nextInt();
            budgets[i] = b;
            budgetOfPart += b;
        }
        
        if(budgetOfPart >= c){
            hp.sort(budgets);
            int costPerPart = Math.round(c / n);
            int quotient = 0;
            for(int i = 0; i<n; i++){
                if(budgets[i] > costPerPart){
                    quotient = (int) (c/(n-i));
                    if(budgets[i] > quotient){
                        budgets[i] = quotient;
                    }
                }
                c -= budgets[i];
            }
            for(int budget : budgets){
                System.out.println(budget);
            }
        }else{
            System.out.println("IMPOSSIBLE");
        }
    }
}
