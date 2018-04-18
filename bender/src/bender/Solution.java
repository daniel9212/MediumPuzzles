package bender;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    
    private static char[][] map;
    private static int currI = 0, currJ = 0, currentState = 0, h = 0, locationCount = 0;
    private static boolean inverter = false, breaker = false, loop = false;
    
    private static ArrayList<Location> list = new ArrayList<Location>();
    private static Set<String> isLoop = new HashSet<String>();
    
    private static Teleporter[] teleporters = new Teleporter[2];
    
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int c = in.nextInt();
        if (in.hasNextLine()) {
            in.nextLine();
        }
        
        map = new char[l][c];
        int startI = 0, startJ = 0, k = 0;
        for (int i = 0; i < l; i++) {
            String row = in.nextLine();
            for(int j = 0; j < c; j++){
                if(row.charAt(j) == '@'){
                    startI = i;
                    startJ = j;
                }
                if(row.charAt(j) == 'T'){
                    teleporters[k] = new Teleporter(i,j);
                    k++;
                }
                map[i][j] = row.charAt(j);
            }
        }
        
        currI = startI;
        currJ = startJ;
        traverse(map[currI][currJ]);
        if(!loop){
            for(Location location : list){
                printState(location.getState());
            }
        }
        
    }
    
    // Setting the position where it will be teleported
    public static void setTeleportCoordinates(){
        for(Teleporter teleporter : teleporters){
            if(!teleporter.isVisited()){
                currI = teleporter.getXLocation();
                currJ = teleporter.getYLocation();
            }
        }
    }
    
    // Setting the directions
    public static void south(){
        if(!inverter){
            if(isAvailable(map[currI+1][currJ])){
                currI++;
                currentState = 3;
            }else if(isAvailable(map[currI][currJ+1])){
                currJ++;
                currentState = 2;
            }else if(isAvailable(map[currI-1][currJ])){
                currI--;
                currentState = 1;
            }else{
                currJ--;
                currentState = 4;
            }
        }else{
            if(isAvailable(map[currI+1][currJ])){
                currI++;
                currentState = 3;
            }else if(isAvailable(map[currI][currJ-1])){
                currJ--;
                currentState = 4;
            }else if(isAvailable(map[currI-1][currJ])){
                currI--;
                currentState = 1;
            }else{
                currJ++;
                currentState = 2;
            }
        }
    }
    
    public static void east(){
        if(!inverter){
            if(isAvailable(map[currI][currJ+1])){
                currJ++;
                currentState = 2;
            }else if(isAvailable(map[currI+1][currJ])){
                currI++;
                currentState = 3;
            }else if(isAvailable(map[currI-1][currJ])){
                currI--;
                currentState = 1;
            }else{
                currJ--;
                currentState = 4;
            }
        }else{
            if(isAvailable(map[currI][currJ+1])){
                currJ++;
                currentState = 2;
            }else if(isAvailable(map[currI][currJ-1])){
                currJ--;
                currentState = 4;
            }else if(isAvailable(map[currI-1][currJ])){
                currI--;
                currentState = 1;
            }else{
                currI++;
                currentState = 3;
            }
        }
    }
    
    public static void west(){
        if(!inverter){
            if(isAvailable(map[currI][currJ-1])){
                currJ--;
                currentState = 4;
            }else if(isAvailable(map[currI+1][currJ])){
                currI++;
                currentState = 3;
            }else if(isAvailable(map[currI][currJ+1])){
                currJ++;
                currentState = 2;
            }else{
                currI--;
                currentState = 1;
            }
        }else{
            if(isAvailable(map[currI][currJ-1])){
                currJ--;
                currentState = 4;
            }else if(isAvailable(map[currI-1][currJ])){
                currI--;
                currentState = 1;
            }else if(isAvailable(map[currI][currJ+1])){
                currJ++;
                currentState = 2;
            }else if(isAvailable(map[currI+1][currJ])){
                currI++;
                currentState = 3;
            }
        }
    }
    
    public static void north(){
        if(!inverter){
            if(isAvailable(map[currI-1][currJ])){
                currI--;
                currentState = 1;
            }else if(isAvailable(map[currI+1][currJ])){
                currI++;
                currentState = 3;
            }else if(isAvailable(map[currI][currJ+1])){
                currJ++;
                currentState = 2;
            }else if(isAvailable(map[currI][currJ-1])){
                currJ--;
                currentState = 4;
            } 
        }else{
            if(isAvailable(map[currI-1][currJ])){
                currI--;
                currentState = 1;
            }else if(isAvailable(map[currI][currJ-1])){
                currJ--;
                currentState = 4;
            }else if(isAvailable(map[currI][currJ+1])){
                currJ++;
                currentState = 2;
            }else if(isAvailable(map[currI+1][currJ])){
                currI++;
                currentState = 3;
            }
        }
    }
    
    // Checking if the next position is available
    public static boolean isAvailable(char c){
        if(c == '#')
            return false;
        if(c == 'X')
            if(breaker){
               return true;
            }else
                return false;  
        return true;
    }
    
    // Choosing what direction to take
    public static void currState(int state){
        switch(state){
            case 1 : north();
            break;
            case 2 : east();
            break;
            case 3 : south();
            break;
            case 4 : west();
            break;
        }
    }
    
    // Traverse the map
    public static void traverse(char c){
        if(c == '$') return;
        switch(c){
            case '@' : south();
            break;
            case ' ' : currState(currentState);
            break;
            case 'E' : east();
            break;
            case 'N' : north();
            break;
            case 'S' : south();
            break;
            case 'W' : west();
            break;
            case 'B' : if(breaker)
                            breaker = false;
                        else
                            breaker = true;
                       currState(currentState);
            break;
            case 'X' :  if(breaker){
                            map[currI][currJ] = ' ';
                        }
                        currState(currentState);
            break;
            case '#' : currState(currentState);
            break;
            case 'I' : if(inverter)
                            inverter = false;
                        else
                            inverter = true;
                        currState(currentState);
            break;
            case 'T' :  for(Teleporter teleporter : teleporters){
                            if(currI == teleporter.getXLocation() && currJ == teleporter.getYLocation()){
                                teleporter.setVisited(true);                            
                            }
                        }
                        setTeleportCoordinates();
                        currState(currentState);
            break;
                        
        }
        
        list.add(new Location(currI,currJ,inverter,breaker,currentState));
        String location = currI + "" + currJ;
        
        if(isLoop.contains(location)){
            locationCount++;
            if(getLocation(location).isInverter() == list.get(h).isInverter() && getLocation(location).isBreaker() == list.get(h).isBreaker() && locationCount > 2 * isLoop.size()){
                System.out.println("LOOP");
                loop = true;
                return;
            }
        }
        isLoop.add(location);
        
        h++;
        traverse(map[currI][currJ]);
    }
    
    
    public static Location getLocation(String location){
        for(Location currLocation : list){
            if(currLocation.getLocation().equals(location)){
                return currLocation;
            }
        }
        return null;
    }
    
    // Print the certain position
    public static void printState(int state){
        switch(state){
            case 1 : System.out.println("NORTH");
            break;
            case 2 : System.out.println("EAST");
            break;
            case 3 : System.out.println("SOUTH");
            break;
            case 4 : System.out.println("WEST");
            break;
        }
    }
    
}
