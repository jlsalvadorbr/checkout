package checkout.pricing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
		assertEquals(new Price(20), pricingRules.getPricingRule('C'));
	}
}
