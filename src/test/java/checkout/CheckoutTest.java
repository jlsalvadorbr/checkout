package checkout;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import checkout.pricing.Price;
import checkout.pricing.PricingRules;
import checkout.pricing.SpecialPrice;

public class CheckoutTest {
	
	private static PricingRules pricingRules;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//given
		pricingRules = new PricingRules();
		pricingRules.add('A', new SpecialPrice(50,3,130));
		pricingRules.add('B', new SpecialPrice(30,2,45));
		pricingRules.add('C', new Price(20));
		pricingRules.add('D', new Price(15));
	}

	@Test
	public void shouldPriceASingleItemWithUnitPrice() {
		//given
		Checkout checkout = new Checkout(CheckoutTest.pricingRules);
		//when
		checkout.scan('C');
		//then
		assertEquals(20, checkout.getTotalPrice());
	}
	
	@Test
	public void shouldPriceNoItemsAsZero() {
		//given
		Checkout checkout = new Checkout(CheckoutTest.pricingRules);
		//when
		//then
		assertEquals(0, checkout.getTotalPrice());
	}	
	
	@Test
	public void shouldPriceASetOfVariousItemsWithUnitPrice() {
		//given
		Checkout checkout = new Checkout(CheckoutTest.pricingRules);
		//when
		checkout.scan('C');
		checkout.scan('D');
		//then
		assertEquals(35, checkout.getTotalPrice());
	}
	
	@Test
	public void shouldPriceASetOfVariousItemsWithUnitPriceInAnyOrder() {
		//given
		Checkout checkout1 = new Checkout(CheckoutTest.pricingRules);
		Checkout checkout2 = new Checkout(CheckoutTest.pricingRules);
		//when
		checkout1.scan('C');
		checkout1.scan('D');
		checkout2.scan('D');
		checkout2.scan('C');
		//then
		assertEquals(checkout1.getTotalPrice(), checkout2.getTotalPrice());
	}
	
	@Test
	public void shouldPriceASingleItemWithSpecialPriceWhenMatchingOffer() {
		//given
		Checkout checkout = new Checkout(CheckoutTest.pricingRules);
		//when
		checkout.scan('A');
		checkout.scan('A');
		checkout.scan('A');
		//then
		assertEquals(130, checkout.getTotalPrice());
	}	
	
	@Test
	public void shouldPriceASingleItemWithUnitPriceAfterOfferIsApplied() {
		//given
		Checkout checkout = new Checkout(CheckoutTest.pricingRules);
		//when
		checkout.scan('A');
		checkout.scan('A');
		checkout.scan('A');
		checkout.scan('A');
		//then
		assertEquals(180, checkout.getTotalPrice());
	}		
	
	@Test
	public void shouldPriceASingleItemWithSpecialPriceWhenMatchingNewOffers() {
		//given
		Checkout checkout = new Checkout(CheckoutTest.pricingRules);
		//when
		checkout.scan('A');
		checkout.scan('A');
		checkout.scan('A');
		checkout.scan('A');
		checkout.scan('A');
		checkout.scan('A');
		//then
		assertEquals(260, checkout.getTotalPrice());
	}		
	
	@Test
	public void shouldPriceASetOfVariousItemsWithUnitPriceAndSpecialPrice() {
		//given
		Checkout checkout = new Checkout(CheckoutTest.pricingRules);
		//when
		checkout.scan('C');
		checkout.scan('D');
		checkout.scan('A');	checkout.scan('A');	checkout.scan('A');
		checkout.scan('A');
		checkout.scan('B');	checkout.scan('B');
		checkout.scan('B');
		//then
		assertEquals(290, checkout.getTotalPrice());
	}		
	
	@Test
	public void shouldPriceASetOfVariousItemsWithUnitPriceAndSpecialPriceInAnyOrder() {
		
		//Given
		Checkout checkout1 = new Checkout(CheckoutTest.pricingRules);
		Checkout checkout2 = new Checkout(CheckoutTest.pricingRules);
		
		//when
		checkout1.scan('C');
		checkout1.scan('D');
		checkout1.scan('A'); checkout1.scan('A'); checkout1.scan('A');
		checkout1.scan('A');
		checkout1.scan('B'); checkout1.scan('B');
		checkout1.scan('B');

		//Scan same Items in different Order
		checkout2.scan('D');
		checkout2.scan('A');
		checkout2.scan('B');
		checkout2.scan('C');
		checkout2.scan('A');
		checkout2.scan('B');
		checkout2.scan('A');
		checkout2.scan('B');
		checkout2.scan('A');
		
		//then
		assertEquals(checkout1.getTotalPrice(), checkout2.getTotalPrice());
	}		
}