/**
 * 
 */
package service;

import java.util.List;

import domain.Grazing;
import domain.StockType;
import domain.StockCount;

/**
 * @author Chen
 *
 */
public interface IStockCountService {
	
	public void addStockCount(StockCount stockCount);
	
	public void deleteStockCount(StockCount stockCount);
	
	public void updateStockCount(StockCount stockCount);
	
	public List<StockCount> listtStockcountsByStockType(short stockTypeId);
	
	public List<StockCount> listStockcountsByGrazingId(short grazingId);

}
