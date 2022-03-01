/**
** Test BankAccount class
** @author LFeliz
** @date November 13, 2019
**/

public class TestBankAccount{
  public static void main(String args[]){
      BankAccount ba1=new BankAccount("Barbie", 1800.75f);
      System.out.println(ba1);
      try{
		  System.out.println("withdraw 1,500 : " + ba1.withdraw(1500));
		  System.out.println(ba1);
		  //System.out.println("withdraw 1,500 : " + ba1.withdraw(1500));
		  //System.out.println(ba1);
		  System.out.println("deposit 1,500 : " + ba1.deposit(1500));
		  System.out.println(ba1);
  		  System.out.println("deposit -1,500 : " + ba1.deposit(-1500));
		  System.out.println(ba1);
      }catch(AccountException ae){
		  //System.out.println(ae);
		  ae.printStackTrace();
	  }
	  System.out.println("Final status: \n" + ba1);
  }
}