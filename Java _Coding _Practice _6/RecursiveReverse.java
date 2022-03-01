public class RecursiveReverse{
	public String reverse(String str){
		if(str.isEmpty()){
			return str;
		}else if(str.length() == 1){
			return str;
		}else{
			return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
		}
	}
	/*public String reverse1(String str){
		if(str.isEmpty()){
			return str;
		}else if(str.length() <= 1){
			return str;
		}else{
			return reverse(str.substring(1)) + str.charAt(0);
		}
	}*/
}