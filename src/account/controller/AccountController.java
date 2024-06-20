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
		var account = searchCollection(number);
		
		if (account != null) {
			
			if (account.withdraw(value)) {
				
				System.out.println("\nO saque na conta de número " + number + " foi efetuado com sucesso!");
			} 
			
		} else {
			
			System.out.println("\nA conta de número " + number + " não foi encontrada.");
		}
	}

	@Override
	public void deposit(int number, float value) {
		var account = searchCollection(number);
		
		if (account != null) {
			
			account.deposit(value);
			System.out.println("\nO depósito na conta de número " + number + " foi efetuado com sucesso!");
			
		} else {
			
			System.out.println("\nA conta de número " + number + " não foi encontrada, ou a conta de destino não é uma conta corrente.");
		}
	}

	@Override
	public void transfer(int sourceNumber, int destinationNumber, float value) {
		var sourceAccount = searchCollection(sourceNumber);
		var destinationAccount = searchCollection(destinationNumber);
		
		if (sourceAccount != null && destinationAccount != null) {
			
			if (sourceAccount.withdraw(value)) {
				
				destinationAccount.deposit(value);
				System.out.println("\nA transferência da conta de número " + sourceNumber + " para a conta de número " + destinationNumber + " foi feita com sucesso!");
			}
			
			
		} else if (sourceAccount == null) {
			System.out.println("\nA conta de origem, de número " + sourceNumber + ", não foi encontrada!");
			
		} else if (destinationAccount == null) {
			System.out.println("\nA conta de destino, de número " + destinationNumber + ", não foi encontrada!");
		} 
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
