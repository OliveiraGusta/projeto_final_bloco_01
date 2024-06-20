package ecommerce;

import java.util.Scanner;

import ecommerce.model.Product;
import ecommerce.model.ProductFood;
import ecommerce.model.ProductElectronic;

import ecommerce.util.Colors;

public class Menu {

	public static void main(String[] args) {

		//Testar Produto Eletronico
		Product p2 = new ProductElectronic(2, 1, "Notebook", "Samsung", 2500.2f, 123, true, false );
		p2.viewProductDetails();
		
		
		//Testar Produto Alimenticio
		Product p3 = new ProductFood(3, 2, "12 Bananas", "Hortifruti Feliz", 2.0f, 12, true, true, 240, 4);
		p3.viewProductDetails();
		
		Scanner scanner = new Scanner(System.in);

		int option;
		String subTitle =  Colors.TEXT_YELLOW_BOLD + "\nAmazon Go AI - Seu Melhor Serviço de compras por AI!\n" + Colors.TEXT_RESET;
		
		while (true) {

			System.out.printf( """		
			---------------------------------------------
			                                                    
			           %s Amazon Go AI (An Indian) %s
			                                                     
			---------------------------------------------
			                                                     
			            1 - Cadastrar um Produto                          
			            2 - Listar todos os Produtos             
			            3 - Buscar um Produto por ID               
			            4 - Atualizar um Produto            
			            5 - Apagar um Produto                         
   
			            0 - Sair                                
			                                                    
			---------------------------------------------
			Entre com a opção desejada:""", Colors.TEXT_YELLOW_BOLD , Colors.TEXT_RESET);

			option = scanner.nextInt();

			if (option == 0) {
				System.out.println(subTitle);
				about();
				scanner.close();
				System.exit(0);
			}

			switch (option) {
			
				case 1:
					System.out.println(subTitle);
				
					System.out.println("Cadastrar Produto\n\n");
					break;
					
				case 2:
					System.out.println(subTitle);
	
					System.out.println("Listar todas os Produto\n\n");
					break;
				case 3:
					System.out.println(subTitle);
	
					System.out.println("Consultar dados de um Produto - por ID\n\n");
					break;
				case 4:
					System.out.println(subTitle);
	
					System.out.println("Atualizar dados de um Produto\n\n");
					break;
				case 5:
					System.out.println(subTitle);
					
					System.out.println("Apagar um produto\n\n");
					break;
				default:
	
					System.out.println("\nOpção Inválida!\n");
					break;
			}
		}
	}

	public static void about() {
		System.out.println("\n---------------------------------------------");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Gustavo Oliveira - gustavo.oliver456@gmail.com");
		System.out.println("github.com/OliveiraGusta");
		System.out.println("Projeto inspirado em: ");
		System.out.println(Colors.TEXT_YELLOW_BOLD + "AMAZON GO INDIAN" + Colors.TEXT_RESET);
		System.out.println("---------------------------------------------");
	}
}
