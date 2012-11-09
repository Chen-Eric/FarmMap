package domain;
// default package

/**
 * StockCount entity. @author MyEclipse Persistence Tools
 */

public class StockCount implements java.io.Serializable {

	// Fields

	private StockCountId id;
	private String scCount;

	// Constructors

	/** default constructor */
	public StockCount() {
	}

	/** full constructor */
	public StockCount(StockCountId id, String scCount) {
		this.id = id;
		this.scCount = scCount;
	}

	// Property accessors

	public StockCountId getId() {
		return this.id;
	}

	public void setId(StockCountId id) {
		this.id = id;
	}

	public String getScCount() {
		return this.scCount;
	}

	public void setScCount(String scCount) {
		this.scCount = scCount;
	}

}