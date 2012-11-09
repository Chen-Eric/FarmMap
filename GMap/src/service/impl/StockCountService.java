/**
 * 
 */
package service.impl;

import java.util.List;

import dao.impl.StockCountDAO;
import domain.Grazing;
import domain.StockType;
import domain.StockCount;
import domain.StockCountId;
import service.IStockCountService;

/**
 * @author Chen
 *
 */
public class StockCountService implements IStockCountService {

	private StockCountDAO stockcountDAO;
	
	public StockCountDAO getStockcountDAO() {
		return stockcountDAO;
	}

	public void setStockcountDAO(StockCountDAO stockCountDAO) {
		this.stockcountDAO = stockCountDAO;
	}

	/* (non-Javadoc)
	 * @see service.IStockcountService#addStockCount()
	 */
	@Override
	public void addStockCount(StockCount stockCount) {
		stockcountDAO.save(stockCount);
	}

	/* (non-Javadoc)
	 * @see service.IStockcountService#deleteStockCount()
	 */
	@Override
	public void deleteStockCount(StockCount stockCount) {
		stockcountDAO.delete(stockCount);
	}

	/* (non-Javadoc)
	 * @see service.IStockcountService#updateStockCount()
	 */
	@Override
	public void updateStockCount(StockCount stockCount) {
		stockcountDAO.updateStockCount(stockCount);
	}

	/* (non-Javadoc)
	 * @see service.IStockcountService#listtStockcountsByStockType(domain.StockType)
	 */
	@Override
	public List<StockCount> listtStockcountsByStockType(short stockTypeId) {
		StockCount stockCount = new StockCount();
		StockCountId stockCountId = new StockCountId();
		stockCountId.setStockTypeSId(stockTypeId);
		stockCount.setId(stockCountId);
		return stockcountDAO.findByExample(stockCount);
	}

	/* (non-Javadoc)
	 * @see service.IStockcountService#listStockcountsByGrazingId(domain.Grazing)
	 */
	@Override
	public List<StockCount> listStockcountsByGrazingId(short grazingId) {
		StockCount stockCount = new StockCount();
		StockCountId stockCountId = new StockCountId();
		stockCountId.setGrazingGId((int) grazingId);
		stockCount.setId(stockCountId);
		return stockcountDAO.findByExample(stockCount);
	}

}
