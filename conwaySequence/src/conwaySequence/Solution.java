package conwaySequence;

import java.util.Scanner;

public class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int r = in.nextInt();
        int l = in.nextInt();
        
        String firstLine = ""+r;

        int i = 1;
        while(i < l){
            String[] previousLine = firstLine.split(" ");
            String num0 = previousLine[0];
            
            
            StringBuffer lineL = new StringBuffer();
            
            int j = 0, count = 0;
            while(j < previousLine.length){
                if(previousLine[j].equals(num0)){
                    count++;
                }else{
                    lineL.append(count);
                    lineL.append(" ");
                    lineL.append(num0);
                    lineL.append(" ");
                    num0 = previousLine[j];
                    count = 1;
                }
                if(j == previousLine.length - 1){
                    lineL.append(count);
                    lineL.append(" ");
                    lineL.append(num0);
                }
                j++;
            }
            firstLine = lineL.toString();
            i++;
        }
        

        System.out.println(firstLine);
    }
}
