package checkout.pricing;

public class SpecialPricingStrategy implements PricingStrategy {
	
	private SpecialPrice specialPrice;
	private int numberOfPreviousOccurrences;
	
	public SpecialPricingStrategy(SpecialPrice specialPrice, int numberOfPreviousOccurrences) {
		this.specialPrice = specialPrice;
		this.numberOfPreviousOccurrences = numberOfPreviousOccurrences;
	}
	
	private int getSpecialPrice(SpecialPrice specialPrice, int numberOfPreviousOccurrences) {
		if ((numberOfPreviousOccurrences + 1) % specialPrice.getNumberOfItemsForSpecialPrice() == 0) {
			return specialPrice.getSpecialPrice() - ((specialPrice.getNumberOfItemsForSpecialPrice()-1) * specialPrice.getUnitPrice());
		} else {
			return specialPrice.getUnitPrice();
		}
	}
	
	public int getPrice() {
		return getSpecialPrice(specialPrice, numberOfPreviousOccurrences);
	}

}
