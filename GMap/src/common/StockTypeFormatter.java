
package common;

import java.io.Serializable;

/**
 * 
 * @author Chen
 */
public class StockTypeFormatter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3337768728120569083L;
	private Short SId;
	private String STypeAndUnit;
	private Integer stockUnits;
	public Short getSId() {
		return SId;
	}
	public void setSId(Short sId) {
		SId = sId;
	}
	public String getSTypeAndUnit() {
		return STypeAndUnit;
	}
	public void setSTypeAndUnit(String sTypeAndUnit) {
		STypeAndUnit = sTypeAndUnit;
	}
	public Integer getStockUnits() {
		return stockUnits;
	}
	public void setStockUnits(Integer stockUnits) {
		this.stockUnits = stockUnits;
	}
	
	/** default constructor */
	public StockTypeFormatter() {
		
	}
	
	/** full constructor */
	public StockTypeFormatter(Short SId, String SType, String Unit) {
		this.SId = SId;
		this.STypeAndUnit = SType + "-" + Unit;
	}
}
