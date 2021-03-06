/**
 * 
 */
package service;

import java.util.List;

import domain.Paddock;


/**
 * @author Chen
 *
 */
public interface IPaddockService {
	
	public void addPaddockByFarmId(short fid, short pid, String pName, Double lat, Double lon, String p_description, short feedCapacity, Double area);
	
	public void addPaddockByFarmAndBlockId(Paddock paddock);
	
	public void deletePaddock(short pid, short fid);
	
	public void updatePaddock(Paddock paddock);
	
	public boolean findPaddockById(short pid, short fid);
	
	public Paddock findPaddockByFIDandPID(short pid, short fid);
	
	public List<Paddock> listPaddocksByFarmId(short farmId);
	
	public List<Paddock> listPaddocksByBlockId(domain.Block paddock);
}
