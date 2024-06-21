package ecommerce.controller;

import java.util.ArrayList;

import ecommerce.model.Product;
import ecommerce.repository.ProductRepository;
import ecommerce.util.Colors;

public class ProductController implements ProductRepository{
	private ArrayList<Product> listProducts = new ArrayList<Product>();
	int id = 0;
	
	
	@Override
	public void findId(int id) {
		var product = searchInCollection(id);
		
		if(product != null)
			product.viewProductDetails();
		else
			System.out.println(Colors.TEXT_WHITE_BOLD +  "\nNão foi encontrado nenhum produto com o id " + id + Colors.TEXT_RESET);
	}
	
	
	
	@Override
	public void listAll() {
		for (var product : listProducts) {
			product.viewProductDetails();
		}
	}

	@Override
	public void create(Product product) {
		listProducts.add(product);
		System.out.printf("\n\nO produto %s id(%d), foi cadastrado com sucesso!", product.getName(), product.getId());
	}

	@Override
	public void update(Product product) {
		var searchProduct = searchInCollection(product.getId());
		
		if(searchProduct != null) {
			listProducts.set(listProducts.indexOf(searchProduct), product);
			System.out.printf("\nO produto código (%d) foi atualizado com sucesso!\n", product.getId());
		}else {
			System.out.printf("\nO produto com o código (%d) não foi encontrado!\n", product.getId());
		}
	}

	@Override
	public void delete(int id) {
		var product = searchInCollection(id);
		
		if(product != null) {
			if(listProducts.remove(product) == true)
				System.out.printf("\nO produto código (%d) foi removido com sucesso!\n", id);
		}else 
			System.out.printf("\nO produto com o código (%d) não foi encontrado!\n", id);
		
	}
	
	public Product searchInCollection(int numero) {
		for (var product : listProducts) {
			if(product.getId() == id) {
				return product;
			}
				
		}
		
		return null;
	}
	
	public int newId() {
		return ++id;
	}

}
