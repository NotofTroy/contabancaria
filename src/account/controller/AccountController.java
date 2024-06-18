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
		var account = searchCollection(number);
		
		if (account != null) {
			
			account.view();
			
		} else {
			
			System.out.println("\nA conta de número " + number + " não foi encontrada.");
		}
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
		
		var searchAccount = searchCollection(account.getNumber());
		
		if (searchAccount != null) {
			
			accountList.set(accountList.indexOf(searchAccount), account);
			System.out.println("\nA conta número " + account.getNumber() + " foi atualizada com sucesso!");
			
		} else {
			
			System.out.println("\nA conta de número " + account.getNumber() + " não foi encontrada.");	
		}
	}

	@Override
	public void delete(int number) {
		
		var account = searchCollection(number);
		
		if (account != null) {
			
			if (accountList.remove(account)) {
				System.out.println("\nA conta número " + number + " foi deletada com sucesso!");
			}
			
		} else {
			
			System.out.println("\nA conta de número " + number + " não foi encontrada.");
		}
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
	
	public Account searchCollection (int number) {
		
		for (var account : accountList) {
			if (number == account.getNumber()) {
				return account;
			}
		}
		return null;
	}
}
