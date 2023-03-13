/**
* Mini Project Title: Atm Interface 
* Name : Aditya Pramod Jadhav
* Enrollment No. : EBEON1222703312
* Batch : 2022-8705
*/

import java.util.Scanner;

class BankAccount {
	
	String name;
	String userName;
	String password;
	String accountNo;
	float balance = 100000f;
	int transactions = 0;
	String transactionHistory = "";
	
	
	
	public void register() {
		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_CYAN = "\u001B[36m";
		final String ANSI_GREEN = "\u001B[32m";
		Scanner sc = new Scanner(System.in);
		System.out.print(ANSI_CYAN+"\nEnter Your Name - "+ANSI_RESET);
		this.name = sc.nextLine();
		System.out.print(ANSI_CYAN+"\nEnter Your Username - "+ANSI_RESET);
		this.userName = sc.nextLine();
		System.out.print(ANSI_CYAN+"\nEnter Your Password - "+ANSI_RESET);
		this.password = sc.nextLine();
		System.out.print(ANSI_CYAN+"\nEnter Your Account Number - "+ANSI_RESET);
		this.accountNo = sc.nextLine();
		System.out.println(ANSI_GREEN+"\nRegistration completed..kindly login"+ANSI_RESET);
	}
	
	public boolean login() {
		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_CYAN = "\u001B[36m";
		 final String ANSI_GREEN = "\u001B[32m";
		final String ANSI_RED = "\u001B[31m";
		boolean isLogin = false;
		Scanner sc = new Scanner(System.in);
		while ( !isLogin ) {
			System.out.print(ANSI_CYAN+"\nEnter Your Username - "+ANSI_RESET);
			String Username = sc.nextLine();
			if ( Username.equals(userName) ) {
				while ( !isLogin ) {
					System.out.print(ANSI_CYAN+"\nEnter Your Password - "+ANSI_RESET);
					String Password = sc.nextLine();
					if ( Password.equals(password) ) {
						System.out.print(ANSI_GREEN+"\nLogin successful!!"+ANSI_RESET);
						isLogin = true;
					}
					else {
						System.out.println(ANSI_RED+"\nIncorrect Password"+ANSI_RESET);
					}
				}
			}
			else {
				System.out.println(ANSI_RED+"\nUsername not found"+ANSI_RESET);
			}
		}
		return isLogin;
	}
	
	public void withdraw() {
		
		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_CYAN = "\u001B[36m";
		final String ANSI_GREEN = "\u001B[32m";
		final String ANSI_RED = "\u001B[31m";
		
		System.out.print(ANSI_CYAN+"\nEnter amount to withdraw - "+ANSI_RESET);
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try {
			
			if ( balance >= amount ) {
				transactions++;
				balance -= amount;
				System.out.println(ANSI_GREEN+"\nWithdraw Successfully"+ANSI_RESET);
				String str = amount + " Rs Withdrawed\n";
				transactionHistory = transactionHistory.concat(str);
				
			}
			else {
				System.out.println(ANSI_RED+"\nInsufficient Balance"+ANSI_RESET);
			}
			
		}
		catch ( Exception e) {
		}
	}
	
	public void deposit() {
		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_CYAN = "\u001B[36m";
		final String ANSI_GREEN = "\u001B[32m";
		final String ANSI_RED = "\u001B[31m";
		
		
		System.out.print(ANSI_CYAN+"\nEnter amount to deposit - "+ANSI_RESET);
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		
		try {
			if ( amount <= 100000f ) {
				transactions++;
				balance += amount;
				System.out.println(ANSI_GREEN+"\nSuccessfully Deposited"+ANSI_RESET);
				String str = amount + " Rs deposited\n";
				transactionHistory = transactionHistory.concat(str);
			}
			else {
				System.out.println(ANSI_RED+"\nSorry...Limit is 100000.00"+ANSI_RESET);
			}
			
		}
		catch ( Exception e) {
		}
	}
	
	public void transfer() {
		final String ANSI_RESET = "\u001B[0m";
		final String ANSI_CYAN = "\u001B[36m";
		final String ANSI_GREEN = "\u001B[32m";
		final String ANSI_RED = "\u001B[31m";
		Scanner sc = new Scanner(System.in);
		System.out.print(ANSI_CYAN+"\nEnter Receipent's Name - "+ANSI_RESET);
		String receipent = sc.nextLine();
		System.out.print(ANSI_CYAN+"\nEnter amount to transfer - "+ANSI_RESET);
		float amount = sc.nextFloat();
		
		try {
			if ( balance >= amount ) {
				if ( amount <= 50000f ) {
					transactions++;
					balance -= amount;
					System.out.println("\nSuccessfully Transfered to " + receipent);
					String str = amount + " Rs transfered to " + receipent + "\n";
					transactionHistory = transactionHistory.concat(str);
				}
				else {
					System.out.println(ANSI_RED+"\nSorry...Limit is 50000.00"+ANSI_RESET);
				}
			}
			else {
				System.out.println(ANSI_RED+"\nInsufficient Balance"+ANSI_RESET);
			}
		}
		catch ( Exception e) {
		}
	}
	
	public void checkBalance() {
		System.out.println("\n" + balance + " Rs");
	}
	
	public void transHistory() {
		if ( transactions == 0 ) {
			System.out.println("\nEmpty");
		}
		else {
			System.out.println("\n" + transactionHistory);
		}
	}
}


public class AtmInterface {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_RED = "\u001B[31m";
	public static int takeIntegerInput(int limit) {
		
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if ( flag && input > limit || input < 1 ) {
					System.out.println("Choose the number between 1 to " + limit);
					flag = false;
				}
			}
			catch ( Exception e ) {
				System.out.println(ANSI_RED+"Enter only integer value"+ANSI_RESET);
				flag = false;
			}
		};
		return input;
	}
	
	
	public static void main(String[] args) {
		   
		System.out.println(ANSI_YELLOW + "\n**********WELCOME TO ADITYA'S ATM SYSTEM**********\n" + ANSI_RESET);
		System.out.println(ANSI_YELLOW+"1.Register \n2.Exit"+ANSI_RESET);
		System.out.print(ANSI_CYAN+"Enter Your Choice - "+ANSI_RESET);
		int choice = takeIntegerInput(2);
		
		if ( choice == 1 ) {
			BankAccount b = new BankAccount();
			b.register();
			while(true) {
				System.out.println(ANSI_YELLOW+"\n1.Login \n2.Exit"+ANSI_RESET);
				System.out.print(ANSI_CYAN+"Enter Your Choice - "+ANSI_RESET);
				int ch = takeIntegerInput(2);
				if ( ch == 1 ) {
					if (b.login()) {
						System.out.println(ANSI_YELLOW+"\n\n**********WELCOME BACK " + b.name + " **********\n"+ANSI_RESET);
						boolean isFinished = false;
						while (!isFinished) {
							System.out.println(ANSI_YELLOW+"\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit"+ANSI_RESET);
							System.out.print(ANSI_CYAN+"\nEnter Your Choice - "+ANSI_RESET);
							int c = takeIntegerInput(6);
							switch(c) {
								case 1:
								b.withdraw();
								break;
								case 2:
								b.deposit();
								break;
								case 3:
								b.transfer();
								break;
								case 4:
								b.checkBalance();
								break;
								case 5:
								b.transHistory();
								break;
								case 6:
								isFinished = true;
								break;
							}
						}
					}
				}
				else {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
		
		
		
	}
}


