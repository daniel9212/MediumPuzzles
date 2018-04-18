package noSpoon;

class Point{
    private int x, y, xR, yR, xB, yB;
    
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){
        return x;
    }
    
    public void setRight(Point pR){
        xR = pR.x;
        yR = pR.y;
    }
    
    public void setBottom(Point pB){
        xB = pB.x;
        yB = pB.y;
    }
    
    public String toString(){
        return x+" "+y+" "+xR+" "+yR+" "+xB+" "+yB;
    }
}
