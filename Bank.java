package apt1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Bank
{
	static HashMap<String, Account> CheckingAccountMap;
	static HashMap<String, Account> SavingAccountMap;
	
	Bank()
	{
		CheckingAccountMap = new HashMap<String, Account>();
		SavingAccountMap = new HashMap<String, Account>();
	}
	
    public static void main(String []args)
    {
    	Scanner sc  =  new Scanner(System.in);
    	
    	int choice;
    	
        System.out.print("1. Open a new bank account");
        System.out.print("2. Close a bank account");
        System.out.print("3. Check account balance");
        System.out.print("4. Print Statement");
        System.out.print("5. Make Deposit");
        System.out.print("6. Transfer Amount");
        System.out.print("7. Calculate Zakat");
        System.out.print("8. Make Withdrawal");
        
		System.out.print("\nEnter your choice: ");
		choice = sc.nextInt();
		sc.nextLine();
		
		int accountno = 0;
		
		switch(choice)
		{
			// Open Bank Account
			case 1:
				String name, address, phoneno, accounttype, cnic;

				System.out.print("Enter Account Holder CNIC #: ");
				cnic = sc.nextLine();
				
				System.out.print("Enter Account Holder Name: ");
				name = sc.nextLine();
				
				System.out.print("Enter Account Holder Address: ");
				address = sc.nextLine();
				
				System.out.print("Enter Account Holder Phone #: ");
				phoneno = sc.nextLine();
				
				System.out.print("Enter Account Holder Phone #: ");
				phoneno = sc.nextLine();
				
				System.out.print("Enter Account Type(S: Saving, C: Checking): ");
				accounttype = sc.nextLine();
				
				if(accounttype == "S")
				{
					if(SavingAccountMap.containsKey(cnic))
					{
						System.out.print("You already have a saving account in this bank");
					}
					else
					{
						Account acc = new Account();
						
						accountno = accountno + 1;
						acc.AccountNo = String.valueOf(accountno);
						acc.AccountType = accounttype;
						acc.AccountCreationDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
						acc.cust.CustomerCNIC = cnic;
						acc.cust.Name = name;
						acc.cust.Address = address;
						acc.cust.PhoneNo = phoneno;
						
						SavingAccountMap.put(cnic, acc);
					}
				}
				else if(accounttype == "C")
				{
					if(CheckingAccountMap.containsKey(cnic))
					{
						System.out.print("You already have a checking account in this bank");
					}
					else
					{
						Account acc = new Account();
						
						accountno = accountno + 1;
						acc.AccountNo = String.valueOf(accountno);
						acc.AccountType = accounttype;
						acc.AccountCreationDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
						acc.cust.CustomerCNIC = cnic;
						acc.cust.Name = name;
						acc.cust.Address = address;
						acc.cust.PhoneNo = phoneno;
						
						CheckingAccountMap.put(cnic, acc);
					}
				}

				break;
			
			// Close Bank Account
			case 2:
				String cnic_to_close, account_type;
				
				System.out.print("Enter the CNIC of account holder, whom account you want to close: ");
				cnic_to_close = sc.nextLine();
				
				System.out.print("Enter account type(S: Saving, C: Checking), which you want to close: ");
				account_type = sc.nextLine();
				
				if(account_type == "S")
				{
					SavingAccountMap.remove(cnic_to_close);
				}
				else if(account_type == "C")
				{
					CheckingAccountMap.remove(cnic_to_close);
				}
				
				break;
			
			// Check account balance
			case 3:
				String cnic_balance, account_type_balance;
				
				System.out.print("Enter the CNIC of account holder, whom account you want to close: ");
				cnic_balance = sc.nextLine();
				
				System.out.print("Enter account type(S: Saving, C: Checking), which you want to close: ");
				account_type_balance = sc.nextLine();
				
				if(account_type_balance == "S")
				{
					System.out.print("Account Balance: ");
					System.out.print(SavingAccountMap.get(cnic_balance).account_balance);
				}
				else if(account_type_balance == "C")
				{
					System.out.print("Account Balance: ");
					System.out.print(CheckingAccountMap.get(cnic_balance).account_balance);
				}
				
				break;
			
			// Print Statement
			case 4:
				break;
			
			// Make Deposit
			case 5:
				String cnic_deposit, account_type_deposit;
				double amount_to_deposit;
				
				System.out.print("Enter the CNIC of account holder, in whom account you want to deposit amount: ");
				cnic_deposit = sc.nextLine();
				
				System.out.print("Enter account type(S: Saving, C: Checking), in which you want to deposit amount: ");
				account_type_deposit = sc.nextLine();
				
				System.out.print("Enter the amount which you want to deposit: ");
				amount_to_deposit = sc.nextDouble();
				
				if(account_type_deposit == "S")
				{
					SavingAccountMap.get(cnic_deposit).account_balance = SavingAccountMap.get(cnic_deposit).account_balance + amount_to_deposit;
				}
				else if(account_type_deposit == "C")
				{
					CheckingAccountMap.get(cnic_deposit).account_balance = CheckingAccountMap.get(cnic_deposit).account_balance + amount_to_deposit;
				}
				
				break;
			
			// Transfer Amount
			case 6:
				String from_cnic, to_cnic, from_account_type, to_account_type;
				double amount_to_transfer;
				
				System.out.print("Enter the CNIC of account holder, from which account, you want to transfer amount: ");
				from_cnic = sc.nextLine();
				
				System.out.print("Enter the CNIC of account holder, to which account, you want to transfer amount: ");
				to_cnic = sc.nextLine();
				
				System.out.print("Enter the account type of account, from which you have to transfer amount: ");
				from_account_type = sc.nextLine();
				
				System.out.print("Enter the account type of account, to which you have to transfer amount: ");
				to_account_type = sc.nextLine();
				
				System.out.print("Enter the amout, which you want to transfer: ");
				amount_to_transfer = sc.nextInt();
				
				if(from_account_type == "S")
				{
					SavingAccountMap.get(from_cnic).account_balance = SavingAccountMap.get(from_cnic).account_balance - amount_to_transfer;
					
					if(to_account_type == "S")
					{
						SavingAccountMap.get(to_cnic).account_balance = SavingAccountMap.get(to_cnic).account_balance + amount_to_transfer;
					}
					else if(to_account_type == "C")
					{
						CheckingAccountMap.get(to_cnic).account_balance = CheckingAccountMap.get(to_cnic).account_balance + amount_to_transfer;
					}
				}
				else if(from_account_type == "C")
				{
					CheckingAccountMap.get(from_cnic).account_balance = CheckingAccountMap.get(from_cnic).account_balance - amount_to_transfer;
					
					if(to_account_type == "S")
					{
						SavingAccountMap.get(to_cnic).account_balance = SavingAccountMap.get(to_cnic).account_balance + amount_to_transfer;
					}
					else if(to_account_type == "C")
					{
						CheckingAccountMap.get(to_cnic).account_balance = CheckingAccountMap.get(to_cnic).account_balance + amount_to_transfer;
					}
				}
				
				break;
			
			// Calculate Zakat
			case 7:
				break;
			
			// Make Withdrawal
			case 8:
				String cnic_withdraw, account_type_withdraw;
				double amount_to_withdraw;
				
				System.out.print("Enter the CNIC of account holder, from whom account you want to withdrawal amount: ");
				cnic_withdraw = sc.nextLine();
				
				System.out.print("Enter account type(S: Saving, C: Checking), from which you want to wihdraw amount: ");
				account_type_withdraw = sc.nextLine();
				
				System.out.print("Enter the amount which you want to withdraw: ");
				amount_to_withdraw = sc.nextDouble();
				
				if(account_type_withdraw == "S")
				{
					SavingAccountMap.get(cnic_withdraw).account_balance = SavingAccountMap.get(cnic_withdraw).account_balance - amount_to_withdraw;
				}
				else if(account_type_withdraw == "C")
				{
					CheckingAccountMap.get(cnic_withdraw).account_balance = CheckingAccountMap.get(cnic_withdraw).account_balance - amount_to_withdraw;
				}
				
				break;
				
			default:
				System.out.println("Wrong choice !");
		}
    }
}
