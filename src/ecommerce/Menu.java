package ecommerce;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import ecommerce.controller.ProductController;
import ecommerce.model.Product;
import ecommerce.model.ProductFood;
import ecommerce.model.ProductElectronic;

import ecommerce.util.Colors;

public class Menu {

	public static void main(String[] args) {

		ProductController products = new ProductController();

		Scanner scanner = new Scanner(System.in);

		int option = 0, category = 0, id, stockQuantity, calories, percentageProtein;
		float price;
		boolean bivolt, led, vegetary, light;
		String name, brand;
		String subTitle = Colors.TEXT_YELLOW_BOLD + "\nAmazon Go AI - Seu Melhor Serviço de compras por AI!\n"
				+ Colors.TEXT_RESET;

		while (true) {

			System.out.printf("""
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
					Entre com a opção desejada:""", Colors.TEXT_YELLOW_BOLD, Colors.TEXT_RESET);

			try {
				option = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(Colors.TEXT_WHITE_BOLD + "\nDigite valores inteiros!" + Colors.TEXT_RESET);
				scanner.nextLine();
				option = -1;
			}

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

				System.out.printf("Digite o Nome do Produto: ");
				scanner.skip("\\R?");
				name = scanner.nextLine();

				System.out.printf("Digite a marca do Produto: ");
				scanner.skip("\\R?");
				brand = scanner.nextLine();

				do {
					System.out.printf("""
							\nLista Codigos Categoria:
							---------------------------------------------
							1 - Eletronico
							2 - Alimenticio

							Digite o código da Categoria do produto: """);
					category = scanner.nextInt();
				} while (category != 1 && category != 2);

				System.out.printf("\nDigite o Preço do produto R$");
				price = scanner.nextFloat();

				System.out.printf("Quantas unidades do Produto: ");
				scanner.skip("\\R?");
				stockQuantity = scanner.nextInt();

				switch (category) {
				case 1 -> {
					do {
						System.out.printf("""

								Descrição Tecnica
								---------------------------------------------
								Digite 1 - Sim
								Digite 2 - Não

								O produto é Bivolt: """);
						option = scanner.nextInt();

					} while (option != 1 && option != 2);

					if (option == 1)
						bivolt = true;
					else
						bivolt = false;

					do {
						System.out.printf("O produto tem Led: ");
						option = scanner.nextInt();
					} while (option != 1 && option != 2);

					if (option == 1)
						led = true;
					else
						led = false;

					products.create(new ProductElectronic(products.newId(), category, name, brand, price, stockQuantity,
							bivolt, led));
				}

				case 2 -> {
					do {
						System.out.printf("""

								Descrição Tecnica
								---------------------------------------------
								Digite 1 - Sim
								Digite 2 - Não

								O produto é Vegetariano: """);
					} while (option != 1 && option != 2);

					option = scanner.nextInt();
					if (option == 1)
						vegetary = true;
					else
						vegetary = false;
					do {
						System.out.printf("O produto é light: ");
						option = scanner.nextInt();
					} while (option != 1 && option != 2);

					if (option == 1)
						light = true;
					else
						light = false;

					System.out.printf("Quantas calorias o produto tem: ");
					calories = scanner.nextInt();

					System.out.printf("Porcentagem de proteinas no produto: ");
					percentageProtein = scanner.nextInt();

					products.create(new ProductFood(products.newId(), category, name, brand, price, stockQuantity,
							vegetary, light, calories, percentageProtein));
				}
				}

				keyPress();
				break;

			case 2:
				System.out.println(subTitle);
				System.out.println(Colors.TEXT_WHITE_BOLD + " Listagem de todos os Produtos\n\n" + Colors.TEXT_RESET);
				products.listAll();

				keyPress();
				break;
			case 3:
				System.out.println(subTitle);
				System.out.println(
						Colors.TEXT_WHITE_BOLD + "Consultar dados de um Produto - por ID\n\n" + Colors.TEXT_RESET);

				System.out.printf("Digite o ID do produto: ");
				id = scanner.nextInt();
				
				products.findId(id);
				keyPress();
				break;
			case 4:
				System.out.println(subTitle);
				System.out.println(Colors.TEXT_WHITE_BOLD + "Atualizar dados de um Produto\n\n" + Colors.TEXT_RESET);
				
				System.out.printf("Digite o ID do Produto: ");
				id = scanner.nextInt();
				
				var searchProduct = products.searchInCollection(id);
				System.out.println("searchProduct: "+ searchProduct);
				if (searchProduct != null) {
					products.findId(id);

					System.out.println(Colors.TEXT_WHITE_BOLD + "\n\nAtualizar dados do Produto ID (" + id + ")"
							+ Colors.TEXT_RESET);

					System.out.printf("Digite o Nome do Produto: ");
					scanner.skip("\\R?");
					name = scanner.nextLine();

					System.out.printf("Digite a marca do Produto: ");
					scanner.skip("\\R?");
					brand = scanner.nextLine();

					do {
						System.out.printf("""
								\nLista Codigos Categoria:
								---------------------------------------------

								1 - Eletronico
								2 - Alimenticio

								Digite o código da Categoria do produto: """);
						category = scanner.nextInt();
					} while (category != 1 && category != 2);

					System.out.printf("\nDigite o Preço do produto R$");
					price = scanner.nextFloat();

					System.out.printf("Quantas unidades do Produto: ");
					scanner.skip("\\R?");
					stockQuantity = scanner.nextInt();

					switch (category) {
					case 1 -> {
						do {
							System.out.printf("""

									Descrição Tecnica
									---------------------------------------------
									Digite 1 - Sim
									Digite 2 - Não

									O produto é Bivolt: """);
						} while (option != 1 && option != 2);

						option = scanner.nextInt();
						if (option == 1)
							bivolt = true;
						else
							bivolt = false;
						do {
							System.out.printf("O produto tem Led: ");
							option = scanner.nextInt();
						} while (option != 1 && option != 2);

						if (option == 1)
							led = true;
						else
							led = false;

						products.update(
								new ProductElectronic(id, category, name, brand, price, stockQuantity, bivolt, led));
					}

					
					case 2 -> {
						do {
							System.out.printf("""

									Descrição Tecnica
									---------------------------------------------
									Digite 1 - Sim
									Digite 2 - Não

									O produto é Vegetariano: """);

							option = scanner.nextInt();
						} while (option != 1 && option != 2);

						if (option == 1)
							vegetary = true;
						else
							vegetary = false;
						do {
							System.out.printf("O produto é light: ");
							option = scanner.nextInt();
						} while (option != 1 && option != 2);

						if (option == 1)
							light = true;
						else
							light = false;

						System.out.printf("Quantas calorias o produto tem: ");
						calories = scanner.nextInt();

						System.out.printf("Porcentagem de proteinas no produto: ");
						percentageProtein = scanner.nextInt();

						products.update(new ProductFood(id, category, name, brand, price, stockQuantity, vegetary,
								light, calories, percentageProtein));
					}
					default -> {
						System.out.println("Código de Categoria Inválido");
					}
					}

				} else
					System.out.println("\nProduto não encontrado!");

				keyPress();
				break;
			case 5:
				System.out.println(subTitle);

				System.out.println(Colors.TEXT_WHITE_BOLD + "\nApagar um produto\n\n" + Colors.TEXT_RESET);
				System.out.printf("Digite o ID da conta que deseja remover: ");
				id = scanner.nextInt();

				products.delete(id);
				keyPress();
				break;

			default:
				System.out.println(Colors.TEXT_YELLOW_BOLD + "\nOpção Inválida!\n" + Colors.TEXT_RESET);

				keyPress();
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

	public static void keyPress() {
		try {
			System.out.println(Colors.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}

	}
}
