package account.controller;

import java.util.ArrayList;

import account.model.Account;
import account.repository.AccountRepository;
import account.util.Colors;

public class AccountController implements AccountRepository{
	
	private ArrayList<Account> accountList = new ArrayList<Account>();
	int number = 0;

	@Override
	public void searchByNumber(int number) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void listAll() {
		
		for (Account account : accountList) {
			account.view();
		}	
		
	}

	@Override
	public void create(Account account) {
		accountList.add(account);
		System.out.println("\nA conta número " + account.getNumber() + " foi criada com sucesso!");
		
	}

	@Override
	public void update(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int number) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdraw(int number, float value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deposit(int number, float value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transfer(int sourceNumber, int destinationNumber, float value) {
		// TODO Auto-generated method stub
		
	}
	
	public int generateNumber() {
		return ++ number; // ++number
	}
}
