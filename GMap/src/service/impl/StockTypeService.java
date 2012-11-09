/**
 * 
 */
package service.impl;

import java.util.List;

import dao.impl.StockTypeDAO;
import domain.StockType;
import service.IStockTypeService;

/**
 * @author Chen
 *
 */
public class StockTypeService implements IStockTypeService {

	private StockTypeDAO stockTypeDAO;
	
	public StockTypeDAO getStockTypeDAO() {
		return stockTypeDAO;
	}

	public void setStockTypeDAO(StockTypeDAO stockTypeDAO) {
		this.stockTypeDAO = stockTypeDAO;
	}

	/* (non-Javadoc)
	 * @see service.IStockTypeService#addStockType(domain.StockType)
	 */
	@Override
	public void addStockType(StockType stockType) {
		stockTypeDAO.save(stockType);
	}

	/* (non-Javadoc)
	 * @see service.IStockTypeService#deleteStockType(domain.StockType)
	 */
	@Override
	public void deleteStockType(StockType stockType) {
		stockTypeDAO.delete(stockType);
	}

	/* (non-Javadoc)
	 * @see service.IStockTypeService#updateStockType(domain.StockType)
	 */
	@Override
	public void updateStockType(StockType stockType) {
		// this stocktype need its ID.
		stockTypeDAO.updateStockType(stockType);
	}

	/* (non-Javadoc)
	 * @see service.IStockTypeService#findStockTypeByType()
	 */
	@Override
	public List<StockType> findStockTypeByType(String type) {
		return stockTypeDAO.findBySType(type);
	}

	/* (non-Javadoc)
	 * @see service.IStockTypeService#listAllStocks()
	 */
	@Override
	public List<StockType> listAllStocks() {
		return stockTypeDAO.findAll();
	}

}
