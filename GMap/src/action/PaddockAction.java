/**
 * 
 */
package action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import domain.Corner;
import domain.CornerId;
import domain.Paddock;

/**
 * @author Chen
 * 
 */
public class PaddockAction extends BaseAction {

	private String newPaddockCorners;
	private Short farmId;
	private Short selectedPId;
	private double newPaddockCenterLat;
	private double newPaddockCenterLon;
	private String p_description;
	private short feedCapacity;

	public String getNewPaddockCorners() {
		return newPaddockCorners;
	}

	public void setNewPaddockCorners(String newPaddockCorners) {
		this.newPaddockCorners = newPaddockCorners;
	}

	public Short getSelectedPId() {
		return selectedPId;
	}

	public void setSelectedPId(Short selectedPId) {
		this.selectedPId = selectedPId;
	}

	public double getNewPaddockCenterLat() {
		return newPaddockCenterLat;
	}

	public void setNewPaddockCenterLat(double newPaddockCenterLat) {
		this.newPaddockCenterLat = newPaddockCenterLat;
	}

	public double getNewPaddockCenterLon() {
		return newPaddockCenterLon;
	}

	public void setNewPaddockCenterLon(double newPaddockCenterLon) {
		this.newPaddockCenterLon = newPaddockCenterLon;
	}

	public String getP_description() {
		return p_description;
	}

	public void setP_description(String p_description) {
		this.p_description = p_description;
	}

	public short getFeedCapacity() {
		return feedCapacity;
	}

	public void setFeedCapacity(short feedCapacity) {
		this.feedCapacity = feedCapacity;
	}

	/**
	 * @author Chen
	 * @return "showPaddockInfo"
	 */
	public String addPaddock() {

		System.out.println("JsonFromWeb: " + newPaddockCorners);
		System.out.println("CenterLat: " + newPaddockCenterLat);
		System.out.println("CenterLon: " + newPaddockCenterLon);

		Gson gson = new Gson();

		farmId = (Short) session.get("farmId");
		
		short paddockCountRange = 10;
		
		// unserialize the json object of corners.
		List<Corner> lc = gson.fromJson(newPaddockCorners,
				new TypeToken<List<Corner>>() {
				}.getType());
		System.out.println("How many corners: " + lc.size());

		// Creat a new list which is the full-size prototype of all paddocks.
		List pidVavancy = new ArrayList();
		for (short i = 1; i <= paddockCountRange; i++) {
			pidVavancy.add(i);
		}
		
		System.out.println(pidVavancy.size() + "_vacancy!");
		// Compare the current paddock and the ideal paddock list, find out the vacancy.
		List<Paddock> lp = paddockService.listPaddocksByFarmId(farmId);
		System.out.println("lp: " + lp.size());
		if (lp.size() > 0) {
			for (Paddock p : lp) {
				if (pidVavancy.contains(p.getId().getPId())) {
					pidVavancy.remove(p.getId().getPId());
				}
			}
		}
		
		System.out.println("How many paddock vacancy: " + pidVavancy.size());
		
		if (pidVavancy.size() > 0) {
			Short newPid = (Short) pidVavancy.get(0);
			System.out.println("The new Paddock FID : " + farmId);
			System.out.println("The new Paddock PID: " + newPid);
			paddockService.addPaddockByFarmId(farmId, newPid, "f" + farmId
					+ "p" + newPid, newPaddockCenterLat, newPaddockCenterLon,
					null, (short)10);
			for (Corner corner : lc) {
				cornerService.addCorner(farmId, newPid, corner);
			}
		}

		return SUCCESS;
	}

	/**
	 * @author Chen
	 */
	public String deletePaddock() {

		farmId = (Short) session.get("farmId");
		System.out.println("selectedPIdFromPage: " + selectedPId);

		if (farmId != null && selectedPId != null) {
			paddockService.deletePaddock(selectedPId, farmId);
		}

		return SUCCESS;
	}
}
