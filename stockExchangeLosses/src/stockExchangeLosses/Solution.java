package stockExchangeLosses;

import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        int max = 0, min = 0, maxLoss = 0, loss = 0;
        for (int i = 0; i < n; i++) {
            int v = in.nextInt();
            arr[i] = v;
            if(i == 0){
                max = arr[i];
                min = arr[i];
            }else{
                if(max < arr[i]){
                    max = arr[i];
                    min = arr[i];
                }
                if(min > arr[i]){
                    min = arr[i];
                }
                loss = min - max;
                if(maxLoss > loss){
                    maxLoss = loss;
                }
            }
            
        }
        System.out.println(maxLoss);
    }
    
}