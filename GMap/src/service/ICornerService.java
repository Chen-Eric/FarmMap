/**
 * 
 */
package service;

import java.util.List;

import domain.Corner;

/**
 * @author Chen
 *
 */
public interface ICornerService {
	
	public void addCorner(short fid, short pid, Corner corner);
	
	public void deleteCorner(Corner corner);
	
	public void updateCorner(Corner corner);
	
	public List<Corner> listCornersByPaddockId(short farmId, short paddockId);

}
