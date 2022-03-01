
public class Student extends Person{
    private int year;
    private String course;
    
    public Student(){}
    public Student(String name, int age, int year, String course){
        super(name,age); //always in the first part
        this.year=year;
        this.course=course;
    }
    public int getYear(){
        return year;
    }
    public String getCourse(){
        return course;
    }
    public void setYear(int year){
        this.year=year;
    }
    public void setCourse(String course){
        this.course=course;
    }
    public boolean equals(Object obj){
       if(obj instanceof Student)
            return true;
       else
            return false;
    }
    public String toString(){
        return super.toString() + "\nYear: " + getYear() + "\nCourse: " + getCourse();
    }
}