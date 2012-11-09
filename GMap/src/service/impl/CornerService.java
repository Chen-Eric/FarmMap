/**
 * 
 */
package service.impl;

import java.util.List;

import dao.ICornerDAO;
import domain.Corner;
import domain.CornerId;
import domain.Farm;
import domain.Paddock;
import domain.PaddockId;
import service.ICornerService;

/**
 * @author Chen
 *
 */
public class CornerService implements ICornerService {

	private ICornerDAO cornerDAO; 
	
	public ICornerDAO getCornerDAO() {
		return cornerDAO;
	}

	public void setCornerDAO(ICornerDAO cornerDAO) {
		this.cornerDAO = cornerDAO;
	}

	/* (non-Javadoc)
	 * @see service.ICornerService#addCorner(domain.Corner)
	 */
	@Override
	public void addCorner(short fid, short pid ,Corner corner) {

		CornerId cornerId = new CornerId();
		cornerId.setPaddockPId(pid);
		cornerId.setPaddockFarmFId(fid);
		corner.setId(cornerId);
		cornerDAO.save(corner);
		System.out.println("CornerDAO: " + corner.getId());
	}

	/* (non-Javadoc)
	 * @see service.ICornerService#deleteCorner(domain.Corner)
	 */
	@Override
	public void deleteCorner(Corner corner) {
		cornerDAO.delete(corner);
	}

	/* (non-Javadoc)
	 * @see service.ICornerService#updateCorner(domain.Corner)
	 */
	@Override
	public void updateCorner(Corner corner) {
		cornerDAO.updateCorner(corner);
	}

	/* (non-Javadoc)
	 * @see service.ICornerService#updateCorner(domain.Corner)
	 */
	@Override
	public List<Corner> listCornersByPaddockId(short farmId, short paddockId) {
		PaddockId pid = new PaddockId(paddockId, farmId);
		Paddock paddock = new Paddock();
		paddock.setId(pid);
		return cornerDAO.findByFarmAndPaddock(paddock);
	}


}
