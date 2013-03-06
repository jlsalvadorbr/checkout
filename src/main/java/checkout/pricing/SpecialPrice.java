package checkout.pricing;

public class SpecialPrice extends Price {

	private int numberOfItemsForSpecialPrice;
	private int specialPrice;
	
	public SpecialPrice(int unitPrice, int numberOfItemsForSpecialPrice, int specialPrice) {
		super(unitPrice);
		this.numberOfItemsForSpecialPrice = numberOfItemsForSpecialPrice;
		this.specialPrice = specialPrice;
		this.multipriced = true;
	}

	public int getNumberOfItemsForSpecialPrice() {
		return numberOfItemsForSpecialPrice;
	}

	public int getSpecialPrice() {
		return specialPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + numberOfItemsForSpecialPrice;
		result = prime * result + specialPrice;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpecialPrice other = (SpecialPrice) obj;
		if (numberOfItemsForSpecialPrice != other.numberOfItemsForSpecialPrice)
			return false;
		if (specialPrice != other.specialPrice)
			return false;
		return true;
	}
}