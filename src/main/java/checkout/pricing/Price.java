package checkout.pricing;

public class Price {
	
	private int unitPrice;
	protected boolean multipriced = false;

	public Price(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public boolean isMultipriced() {
		return multipriced;
	}

	public void setMultipriced(boolean multipriced) {
		this.multipriced = multipriced;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + unitPrice;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Price other = (Price) obj;
		if (unitPrice != other.unitPrice)
			return false;
		return true;
	}
}