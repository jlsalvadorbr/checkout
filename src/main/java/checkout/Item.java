package checkout;

import checkout.pricing.PricingStrategy;

public class Item {
	
	private char itemId;
	private PricingStrategy pricingStrategy;
	
	public Item(char itemId) {
		this.itemId = itemId;
	}

	public int getPrice() {
		return pricingStrategy.getPrice();
	}
	
	public void setPricingStrategy(PricingStrategy pricingStrategy) {
		this.pricingStrategy = pricingStrategy;
	}
}
