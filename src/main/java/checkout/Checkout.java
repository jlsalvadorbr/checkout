package checkout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import checkout.pricing.Price;
import checkout.pricing.PricingRules;
import checkout.pricing.PricingStrategy;
import checkout.pricing.SpecialPrice;
import checkout.pricing.SpecialPricingStrategy;
import checkout.pricing.UnitPricingStrategy;

public class Checkout {
	
	private PricingRules pricingRules;
	private int totalPrice = 0;
	private List<Character> scannedItems = new ArrayList<Character>();
	
	public Checkout(PricingRules pricingRules) {
		this.pricingRules = pricingRules;
	}
	
	private PricingStrategy getPricingStrategy(char itemId, Price price) {
		//In case the number of strategies or the complexity to select one grows,
		//a Factory class could be used to decouple this code from the Strategy handling
		if (price.isMultipriced()) {
			return new SpecialPricingStrategy((SpecialPrice)price, getNumberOfPreviousOccurrences(itemId));
		} else {
			return new UnitPricingStrategy(price);
		}
	}

	public void scan(char itemId) {
	
		Price price = pricingRules.getPricingRule(itemId);
		
		Item item = new Item(itemId);
		item.setPricingStrategy(getPricingStrategy(itemId, price));
		
		totalPrice += item.getPrice();
		
		scannedItems.add(itemId);
	}

	private int getNumberOfPreviousOccurrences(char itemId) {
		return Collections.frequency(scannedItems, itemId);
	}

	public int getTotalPrice() {
		return totalPrice;
	}
	
	public static void main(String[] args) {
		
		PricingRules pricingRules = new PricingRules();
		pricingRules.add('A', new SpecialPrice(50,3,130));
		pricingRules.add('B', new SpecialPrice(30,2,45));
		pricingRules.add('C', new Price(20));
		pricingRules.add('D', new Price(15));
		
		Checkout checkout = new Checkout(pricingRules);
		checkout.scan('B');
		checkout.scan('A');
		checkout.scan('B');
		
		System.out.println("Total price: " + checkout.getTotalPrice());
	}	
}