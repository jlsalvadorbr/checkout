package checkout.pricing;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpecialPriceTest {

	//given
	private SpecialPrice price1 = new SpecialPrice(50,3,130);
	private SpecialPrice price2 = new SpecialPrice(50,3,130);
	private SpecialPrice price3 = new SpecialPrice(30,3,130);
	private SpecialPrice price4 = new SpecialPrice(50,2,130);
	private SpecialPrice price5 = new SpecialPrice(50,3,45);
	
	@Test
	public void shouldBeEqualAndHaveSameHashCodeIfSpecialPriceFieldsAreEqual() throws Exception {
		//then
		assertTrue(price1.equals(price2));
	    assertTrue(price1.hashCode() == price2.hashCode());
	}

	@Test
	public void shouldNotBeEqualIfSpecialPrieceFieldsAreNotEqual() throws Exception {
		//then
		assertFalse(price1.equals(price3));
		assertFalse(price1.equals(price4));
		assertFalse(price1.equals(price5));
	}	
}