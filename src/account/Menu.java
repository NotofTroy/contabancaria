package account;

import java.util.Scanner;
import account.util.Colors;

import account.model.Account;
import account.model.CheckingAccount;
import account.model.SavingsAccount;


public class Menu {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int option;
		
		//Account class test
		Account account1 = new Account(1, 123, 1, "Adriana", 10000.0f);
		account1.view();
		account1.withdraw(12000.0f);
		account1.view();
		account1.deposit(5000.0f);
		account1.view();
		
		//CheckingAccount class test
		CheckingAccount checkingAccount1 = new CheckingAccount(2, 123, 1, "Mariana", 15000.0f, 1000.0f);
		checkingAccount1.view();
		checkingAccount1.withdraw(12000.0f);
		checkingAccount1.view();
		checkingAccount1.deposit(5000.0f);
		checkingAccount1.view();
		
		//SavingsAccount class test
		SavingsAccount savingsAccount1 = new SavingsAccount(3, 123, 2, "Victor", 100000.0f, 15);
		savingsAccount1.view();
		savingsAccount1.withdraw(1000.0f);
		savingsAccount1.view();
		savingsAccount1.deposit(5000.0f);
		savingsAccount1.view();

		
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

			option = input.nextInt();
			
			switch (option) {
			case 1:
				System.out.println(Colors.TEXT_WHITE + "Criar Conta\n\n");
			
                		break;
			case 2:
				System.out.println(Colors.TEXT_WHITE + "Listar todas as Contas\n\n");
				
                		break;
			case 3:
				System.out.println(Colors.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");

                		break;
			case 4:
				System.out.println(Colors.TEXT_WHITE + "Atualizar dados da Conta\n\n");
				
                		break;
			case 5:
				System.out.println(Colors.TEXT_WHITE + "Apagar a Conta\n\n");
	
               	 	break;
			case 6:
				System.out.println(Colors.TEXT_WHITE + "Saque\n\n");

               	 	break;
			case 7:
				System.out.println(Colors.TEXT_WHITE + "Depósito\n\n");
				
                		break;
			case 8:
				System.out.println(Colors.TEXT_WHITE + "Transferência entre Contas\n\n");
				
			case 9:
				System.out.println(Colors.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				about();
				input.close();
				System.exit(0);
				break;
				
			default:
				System.out.println(Colors.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Colors.TEXT_RESET);
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
}