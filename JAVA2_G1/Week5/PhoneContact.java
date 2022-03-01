public class PhoneContact implements Comparable<PhoneContact>{
    private String name;
    private String number;
    public PhoneContact(String name, String number){
       this.name=name;
       this.number=number;
    }
    public String toString(){
       return "Name:"+name +"\nNumber:"+number;
    }
    public boolean equals(Object obj){
	   boolean ok=false;
	   if (obj!=null && obj instanceof PhoneContact){
          PhoneContact pc=(PhoneContact)obj;
          if (pc.name.equals(this.name))
             ok=true;
       }
	   return ok;
    }

    public int compareTo(PhoneContact anotherPhoneContact){
		return compare(this.name, anotherPhoneContact.name);
	}

    public static int compare(String x, String y){
		int len1 = x.length();
		int len2 = y.length();
		int lim = Math.min(len1, len2);
		char v1[] = x.toCharArray();
		char v2[] = y.toCharArray();
		int k = 0;
		while (k < lim) {
			char c1 = v1[k];
			char c2 = v2[k];
			if (c1 != c2)
				return c1 - c2;
			k++;
		}
        return len1 - len2;
	}


/**
 implements Comparable<Integer>

 public int compareTo(Integer anotherInteger) {
        return compare(this.value, anotherInteger.value);
    }

 public static int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }

//String
public int compareTo(String anotherString) {
        int len1 = value.length;
        int len2 = anotherString.value.length;
        int lim = Math.min(len1, len2);
        char v1[] = value;
        char v2[] = anotherString.value;

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }



**/

}