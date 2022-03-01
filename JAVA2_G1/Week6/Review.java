public class Review{
   public static void main(String args[]){
	   char a='\u0041';//FFFF - 16 bits - unicode
	   char c=65535;//65535
	   char b=66;
	   byte d=127;//-128 to 127
	   /**
	   ** 0000 0000
	   ** 1000 0000
	   ** -128 to 127
	   **
	   **/
	   byte e=-128;
	   System.out.println(a);
	   System.out.println(b);
	   System.out.println(d);
	   System.out.println(e);
   }
}