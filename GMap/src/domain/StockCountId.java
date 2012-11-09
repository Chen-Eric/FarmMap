package domain;
// default package

/**
 * StockCountId entity. @author MyEclipse Persistence Tools
 */

public class StockCountId implements java.io.Serializable {

	// Fields

	private Short stockTypeSId;
	private Integer grazingGId;

	// Constructors

	/** default constructor */
	public StockCountId() {
	}

	/** full constructor */
	public StockCountId(Short stockTypeSId, Integer grazingGId) {
		this.stockTypeSId = stockTypeSId;
		this.grazingGId = grazingGId;
	}

	// Property accessors

	public Short getStockTypeSId() {
		return this.stockTypeSId;
	}

	public void setStockTypeSId(Short stockTypeSId) {
		this.stockTypeSId = stockTypeSId;
	}

	public Integer getGrazingGId() {
		return this.grazingGId;
	}

	public void setGrazingGId(Integer grazingGId) {
		this.grazingGId = grazingGId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StockCountId))
			return false;
		StockCountId castOther = (StockCountId) other;

		return ((this.getStockTypeSId() == castOther.getStockTypeSId()) || (this
				.getStockTypeSId() != null
				&& castOther.getStockTypeSId() != null && this
				.getStockTypeSId().equals(castOther.getStockTypeSId())))
				&& ((this.getGrazingGId() == castOther.getGrazingGId()) || (this
						.getGrazingGId() != null
						&& castOther.getGrazingGId() != null && this
						.getGrazingGId().equals(castOther.getGrazingGId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getStockTypeSId() == null ? 0 : this.getStockTypeSId()
						.hashCode());
		result = 37
				* result
				+ (getGrazingGId() == null ? 0 : this.getGrazingGId()
						.hashCode());
		return result;
	}

}