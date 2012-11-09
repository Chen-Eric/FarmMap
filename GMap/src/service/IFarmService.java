package service;

import java.util.List;

import domain.Farm;

/**
 * @author Chen
 *
 */
public interface IFarmService {
	
	public void addFarm(String fName);
	
	public void deleteFarm(short farmId);
	
	public void updateFarm(Farm farm);
	
	public List<Farm> listFarms();
	
	public Farm findFarmById(short id);
	
}
