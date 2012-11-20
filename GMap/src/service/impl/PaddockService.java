/**
 * 
 */
package service.impl;

import java.util.List;

import dao.IPaddockDAO;
import domain.Farm;
import domain.Paddock;
import domain.PaddockId;
import service.IPaddockService;

/**
 * @author Chen
 * 
 */
public class PaddockService implements IPaddockService {

	private IPaddockDAO paddockDAO;

	public IPaddockDAO getPaddockDAO() {
		return paddockDAO;
	}

	public void setPaddockDAO(IPaddockDAO paddockDAO) {
		this.paddockDAO = paddockDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IPaddockService#addPaddockByFarmId(domain.Paddock)
	 */
	@Override
	public void addPaddockByFarmId(short fid, short pid, String pName,
			Double lat, Double lon, String p_description, short feedCapacity, Double area) {
		PaddockId paddockId = new PaddockId(pid, fid);
		Paddock paddock = new Paddock();
		paddock.setId(paddockId);
		paddock.setPName(pName);
		paddock.setPCenterLat(lat);
		paddock.setPCenterLon(lon);
		paddock.setPDescription(p_description);
		paddock.setPFeedCapacity(feedCapacity);
		paddock.setPArea(area);
		paddockDAO.save(paddock);
	}

	@Override
	public void addPaddockByFarmAndBlockId(Paddock paddock) {
		paddockDAO.save(paddock);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IPaddockService#deletePaddock(domain.Paddock)
	 */
	@Override
	public void deletePaddock(short pid, short fid) {
		PaddockId paddockId = new PaddockId(pid, fid);
		Paddock paddock = new Paddock();
		paddock.setId(paddockId);
		paddockDAO.delete(paddock);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IPaddockService#updatePaddock(domain.Paddock)
	 */
	@Override
	public void updatePaddock(Paddock paddock) {
		paddockDAO.updatePaddock(paddock);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IPaddockService#listPaddocksByFarmId(domain.Farm)
	 */
	@Override
	public List<Paddock> listPaddocksByFarmId(short farmId) {
		return paddockDAO.findByProperty("id.farmFId", farmId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.IPaddockService#listPaddocksByPaddockId(domain.Paddock)
	 */
	@Override
	public List<Paddock> listPaddocksByBlockId(domain.Block block) {
		return paddockDAO.findByProperty("block.Block_B_ID", block);
	}

	@Override
	public boolean findPaddockById(short pid, short fid) {
		PaddockId paddockId = new PaddockId();
		paddockId.setPId(pid);
		paddockId.setFarmFId(fid);
		if (paddockDAO.findById(paddockId) != null) {
			return true;
		} else {
			return false;			
		}

	}

	@Override
	public Paddock findPaddockByFIDandPID(short pid, short fid) {
		PaddockId paddockId = new PaddockId();
		paddockId.setPId(pid);
		paddockId.setFarmFId(fid);
		return paddockDAO.findById(paddockId);
	}

}
