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
			System.out.println(Colors.TEXT_WHITE_BOLD +  "\nNão foi encontrado nenhum produto com o ID (" + id + ")" + Colors.TEXT_RESET);
	
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
		System.out.printf(Colors.TEXT_WHITE_BOLD + "\n\nO produto %s id(%d), foi cadastrado com sucesso!"  + Colors.TEXT_RESET, product.getName(), product.getId());
	}

	@Override
	public void update(Product product) {
		var searchProduct = searchInCollection(product.getId());
		
		if(searchProduct != null) {
			listProducts.set(listProducts.indexOf(searchProduct), product);
			System.out.println(Colors.TEXT_WHITE_BOLD + "\nO produto com o ID (" +  product.getId() + ") foi atualizado com sucesso!\n"  + Colors.TEXT_RESET);
		}else {
			System.out.println(Colors.TEXT_WHITE_BOLD +  "\nNão foi encontrado nenhum produto com o ID (" +  product.getId() + ")" + Colors.TEXT_RESET);
		}

	}

	@Override
	public void delete(int id) {
		var product = searchInCollection(id);
		
		if(product != null) {
			if(listProducts.remove(product) == true)
				System.out.println(Colors.TEXT_WHITE_BOLD + "\nO produto com o ID (" +  id + ") foi removido com sucesso!\n"  + Colors.TEXT_RESET);
		}else 
			System.out.println(Colors.TEXT_WHITE_BOLD +  "\nNão foi encontrado nenhum produto com o ID (" + id + ")" + Colors.TEXT_RESET);
		
	
	}
	
	public Product searchInCollection(int id) {
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
