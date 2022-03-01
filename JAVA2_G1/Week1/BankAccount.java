/**
** Account class
** @author LFeliz
** @date November 13, 2019
**/

public class BankAccount{
   private String name;
   private float balance;

   public BankAccount(String name, float balance){
	   this.name=name;
	   this.balance=balance;
   }

   public boolean withdraw(float amount)throws AccountException{
	   boolean ok=false;
	   if (amount<=balance){
		   ok=true;
		   balance-=amount;
	   }
	   else
	       throw new AccountException("Insufficient funds...");
	   return ok;
   }
//design a deposit method that throws negative amount not accepted
  public boolean deposit(float amount)throws AccountException{
  	   boolean ok=false;
  	   if (amount>=0){
  		   ok=true;
  		   balance+=amount;
  	   }
  	   else
  	       throw new AccountException("negative amount not accepted...");
  	   return ok;
   }

   public String toString(){
	   return "name: "+name+"\nbalance:"+ balance;
   }

}