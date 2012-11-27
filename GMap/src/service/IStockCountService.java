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
	
	public void addStockCount(Short stockTypeSId, int grazingGId, String scCount);
	
	public void deleteStockCount(StockCount stockCount);
	
	public void deleteStockCount(short stid, int gid, String scCount);
	
	public void updateStockCount(StockCount stockCount);
	
	public List<StockCount> listtStockcountsByStockType(short stockTypeId);
	
	public List<StockCount> listStockcountsByGrazingId(int grazingId);

}
