package account;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import account.util.Colors;
import account.controller.AccountController;
import account.model.CheckingAccount;
import account.model.SavingsAccount;


public class Menu {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// case tests for AccountController
		AccountController accounts = new AccountController();
		
		System.out.println("\nCriar Contas\n");
		
		CheckingAccount checkingAccount1 = new CheckingAccount(accounts.generateNumber(), 123, 1, "João da Silva", 1000f, 100.0f);
		accounts.create(checkingAccount1);
			
		CheckingAccount checkingAccount2 = new CheckingAccount(accounts.generateNumber(), 124, 1, "Maria da Silva", 2000f, 100.0f);
		accounts.create(checkingAccount2);
		
		SavingsAccount savingsAccount1 = new SavingsAccount(accounts.generateNumber(), 125, 2, "Mariana dos Santos", 4000f, 12);
		accounts.create(savingsAccount1);
		
		SavingsAccount savingsAccount2 = new SavingsAccount(accounts.generateNumber(), 125, 2, "Juliana Ramos", 8000f, 15);
		accounts.create(savingsAccount2);
		
		accounts.listAll();
		
		// input variables
		int option, number, branch, type, anniversary, destinationNumber;
		String accountHolder;
		float balance, limit, value;
		
		
		while (true) {
			System.out.println(Colors.TEXT_YELLOW + Colors.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Colors.TEXT_RESET);
		
			
			try {
				option = input.nextInt();
				
			} catch(InputMismatchException e) {
				
				System.out.println(Colors.TEXT_RED_BOLD + "\nDigite números inteiros!\n" + Colors.TEXT_RESET);
				input.nextLine();
				
				// in the cookbook, there was no call for keyPress() or continue, 
				// it just assigned 0 to option (option = 0).
				// I chose to call keyPress() and continue to the next iteration of while,
				// to avoid the processing of the switch case and its triggering of default.
				keyPress();
				continue;
				
			}
			
			
			switch (option) {
			case 1:
				System.out.println(Colors.TEXT_WHITE + "\nCriar Conta");
				
				System.out.println("Digite o Numero da Agência: ");
				branch = input.nextInt();
				
				System.out.println("Digite o Nome do titular da conta: ");
				input.skip("\\R?");
				accountHolder = input.nextLine();
				
				do {
					
					System.out.println("Digite o tipo da Conta (1-CC ou 2-CP): ");
					type = input.nextInt();
					
				} while(type < 1 && type > 2);
					
				System.out.println("Digite o saldo da Conta (R$): ");
				balance = input.nextFloat();
				
				switch(type) {
				
					case 1 -> {
						System.out.println("Digite o Limite de Crédito (R$): ");
						limit = input.nextFloat();
						accounts.create(new CheckingAccount(accounts.generateNumber(), branch, type, accountHolder, balance, limit));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversario da Conta: ");
						anniversary = input.nextInt();
						accounts.create(new SavingsAccount(accounts.generateNumber(), branch, type, accountHolder, balance, anniversary));
					}
				}
				
				keyPress();
				break;
				
			case 2:
				System.out.println(Colors.TEXT_WHITE + "\nListar todas as Contas");
				accounts.listAll();
				
				keyPress();
                break;
                
			case 3:
				System.out.println(Colors.TEXT_WHITE + "\nConsultar dados da Conta - por número");
				
				System.out.println(Colors.TEXT_WHITE + "\nInsira o número da conta que deseja visualizar.");
				number = input.nextInt();
				accounts.searchByNumber(number);
				
				keyPress();
                break;
                
			case 4:
				System.out.println(Colors.TEXT_WHITE + "\nAtualizar dados da Conta");
				System.out.println(Colors.TEXT_WHITE + "\nInsira o número da conta que deseja atualizar.");
				number = input.nextInt();
				
				var searchAccount = accounts.searchCollection(number);
				
				if (searchAccount != null) {
					
					type = searchAccount.getType();
					
					System.out.println(Colors.TEXT_WHITE + "\nInsira o novo número da agência.");
					branch = input.nextInt();
					
					System.out.println(Colors.TEXT_WHITE + "\nInsira o novo nome do titular.");
					input.skip("\\R?");
					accountHolder = input.nextLine();
					
					System.out.println(Colors.TEXT_WHITE + "\nInsira o novo saldo da conta.");
					balance = input.nextFloat();
					
					switch (type) {
					
						case 1 -> {
							System.out.println(Colors.TEXT_WHITE + "\nInsira o novo limite de crédito.");
							limit = input.nextFloat();
							
							accounts.update(new CheckingAccount(number, branch, type, accountHolder, balance, limit));
						}
						
						case 2 -> {
							System.out.println(Colors.TEXT_WHITE + "\nInsira o novo aniversário da conta.");
							anniversary = input.nextInt();
							
							accounts.update(new SavingsAccount(number, branch, type, accountHolder, balance, anniversary));
						}
						
						default -> {
							System.out.println(Colors.TEXT_WHITE + "\nTipo de conta inválido!");
						}
					}
					
				} else {
					
					System.out.println(Colors.TEXT_WHITE + "\nConta não encontrada!");
				}
				
				keyPress();
                break;
                
			case 5:
				System.out.println(Colors.TEXT_WHITE + "\nApagar a Conta");
				System.out.println(Colors.TEXT_WHITE + "\nInsira o número da conta que deseja apagar.");
				number = input.nextInt();
					
				accounts.delete(number);	
					
				keyPress();
               	break;
               	
			case 6:
				System.out.println(Colors.TEXT_WHITE + "\nSaque");
				System.out.println(Colors.TEXT_WHITE + "\nInsira o número da conta de onde deseja sacar .");
				number = input.nextInt();
				
				do {
					System.out.println(Colors.TEXT_WHITE + "\nInsira o valor do saque (R$).");
					value = input.nextFloat();
					
				} while (value <= 0);
				
				accounts.withdraw(number, value);
				
				keyPress();
               	break;
               	
			case 7:
				System.out.println(Colors.TEXT_WHITE + "\nDepósito");
				System.out.println(Colors.TEXT_WHITE + "\nInsira o número da conta de onde deseja depositar.");
				number = input.nextInt();
				
				do {
					System.out.println(Colors.TEXT_WHITE + "\nInsira o valor do depósito (R$).");
					value = input.nextFloat();
					
				} while (value <= 0);
				
				accounts.deposit(number, value);
				
				keyPress();
                break;
                
			case 8:
				System.out.println(Colors.TEXT_WHITE + "\nTransferência entre Contas");
				System.out.println(Colors.TEXT_WHITE + "\nInsira o número da conta de origem.");
				number = input.nextInt();
				
				System.out.println(Colors.TEXT_WHITE + "\nInsira o número da conta de destino.");
				destinationNumber = input.nextInt();
				
				do {
					System.out.println(Colors.TEXT_WHITE + "\nInsira o valor da transferência (R$).");
					value = input.nextFloat();
					
				} while (value <= 0);
				
				accounts.transfer(number, destinationNumber, value);
				
				keyPress();
				break;
				
			case 9:
				System.out.println(Colors.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				about();
				input.close();
				System.exit(0);
				
				break;
				
			default:
				System.out.println(Colors.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Colors.TEXT_RESET);
				
				keyPress();
				break;
			}
		}
	}
	
	
	public static void about() {
		
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Helena Cristina Souto Fonseca - helenacsfonseca@hotmail.com");
		System.out.println("https://github.com/NotofTroy");
		System.out.println("*********************************************************");
	}
	
	
	public static void keyPress() {

		try {

			System.out.println(Colors.TEXT_RESET + "\nPressione Enter para Continuar.");
			System.in.read();

		} catch (IOException e) {

			System.out.println(Colors.TEXT_RED_BOLD + "\nPressione somente enter" + Colors.TEXT_RESET);
		}
	}
}
