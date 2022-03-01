public class MyPoint
{
	private int x;
	private int y;
	
	public MyPoint(){}
	public MyPoint(int x, int y){
	    this.x = x;
	    this.y = y;
	}
	public int getX(){
	    return x;
	}
	public int getY(){
	    return y;
	}
	public void setX(int x){
	    this.x = x;
	}
	public void setY(int y){
	    this.y = y;
	}
	public double getDistance(MyPoint p1, MyPoint p2){
	    return  Math.sqrt(Math.pow(p2.getX() - p1.getX(),2)+Math.pow(p2.getY() - p1.getY(),2));
	}
	public String toString(){
	    return "x: " + getX() + "\ny:" + getY();
	}
	
}