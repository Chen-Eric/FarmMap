package domain;
// default package

/**
 * StockType entity. @author MyEclipse Persistence Tools
 */

public class StockType implements java.io.Serializable {

	// Fields

	private Short SId;
	private String SType;
	private Integer stockUnits;

	// Constructors

	/** default constructor */
	public StockType() {
	}

	/** full constructor */
	public StockType(String SType, Integer stockUnits) {
		this.SType = SType;
		this.stockUnits = stockUnits;
	}

	// Property accessors

	public Short getSId() {
		return this.SId;
	}

	public void setSId(Short SId) {
		this.SId = SId;
	}

	public String getSType() {
		return this.SType;
	}

	public void setSType(String SType) {
		this.SType = SType;
	}

	public Integer getStockUnits() {
		return this.stockUnits;
	}

	public void setStockUnits(Integer stockUnits) {
		this.stockUnits = stockUnits;
	}

}