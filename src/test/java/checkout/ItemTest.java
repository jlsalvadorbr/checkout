package checkout;

import org.junit.Test;

import checkout.pricing.PricingStrategy;
import static org.junit.Assert.*;

public class ItemTest {
	
	@Test
	public void shouldPriceAnItemDelegatingToTheAssociatedPriceStrategy() {
		//given
		Item item = new Item('X');
		item.setPricingStrategy(new PricingStrategy() {
			public int getPrice() {
				return 1;
			}
		});
		//when
		int price = item.getPrice();
		//then
		assertEquals(1,price);
	}
}