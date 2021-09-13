package apt1;

public class Account
{
	String AccountNo;
	String AccountType;
	String AccountCreationDate;
	double account_balance;
	Customer cust;
	
	Account()
	{
		AccountNo = "";
		AccountType = "";
		AccountCreationDate = "";
		account_balance = 0.0;
		
		cust = new Customer();
	}
}
