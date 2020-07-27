package BankingProject;

import java.util.Scanner;

interface ICurrentAccouunt
{
	static int initialamount=10000;

	
	default public void ICurrentAccount()
	{
		
	}
		
	int diposit(int initialbalance, int depositamount);
	
	int withdraw(int initialbalance, int withdrawamount );
	
	int balance(int initialbalance);
	
}

interface ISavingAccount
{
	default public void ISavingAccount()
	{
		
	}
	
	int sa_diposit(int initialbalance, int depositamount);
	
	int sa_withdraw(int initialbalance, int withdrawamount);
	
	int sa_balance(int initialbalance);
	
}

class  BankAccount implements ICurrentAccouunt,ISavingAccount
{
	private static int withdrawn_amount =0;
	private final int limit = 5000;
	private static int  limit_left;

	public int currentaccountdisplay()
	{
		System.out.println("Choose your response in CurrentAccount\n 1.Diposit\n 2.Withdraw\n 3.Balance");
		Scanner sc = new Scanner(System.in);
	    int choice = sc.nextInt();
	    return choice;      
	}
	
	public int savingaccountdisplay()
	{
		System.out.println("Choose your response in SavingAccount\n 1.Diposit\n 2.Withdraw\n 3.Balance");
		Scanner sc = new Scanner(System.in);
	    int choice = sc.nextInt();
	    return choice;
	}

	@Override
	public int diposit(int initialbalance, int dipamount) {
		  int dipositedamount=initialbalance+dipamount;
		  return dipositedamount;
		
	}

	@Override
	public int withdraw(int initialbalance, int withdrawamount) {
		if(withdrawamount<initialbalance)
		{
		   int finalamount=initialbalance - withdrawamount;
		   return finalamount;
		}
		else
			System.out.println("Insufficient Balance");
		   return initialbalance;
		
	}

	@Override
	public int balance(int initialbalance) {
		
		return initialbalance;
		
	}

	@Override
	public int sa_diposit(int initialbalance, int dipamount) {
		int dipositedamount=initialbalance+dipamount;
		  return dipositedamount;		
	}

	@Override
	public int sa_withdraw(int initialbalance, int withdrawamount) {
          withdrawn_amount = withdrawn_amount + withdrawamount;
         if(withdrawn_amount<=5000 && withdrawamount<=5000)
         {
		   int finalamount=initialbalance - withdrawamount;
		   limit_left = limit-withdrawn_amount;
		   return finalamount;
         }
         else
          System.out.println("Withdraw Attempt Failed. \nThe amount you want to withdraw exceeds your withdrawal limit .");
         System.out.println("amount that can be withdrawn : " + limit_left);
         withdrawn_amount = withdrawamount;
         return initialbalance;
	}

	@Override
	public int sa_balance(int initialbalance) {
		
		return initialbalance;
	}
}



public class OnlineBanking {
	static int option1;
	static int option2;
	static int ca_initialbalance= 10000;
	static int sa_initialbalance=10000;
	
	static Scanner scan = new Scanner(System.in); 
	  int response = scan.nextInt();
	public static void main(String[] args)
	{
	  
	  System.out.println("-------------Welcome to OnlineBanking------------");
	  display();
	}
	
public static void display()
	{
		BankAccount bank = new BankAccount();
	  System.out.println(" Choose your response\n 1.Current Account\n 2.Saving Account ");
	  
	  int response = scan.nextInt();
	  
	  
	if(response == 1)
	{
	    option1 = bank.currentaccountdisplay();
	    aditionaldisplay(option1);
	}
	  else if(response==2)
	  {	  
	    option2 =  bank.savingaccountdisplay();
	    sa_aditionaldisplay(option2);
	}
	    
	  else
		  System.err.println("please enter a valid option");
	      display();
	
	
	}
	
public static void aditionaldisplay(int option1)
	{
		BankAccount bank = new BankAccount();
		
     if(option1==1)
     {
    	 System.out.println("enter the amount to be deposited");
         int dipamount = scan.nextInt(); 
    	 int dipositedamount = bank.diposit(ca_initialbalance,dipamount);
    	 ca_initialbalance=dipositedamount;
    	 System.out.println("Amount after deposition : " + dipositedamount);
     }
     else if(option1==2)
     {
    	 System.out.println("enter the amount to be withdrawed");
         int withdrawamount = scan.nextInt(); 
	     int finalamount = bank.withdraw(ca_initialbalance,withdrawamount);
	     ca_initialbalance=finalamount;
	     System.out.println("Amount after withdrawal : " + finalamount);
     }
     else if(option1==3)
     {
	     
	     System.out.println("Balance : " + ca_initialbalance );
    	 
     }
     else
     {
    	 System.err.println("Enter a valid option");
         //bank.currentaccountdisplay();
    	 int validoption = scan.nextInt();
    	 aditionaldisplay(validoption);
     }
         
     System.out.println("Would you like to go to main menu?\n 1.yes continue \n 2.no exit");
	  int finalresponse = scan.nextInt();
	  
	  if(finalresponse ==1)
		  display();
	  else 
		  System.out.println("ThankYou");
	  
	}
	
public static void sa_aditionaldisplay(int option)
	{
		BankAccount bank = new BankAccount();
		
		
	
     if(option==1)
     {
    	 System.out.println("enter the amount to be deposited");
         int dipamount = scan.nextInt(); 
    	 int dipositedamount = bank.sa_diposit(sa_initialbalance,dipamount);
    	 sa_initialbalance=dipositedamount;
    	 System.out.println("Amount after deposition : " + dipositedamount);
     }
     else if(option==2)
     {
    	 System.out.println("enter the amount to be withdrawed");
         int withdrawamount = scan.nextInt(); 
	     int finalamount = bank.sa_withdraw(sa_initialbalance,withdrawamount);
	     sa_initialbalance=finalamount;
	     System.out.println("Amount after withdrawal : " + finalamount);
     }
     else if(option==3)
     {
	     
	     System.out.println("Balance : " + sa_initialbalance );
    	 
     }
     else
     {
    	 System.err.println("Enter a valid option");
    	 int validoption = scan.nextInt();
    	 sa_aditionaldisplay(validoption);
     }
         
	 System.out.println("Would you like to go to main menu?\n 1.yes continue \n 2.no exit");
	  int finalresponse = scan.nextInt();
	  
	  if(finalresponse ==1)
		  display();
	  else 
		  System.out.println("ThankYou");
	  
	}
	}


