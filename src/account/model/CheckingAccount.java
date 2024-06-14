package account.model;

public class CheckingAccount extends Account{
	
	private float limit;

	public CheckingAccount(int number, int branch, int type, String accountHolder, float balance, float limit) {
		super(number, branch, type, accountHolder, balance);
		this.limit = limit;
	}

	public float getLimit() {
		return limit;
	}

	public void setLimit(float limit) {
		this.limit = limit;
	}
	
	@Override
	public boolean withdraw(float value) {
		
		if (this.getBalance() + this.getLimit() < value) {
			System.out.println("\nSaldo insuficiente!");
			return false;
		}
		
		this.setBalance(this.getBalance() - value);
		return true;
	}
	
	@Override
	public void view() {

		super.view();
		System.out.println("Limite de Crédito: " + this.limit);
	}
}
