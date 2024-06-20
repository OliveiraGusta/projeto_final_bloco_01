package ecommerce.repository;

import ecommerce.model.Product;

public interface ProductRepository {
	public void findId(int id);
	public void listAll();
	public void create(Product product);
	public void update(Product product);
	public void delete(int id);
}
