public class Employee1 extends Person{
    private int idNum;
    private String position;
    
    public Employee1(){}
    public Employee1(String name, int age, int idNum, String position){
        super(name,age); //always in the first
        this.idNum=idNum;
        this.position=position;
    }
    public int getIdNum(){
        return idNum;
    }
    public String getPosition(){
        return position;
    }
    public void setIdNum(int idNum){
        this.idNum=idNum;
    }
    public void setPosition(String position){
        this.position=position;
    }
    public boolean equals(Object obj){
        if(obj instanceof Employee1)
            return true;
        else
            return false;
    }
    public String toString(){
        return super.toString() + "\nId number: " + getIdNum() + "\nPosition: " + getPosition();
    }
}