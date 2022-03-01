/**
** Midterm review
** String manipulation
** Strings are immutable
*/
class DecToOthers {
     public static void main(String args[]) {
	     int num = 165;
	     int base = 16;
	     //int num = 10;
	     //int base = 8;
	     //printBase(num, base);
	     printBaseRecursive(num, base);
	     System.out.println();
	     /*char c='\u0041';
	     System.out.println(c);
		 System.out.println((char)(c+1));
		 System.out.println((char)(c+2));*/
		 //System.out.println(c+2);
     }
     static void printBase(int num, int base) {
             int rem = 1, x=1;
             String digits = "0123456789ABCDEF";
             String result = "";
             while (num!=0) {
               rem = num%base;
               num = num/base;
               result = result.concat(digits.charAt(rem)+"");
               //result += digits.charAt(rem);
               //System.out.print(x++ + "result " +result);
             }
             for(int i = result.length()-1; i >= 0; i--) {
               System.out.print(result.charAt(i));
     	     }
     }

      static void printBaseRecursive(int num, int base) {
		     String digits = "0123456789ABCDEF";
		     /* Recursive step*/
		     if (num >= base) {
				 printBaseRecursive(num/base, base);
			 }   /* Base case: num < base */
			 System.out.print(digits.charAt(num%base));
	   }
  }
