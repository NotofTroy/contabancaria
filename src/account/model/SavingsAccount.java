package account.model;

public class SavingsAccount extends Account {
	
	private int anniversary;

	public SavingsAccount(int number, int branch, int type, String accountHolder, float balance, int anniversary) {
		super(number, branch, type, accountHolder, balance);
		this.anniversary = anniversary;
	}

	public int getAnniversary() {
		return anniversary;
	}

	public void setAnniversary(int anniversary) {
		this.anniversary = anniversary;
	}
	
	@Override
	public void view() {
		super.view();
		System.out.println("Aniversário da conta: " + this.anniversary);
	}
	
}
