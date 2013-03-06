package checkout.pricing;

import static org.junit.Assert.*;

import org.junit.Test;

import checkout.pricing.Price;
import checkout.pricing.PricingRules;

public class PricingRulesTest {

	@Test
	public void shouldAddPricingRuleToRules() {
		//given
		PricingRules pricingRules = new PricingRules();
		//when
		pricingRules.add('C', new Price(20));
		//then
		assertEquals(1, pricingRules.getPricingRules().size());
		assertTrue(pricingRules.getPricingRules().contains(new Price(20)));
	}
	
	@Test
	public void shouldReturnPricingRuleForItem() {
		//given
		PricingRules pricingRules = new PricingRules();
		//when
		pricingRules.add('C', new Price(20));
		//then
		assertEquals(pricingRules.getPricingRule('C'), new Price(20));
	}
}
