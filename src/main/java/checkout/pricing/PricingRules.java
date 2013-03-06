package checkout.pricing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PricingRules {
	
	private Map<Character, Price> pricingRules = new HashMap<Character, Price>();

	public void add(char c, Price price) {
		pricingRules.put(c, price);
	}

	public Price getPricingRule(char itemId) {
		return pricingRules.get(itemId);
	}
	
	HashSet<Price> getPricingRules() {
		return new HashSet<Price>(pricingRules.values());
	}	
}