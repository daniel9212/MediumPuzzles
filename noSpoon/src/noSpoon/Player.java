package noSpoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); 
        int height = in.nextInt(); 
        if (in.hasNextLine()) {
            in.nextLine();
        }
        
        
        String line;
        Point aux = new Point(-1,-1);
        Point[] points;
        List<Point[]> lines = new ArrayList<Point[]>(); 
        
        int j = 0;
        while(j < height){
            points = new Point[width];
            line = in.nextLine();
            
            int i = width-1;
            boolean flag = false;
            while(i >= 0){
                if(line.charAt(i) == '0'){
                    points[i] = new Point(i,j);
                    if(!flag){
                        points[i].setRight(new Point(-1,-1));
                        aux = points[i];
                        flag = true;
                    }else{
                        points[i].setRight(aux);
                        aux = points[i];
                    }
                }else{
                    points[i] = new Point(-1,-1);
                }
                
                i--;
            }
            lines.add(points);
            j++;
        }
        
        
        int k = 0;
        while(k < width){
            int h = height-1;
            boolean steag = false;
            while(h >= 0){
                if(!(lines.get(h)[k].getX() == -1)){
                    if(!steag){
                        aux = lines.get(h)[k];
                        lines.get(h)[k].setBottom(new Point(-1,-1));
                        steag = true;
                        
                        System.out.println(lines.get(h)[k]);
                    }else{
                        lines.get(h)[k].setBottom(aux);
                        aux = lines.get(h)[k];
                        System.out.println(lines.get(h)[k]);
                    }
                }
                
                h--;
            }
            k++;
        }

    }
}
