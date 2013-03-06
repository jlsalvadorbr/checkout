package checkout.pricing;

public class UnitPricingStrategy implements PricingStrategy {
	
	private Price price;
	
	public UnitPricingStrategy(Price price) {
		this.price = price;
	}

	public int getPrice() {
		return price.getUnitPrice();
	}

}
