package ecommerce.model;

public class ProductFood extends Product {

	private boolean vegetary;
	private boolean light;
	private int calories;
	private int percentageProtein;
	private String name;
	
	public ProductFood(int id, int category, String name, String brand, float price, int stockQuantity, boolean vegetary, boolean light, int calories, int percentageProtein) {
		super(id, category, name, brand, price, stockQuantity);
		this.name = name;
		this.vegetary = vegetary;
		this.light = light;
		this.calories = calories;
		this.percentageProtein = percentageProtein;
	}

	public boolean isVegetary() {
		return vegetary;
	}

	public void setVegetary(boolean vegetary) {
		this.vegetary = vegetary;
	}

	public boolean isLight() {
		return light;
	}

	public void setLight(boolean light) {
		this.light = light;
	}

	public float getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getPercentageProtein() {
		return percentageProtein;
	}

	public void setPercentageProtein(int percentageProtein) {
		this.percentageProtein = percentageProtein;
	}
	
	@Override
	public void viewProductDetails() {
		String light = "";
		String vegetary = "";

		
		if(this.light) 
			light = "Sim";
		else
			light = "Não";
		
		
		if(this.vegetary) 
			vegetary = "Sim";
		else
			vegetary = "Não";
		
		
		super.viewProductDetails();
		System.out.println();
		System.out.println("Descrição Técnica (" + name + ")");
		System.out.println("---------------------------------------------");
		System.out.println("Calorias: " + calories + "kcl");
		System.out.println("Proteína: " + percentageProtein + "%");
		System.out.println("Light: " + light);
		System.out.println("Vegetariano: " + vegetary);		
	}
	
	 
	
}
