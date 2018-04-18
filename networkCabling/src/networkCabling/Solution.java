package networkCabling;

import java.util.Scanner;

public class Solution {

    private static HeapSort hp = new HeapSort();
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        // Minimum and Maximum on the x axis
        int min = 0, max = 0;
        // Array which stores values on the y axis
        int[] yi = new int[n];
        
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            if(i == 0){
                min = x;
                max = x;
            }else{
                if(min > x){
                    min = x;
                }
                if(max < x){
                    max = x;
                }
            }
            
            yi[i] = y;
        }
        // Calculating the main path
        long mainPath = max - min;
        // Sorting the array
        hp.sort(yi);
        // The index of the middle house on y
        int index =(int) Math.round((double)(n-1)/2);
        int midHouseY = yi[index];
        
        long path = 0;
        for(int i=0; i<n; i++){
            long dif = midHouseY - yi[i];
            path += Math.abs(dif);
        }
        
        long cableLength = mainPath+ path;
        
        System.out.println(cableLength);
    }
}