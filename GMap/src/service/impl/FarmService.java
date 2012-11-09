/**
 * 
 */
package service.impl;

import java.util.List;

import dao.IFarmDAO;
import domain.Farm;
import service.IFarmService;

/**
 * @author Chen
 *
 */
public class FarmService implements IFarmService {

	private IFarmDAO farmDAO;
	
	public IFarmDAO getFarmDAO() {
		return farmDAO;
	}

	public void setFarmDAO(IFarmDAO farmDAO) {
		this.farmDAO = farmDAO;
	}

	/* (non-Javadoc)
	 * @see service.IFarmService#addFarm()
	 */
	@Override
	public void addFarm(String fName) {
		Farm farm = new Farm();
		farm.setFName(fName);
		farmDAO.save(farm);
	}

	/* (non-Javadoc)
	 * @see service.IFarmService#deleteFarm()
	 */
	@Override
	public void deleteFarm(short farmId) {
		Farm farm = farmDAO.findById(farmId);
		farmDAO.delete(farm);
	}

	/* (non-Javadoc)
	 * @see service.IFarmService#updateFarm()
	 */
	@Override
	public void updateFarm(Farm farm) {
		farmDAO.update(farm);
	}

	/* (non-Javadoc)
	 * @see service.IFarmService#listFarms()
	 */
	@Override
	public List<Farm> listFarms() {
		return farmDAO.findAll();
	}

	/* (non-Javadoc)
	 * @see service.IFarmService#findFarmById()
	 */
	@Override
	public Farm findFarmById(short id) {
		return farmDAO.findById(id);
	}

}
