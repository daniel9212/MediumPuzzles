package mayanCalculation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    
    public static int getNum10(String[] arrToFind, ArrayList<String[]> list){
        boolean found = false;
        int foundNum = -1;
        for(int i=0; i<20; i++){
            for(int j=0; j<arrToFind.length; j++){
                found = false;
                if(!list.get(i)[j].equals(arrToFind[j])){
                    break;
                }else {
                    found = true;
                }
            }
            if(found == true){
                foundNum = i;
                break;
            }
        }
        return foundNum;
    }
    
    public static int transformFromBase20ToBase10(Queue<Integer> q){
        int size = q.size();
        int num10 = 0;
        for(int i=size-1; i>=0; i--){
            num10 += q.poll()*Math.pow(20,i);
        }
        return num10;
    }
    
    public static long result10(long num1, long num2, String operation){
        long result = -1;
        switch(operation){
            case "+" : result = num1 + num2;
                    break;
            case "-" : result = num1 - num2;
                    break;
            case "*" : result = num1 * num2;
                    break;
            case "/" : result = num1 / num2;
                    break;
        }
        return result;
        
    } 
    
    public static ArrayList<Long> transformFromBase10ToBase20(long num){
        ArrayList<Long> list = new ArrayList<Long>();
        long cat = num; 
        long rest;
        if(cat == 0){
            rest = cat % 20;
            list.add(rest);
        }
        while(cat > 0){
            rest = cat % 20;
            cat = cat / 20;
            list.add(rest);
            
        }
        return list;
    }
    
    public static void displayMayaResult(ArrayList<Long> convertList, ArrayList<String[]> mayaList){
        int size = convertList.size();
        for(int i=size-1; i>=0; i--){
            long mayaNumber = convertList.get(i);
            int mNumber = (int) mayaNumber;
            displayNumber(mayaList, mNumber);
        }
    }
    
    public static void displayNumber(ArrayList<String[]> mayaList, int index){
        String[] line = mayaList.get(index);
        for(int i=0; i<line.length; i++){
            System.out.println(line[i]);
        }
    }
    

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int L = in.nextInt();
        int H = in.nextInt();
        
        
        ArrayList<String[]> list = new ArrayList<String[]>();
        for (int i = 0; i < H; i++) {
            String numeral = in.next();
            int j = 0;
            while(j<20*L){
                 if(i == 0){
                     String[] num20 = new String[H];
                     list.add(num20);
                     num20[i] = numeral.substring(j,j+L);
                 } else{
                     list.get(j/L)[i] = numeral.substring(j,j+L);
                 }
                 j += L;
            }
        }
        
        
        String[] arrToFind1 = null;
        Integer result1 = 0;
        Queue<Integer> q1 = new LinkedList<Integer>();
        int S1 = in.nextInt();
        
        for (int i = 0; i < S1; i++) {
            String num1Line = in.next();
            if(i % H == 0){
                if(i != 0){
                    result1 = getNum10(arrToFind1,list);
                    q1.offer(result1);
                }
                arrToFind1 = new String[H];               
            }
            arrToFind1[i%H] = num1Line;
            if(i == S1-1){
                result1 = getNum10(arrToFind1,list);
                q1.offer(result1);
            }
        }
        
        
        
        
        String[] arrToFind2 = null;
        Integer result2;
        Queue<Integer> q2 = new LinkedList<Integer>();
        int S2 = in.nextInt();
        for (int i = 0; i < S2; i++) {
            String num2Line = in.next();
            if(i % H == 0){
                if(i != 0){
                    result2 = getNum10(arrToFind2,list);
                    q2.offer(result2);
                }
                arrToFind2 = new String[H];               
            }
            arrToFind2[i%H] = num2Line;
            if(i == S2-1){
                result2 = getNum10(arrToFind2,list);
                q2.offer(result2);
            }
            
        }
        
        int number110 = transformFromBase20ToBase10(q1);
        int number210 = transformFromBase20ToBase10(q2);
        
        String operation = in.next();
        
        
        long result = result10(number110, number210, operation);
        
        
        ArrayList<Long> convertList = transformFromBase10ToBase20(result);
        displayMayaResult(convertList, list);
        
    }
}
