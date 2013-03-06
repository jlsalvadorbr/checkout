package checkout.pricing;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import checkout.pricing.SpecialPrice;
import checkout.pricing.SpecialPricingStrategy;

public class SpecialPricingStrategyTest {
	
	private static SpecialPrice specialPrice;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		specialPrice = new SpecialPrice(50,3,130);
	}

	@Test
	public void shouldPriceAnItemWithUnitPriceWhenNoMatchingOffer() {
		//given
		SpecialPricingStrategy specialPricingStrategy = new SpecialPricingStrategy(specialPrice,1);
		//then
		assertEquals(50, specialPricingStrategy.getPrice());
	}
	
	@Test
	public void shouldPriceAnItemWithSpecialPriceWhenMatchingOffer() {
		//given
		SpecialPricingStrategy specialPricingStrategy = new SpecialPricingStrategy(specialPrice,2);
		//then
		assertEquals(30, specialPricingStrategy.getPrice());
	}
	
	@Test
	public void shouldPriceAnItemWithUnitPriceAfterOfferIsApplied() {
		//given
		SpecialPricingStrategy specialPricingStrategy = new SpecialPricingStrategy(specialPrice,3);
		//then
		assertEquals(50, specialPricingStrategy.getPrice());
	}	
	
	@Test
	public void shouldPriceAnItemWithSpecialPriceWhenMatchingNewOffers() {
		//given
		SpecialPricingStrategy specialPricingStrategy = new SpecialPricingStrategy(specialPrice,5);
		//then
		assertEquals(30, specialPricingStrategy.getPrice());
	}
}