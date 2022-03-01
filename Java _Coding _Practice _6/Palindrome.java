public class Palindrome{
	/*public boolean isPal(String msg){
		boolean ok = false;
		String rev = new RecursiveReverse().reverse(msg);
		if(msg.equalsIgnoreCase(rev)){
			ok = true;
		}
		return ok;
	}*/
	public boolean isPalindrome(String str){
		boolean ok = false;
		if(str.isEmpty() || str.length()==1){
			ok = true;
		}else if(Character.toLowerCase(str.charAt(0)) == Character.toLowerCase(str.charAt(str.length() - 1))){
			return isPalindrome(str.substring(1, str.length() - 1));
		}
		return ok;
	}
}