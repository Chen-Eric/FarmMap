/**
 * 
 */
package service;

import java.util.List;

import domain.Grazing;

/**
 * @author Chen
 *
 */
public interface IGrazingService {
	
	public void addGrazing(Grazing grazing);
	
	public void deleteGrazing(int grazingId);
	
	public void updateGrazing(Grazing grazing);
	
	public List<Grazing> listGrazingsByFarm(short farmId);
	
	public List<Grazing> listGrazingsByPaddock(short farmId, short paddockId);
	
	public List<Grazing> listGrazingsByDateIn(java.util.Date date);
	
	public List<Grazing> listGrazingsByDateOut(java.util.Date date);
	
	public List<Grazing> listGrazingsByNote(String note);
	
	//could be use for both in_date and out_date.
	public List<Grazing> lisGrazingsByFarmAndDate(domain.Farm farm, java.util.Date date);
	
	//could be use for both in_date and out_date.
	public List<Grazing> listGrazingsByPaddockAndDate(domain.Paddock paddock, java.util.Date date);
}