package account.repository;

import account.model.Account;

public interface AccountRepository {
	
	// Account CRUD
	public void searchByNumber(int number);
	public void listAll();
	public void create(Account account);
	public void update(Account account);
	public void delete(int number);
		
	// Banking Methods
	public void withdraw(int number, float value);
	public void deposit(int number, float value);
	public void transfer(int sourceNumber, int destinationNumber, float value);
}
