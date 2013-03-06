package checkout.pricing;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriceTest {
	
	//given
	private Price price1 = new Price(50);
	private Price price2 = new Price(50);
	private Price price3 = new Price(30);
	
	@Test
	public void shouldBeEqualAndHaveSameHashCodeIfPriceFieldsAreEqual() throws Exception {
		//then
		assertTrue(price1.equals(price2));
	    assertTrue(price1.hashCode() == price2.hashCode());
	}

	@Test
	public void shouldNotBeEqualIfPriceFieldsAreNotEqual() throws Exception {
		//then
		assertFalse(price1.equals(price3));
	}	
}