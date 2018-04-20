package shadowsOfTheKnight;

import java.util.Scanner;

public class Player {
    
    private static int xLB, yLB, xRT, yRT;
    public static boolean first = true;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt(); // width of the building.
        int H = in.nextInt(); // height of the building.
        int N = in.nextInt(); // maximum number of turns before game over.
        int X0 = in.nextInt();
        int Y0 = in.nextInt();
        
        // The Middle Building Coordinates
        int midX = 0, midY = 0;
        
        while (true) {
            String bombDir = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)

            switch(bombDir){
                case "U": if(!first){
                            // Setting the available area 
                              position(midX,midY,xRT,yRT);
                          }else{
                            // Setting the initial available area 
                              position(X0,Y0,X0,0);
                              first = false;
                          }
                        //   Compute the middle building coordinates
                          midX = xLB;
                          midY = yRT + round(yLB,yRT);
                    break;
                case "UR": if(!first){
                              position(midX,midY,xRT,yRT);
                          }else{
                              position(X0,Y0,W-1,0);
                              first = false;
                          }
                          midX = xLB + round(xRT,xLB);
                          midY = yRT + round(yLB,yRT);
                    break;
                case "R": if(!first){
                              position(midX,midY,xRT,yRT);
                          }else{
                              position(X0,Y0,W-1,Y0);
                              first = false;
                          }
                          midX = xLB + round(xRT,xLB);
                          midY = yLB;
                    break;
                case "DR": if(!first){
                              position(midX,yLB,xRT,midY);
                          }else{
                              position(X0,H-1,W-1,Y0);
                              first = false;
                          }
                          midX = xLB + round(xRT,xLB);
                          midY = yRT + round(yLB,yRT);
                    break;
                case "D": if(!first){
                              position(xLB,yLB,midX,midY);
                          }else{
                              position(X0,H-1,X0,Y0);
                              first = false;
                          }
                          midX = xLB;
                          midY = yRT + round(yLB,yRT);
                    break;
                case "DL": if(!first){
                              position(xLB,yLB,midX,midY);
                          }else{
                              position(0,H-1,X0,Y0);
                              first = false;
                          }
                          midX = xRT + round(xLB,xRT);
                          midY = yLB + round(yRT,yLB);
                    break;
                case "L": if(!first){
                              position(midX,yLB,xRT,yRT);
                          }else{
                              position(0,Y0,X0,Y0);
                              first = false;
                          }
                          midX = xLB + round(xRT,xLB);
                          midY = yLB;
                    break;
                case "UL": if(!first){
                              position(xLB,midY,midX,yRT);
                          }else{
                              position(0,Y0,X0,0);
                              first = false;
                          }
                          midX = xLB + round(xRT,xLB);
                          midY = yRT + round(yLB,yRT);
                    break;
            }
            System.out.println(midX+" "+midY);
        }
    }
    
    public static void position(int x1, int y1, int x2, int y2){
        xLB = x1;
        yLB = y1;
        xRT = x2;
        yRT = y2;
    }
    
    private static int finalResult = 0;
    public static int round(int p1, int p2){
        int quotient = (p1 - p2)/2;
        if(quotient == finalResult){
            int rest = (p1 - p2)%2;
            finalResult = quotient + rest;
        }else{
            finalResult = quotient;
        }
        return finalResult;
    }
    
}
