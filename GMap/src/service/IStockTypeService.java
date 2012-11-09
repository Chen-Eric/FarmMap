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
	
	public void deleteStockType(StockType stockType);
	
	public void updateStockType(StockType stockType);
	
	public List<StockType> findStockTypeByType(String type);
	
	public List<StockType> listAllStocks();
}
