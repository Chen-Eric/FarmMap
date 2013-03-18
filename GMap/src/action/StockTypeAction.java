/**
 * 
 */
package action;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import common.StockTypeAdapter;

import domain.StockType;

/**
 * @author Chen
 *
 */
public class StockTypeAction extends BaseAction{
	
	private int stockTypeID;
	private String stockType;
	private int stockUnit;
	private String selectedStockType;
	private int selectedStockUnit;
	
	private String stocktype;
	
	public int getStockTypeID() {
		return stockTypeID;
	}

	public void setStockTypeID(int stockTypeID) {
		this.stockTypeID = stockTypeID;
	}

	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}

	public int getStockUnit() {
		return stockUnit;
	}

	public void setStockUnit(int stockUnit) {
		this.stockUnit = stockUnit;
	}

	public String getSelectedStockType() {
		return selectedStockType;
	}

	public void setSelectedStockType(String selectedStockType) {
		this.selectedStockType = selectedStockType;
	}

	public int getSelectedStockUnit() {
		return selectedStockUnit;
	}

	public void setSelectedStockUnit(int selectedStockUnit) {
		this.selectedStockUnit = selectedStockUnit;
	}

	
	public String getStocktype() {
		return stocktype;
	}

	public void setStocktype(String stocktype) {
		this.stocktype = stocktype;
	}

	public String showStockTypes(){
		
		List<StockType> lst = stockTypeService.listAllStocks();
		
		session.put("stockTypesFromDB", lst);
		return "show";
	}
	
	public String showStockType(){
		
		StockType st = stockTypeService.findStockTypeBySTID((short) stockTypeID);
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.registerTypeAdapter(StockType.class, new StockTypeAdapter()).create();
		
		this.stocktype = gson.toJson(st);
		return SUCCESS;
	}
	
	public String addStockType(){
		System.out.println("ActionOutPut --- add stock type");
		stockTypeService.addStockType(stockType, stockUnit);
		
		return "add";
	}
	
	public String updateStockType(){
		System.out.println("ActionOutPut --- update stock type");
		if (stockType.equals(null)) {
			stockType = selectedStockType;
		}
		if (Integer.valueOf(stockUnit).equals(null)) {
			stockUnit = selectedStockUnit;
		}
		
		stockTypeService.updateStockType((short) stockTypeID, stockType, stockUnit);
		
		return "update";
	}
	
	public String deleteStockType(){
		System.out.println("ActionOutPut --- delete stock type");
		stockTypeService.deleteStockType((short)stockTypeID);
		return "delete";
	}
	

}
