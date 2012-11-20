/**
 * 
 */
package service;

import java.util.List;

import domain.StockType;

/**
 * @author Chen
 *
 */
public interface IStockTypeService {
	
	public void addStockType(StockType stockType);
	
	public void addStockType(String stockType, int stockUnits);
	
	public void deleteStockType(StockType stockType);
	
	public void deleteStockType(short stockTypeID);
	
	public void updateStockType(StockType stockType);
	
	public void updateStockType(short sid, String sType, int sUnit);
	
	public List<StockType> findStockTypeByType(String type);
	
	public List<StockType> listAllStocks();
}
