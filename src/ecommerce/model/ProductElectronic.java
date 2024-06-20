package ecommerce.model;

public class ProductElectronic extends Product{

	public boolean bivolt;
	public boolean led;
	public String name;
	public ProductElectronic(int id, int category, String name, String brand, float price, int stockQuantity, boolean bivolt, boolean led) {
		super(id, category, name, brand, price, stockQuantity);
		this.bivolt = bivolt;
		this.led = led;
		this.name = name;
		
	}
	
	public boolean isBivolt() {
		return bivolt;
	}

	public void setBivolt(boolean bivolt) {
		this.bivolt = bivolt;
	}

	public boolean isLed() {
		return led;
	}

	public void setLed(boolean led) {
		this.led = led;
	}
	
	@Override
	public void viewProductDetails() {
		
		String led = "";
		String bivolt = "";

		
		if(this.led) 
		 	led = "Sim";
		else
			led = "Não Possui";
		
		
		if(this.bivolt) 
			bivolt = "Sim";
		else
			bivolt = "Não, apenas uma voltagem";
		
			
		super.viewProductDetails();
		System.err.println();
		System.out.println("Descrição Técnica (" + name + ")");
		System.out.println("---------------------------------------------");
		System.out.println("Led: " + led);
		System.out.println("Bivolt: " + bivolt);

	}

}
