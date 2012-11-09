/**
 * 
 */
package service.impl;

import java.util.List;

import dao.impl.GrazingDAO;
import domain.Farm;
import domain.Grazing;
import domain.Paddock;
import domain.PaddockId;
import service.IGrazingService;

/**
 * @author Chen
 *
 */
public class GrazingService implements IGrazingService {

	private GrazingDAO grazingDAO;
	
	public GrazingDAO getGrazingDAO() {
		return grazingDAO;
	}

	public void setGrazingDAO(GrazingDAO grazingDAO) {
		this.grazingDAO = grazingDAO;
	}

	/* (non-Javadoc)
	 * @see service.IGrazingService#addGrazing(domain.Grazing)
	 */
	@Override
	public void addGrazing(Grazing grazing) {
		grazingDAO.save(grazing);
	}

	/* (non-Javadoc)
	 * @see service.IGrazingService#deleteGrazing(domain.Grazing)
	 */
	@Override
	public void deleteGrazing(int grazingId) {
		Grazing grazing = grazingDAO.findById(grazingId);
		grazingDAO.delete(grazing);
	}

	/* (non-Javadoc)
	 * @see service.IGrazingService#updateGrazing(domain.Grazing)
	 */
	@Override
	public void updateGrazing(Grazing grazing) {
		grazingDAO.updateGrazing(grazing);
	}

	/* (non-Javadoc)
	 * @see service.IGrazingService#listGrazingsByFarmId(domain.Farm)
	 */
	@Override
	public List<Grazing> listGrazingsByFarm(short farmId) {
		Grazing grazing = new Grazing();
		grazing.setPaddockFarmFId(farmId);
		return grazingDAO.findByExample(grazing);
	}

	/* (non-Javadoc)
	 * @see service.IGrazingService#listGrazingsByPaddockId(domain.Paddock)
	 */
	@Override
	public List<Grazing> listGrazingsByPaddock(short farmId, short paddockId) {
		

		Paddock paddock = new Paddock();
		PaddockId pid = new PaddockId();
		pid.setFarmFId(farmId);
		pid.setPId(paddockId);
		paddock.setId(pid);
	
		return grazingDAO.findByFarmAndPaddock(paddock);
	}

	/* (non-Javadoc)
	 * @see service.IGrazingService#listGrazingsByDateIn(java.sql.Date)
	 */
	@Override
	public List<Grazing> listGrazingsByDateIn(java.util.Date date) {
		Grazing grazing = new Grazing();
		grazing.setGDateIn(date);
		return grazingDAO.findByExample(grazing);
	}

	/* (non-Javadoc)
	 * @see service.IGrazingService#listGrazingsByDateOut(java.sql.Date)
	 */
	@Override
	public List<Grazing> listGrazingsByDateOut(java.util.Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see service.IGrazingService#listGrazingsByNote(java.lang.String)
	 */
	@Override
	public List<Grazing> listGrazingsByNote(String note) {
		Grazing grazing = new Grazing();
		grazing.setGNote(note);
		return grazingDAO.findByExample(grazing);
	}

	/* (non-Javadoc)
	 * @see service.IGrazingService#lisGrazingsByFarmAndDate(domain.Farm, java.sql.Date)
	 */
	@Override
	public List<Grazing> lisGrazingsByFarmAndDate(Farm farm, java.util.Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see service.IGrazingService#listGrazingsByPaddockAndDate(domain.Paddock, java.sql.Date)
	 */
	@Override
	public List<Grazing> listGrazingsByPaddockAndDate(Paddock paddock, java.util.Date date) {
		// TODO Auto-generated method stub
		return null;
	}

}
