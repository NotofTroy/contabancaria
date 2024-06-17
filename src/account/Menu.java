package account;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import account.util.Colors;

import account.model.CheckingAccount;
import account.model.SavingsAccount;


public class Menu {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int option;
		
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
				
				keyPress();
				break;
				
			case 2:
				System.out.println(Colors.TEXT_WHITE + "\nListar todas as Contas");
				
				keyPress();
                break;
                
			case 3:
				System.out.println(Colors.TEXT_WHITE + "\nConsultar dados da Conta - por número");
				
				keyPress();
                break;
                
			case 4:
				System.out.println(Colors.TEXT_WHITE + "\nAtualizar dados da Conta");
				
				keyPress();
                break;
                
			case 5:
				System.out.println(Colors.TEXT_WHITE + "\nApagar a Conta");
				
				keyPress();
               	break;
               	
			case 6:
				System.out.println(Colors.TEXT_WHITE + "\nSaque");
				
				keyPress();
               	break;
               	
			case 7:
				System.out.println(Colors.TEXT_WHITE + "\nDepósito");
				
				keyPress();
                break;
                
			case 8:
				System.out.println(Colors.TEXT_WHITE + "\nTransferência entre Contas");
				
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
