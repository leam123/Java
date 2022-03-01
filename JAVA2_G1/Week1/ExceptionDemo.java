/**
** Exception Demo
** @author LFeliz
** @date November 13, 2019
**/
public class ExceptionDemo{
   static public void main(String args[]){
     try{
         int z=9;
         System.out.println(z/0);
         int y[]={1,2,3};
         System.out.println(y[5]);
	 }catch(ArrayIndexOutOfBoundsException a){
		 System.out.println(a);
	 }catch(Exception e){
		 System.out.println(e);
     }
     int z=10;
     System.out.println("I survived... "+z);
   }
}