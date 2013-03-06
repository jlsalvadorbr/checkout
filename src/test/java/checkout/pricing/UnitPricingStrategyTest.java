package checkout.pricing;

import static org.junit.Assert.*;

import org.junit.Test;

import checkout.pricing.Price;
import checkout.pricing.UnitPricingStrategy;

public class UnitPricingStrategyTest {

	@Test
	public void test() {
		//given
		UnitPricingStrategy unitPricingStrategy = new UnitPricingStrategy(new Price(50));
		//then
		assertEquals(50, unitPricingStrategy.getPrice());
	}

}
