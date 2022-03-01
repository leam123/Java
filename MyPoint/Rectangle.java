public class Rectangle{
    MyPoint p1;
    MyPoint p2;
    private int p3;
    private int p4;
    public Rectangle(){}
    public Rectangle(MyPoint p1, MyPoint p2, int p3, int p4){
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }
    public int getLength(){
        return p3;
    }
    public int getWidth(){
        return p4;
    }
    public void setP3(int p3){
        this.p3 = p2.getX()-p1.getX(); 
    }
    public void setP4(int p4){
        this.p4 = p2.getY()-p1.getY(); 
    }
    public double calculateArea(){
        return getLength()*getWidth();
    }
    public double calculatePerimeter(){
        return (2*getLength())+(2*getWidth());
    }
    public String toString(){
        return "Length: " + getLength() + "\nWidth:" + getWidth() + "\nArea: " + calculateArea() + "\nPerimeter: " + calculatePerimeter();
    }
    
}