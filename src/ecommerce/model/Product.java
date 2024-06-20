package ecommerce.model;

public class Product {
	private int id;
	private int category;
	private String name;
	private String brand;
	private float price;
	private int stockQuantity;
	
	public Product(int id, int category, String name, String brand, float price, int stockQuantity) {
		this.id = id;
		this.category = category;
		this.brand = brand;
		this.name = name;
		this.price = price;
		this.stockQuantity = stockQuantity;
	}
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	
	 public void viewProductDetails() {
		 
				String category = "";
				
				switch(this.category) {
					case 1:
						category = "Eletronico";
					break;
					case 2:
						category = "Comida";
					break;
					default:
						category = "Variados";
						break;
				}
				
		 	System.out.printf("""
		 			\n
		 			%s
		 			--------------------------------------------- 
		 			Id: (%d) 
		 			R$%.2f
		 			Marca: %s
		 			Categoria: %s			
		 			%d unidades em estoque
		 			""",name, id, price, brand, category, stockQuantity);	  
	    }

}
