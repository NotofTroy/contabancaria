package account.model;

public class Account {
	
	private int number;
	private int branch;
	private int type;
	private String accountHolder;
	private float balance;
	
	
	public Account(int number, int branch, int type, String accountHolder, float balance) {
		
		this.number = number;
		this.branch = branch;
		this.type = type;
		this.accountHolder = accountHolder;
		this.balance = balance;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public int getBranch() {
		return branch;
	}


	public void setBranch(int branch) {
		this.branch = branch;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public String getTitular() {
		return accountHolder;
	}


	public void setTitular(String titular) {
		this.accountHolder = titular;
	}


	public float getBalance() {
		return balance;
	}


	public void setBalance(float balance) {
		this.balance = balance;
	}	
	
	public boolean withdraw(float value) {
		
		if (this.getBalance() < value) {
			System.out.println("\nSaldo insuficiente!");
			return false;
		}
		
		this.setBalance(this.getBalance() - value);
		return true;
	}
	
	public void deposit(float value) {
		
		this.setBalance(this.getBalance() + value);
	}
	
	public void view() {

		String typeString = "";
		
		switch(this.type) {
		case 1:
			typeString = "Conta Corrente";
		break;
		
		case 2:
			typeString = "Conta Poupança";
		break;
		
		}
		
		System.out.println("\n\n***********************************************************");
		System.out.println("Dados da Conta:");
		System.out.println("***********************************************************");
		System.out.println("Numero da Conta: " + this.number);
		System.out.println("Agência: " + this.branch);
		System.out.println("Tipo da Conta: " + typeString);
		System.out.println("Titular: " + this.accountHolder);
		System.out.println("Saldo: " + this.balance);

	}
}
