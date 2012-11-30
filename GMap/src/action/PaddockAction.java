/**
 * 
 */
package action;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import common.PaddockAdapter;

import domain.Corner;
import domain.Paddock;
import domain.PaddockId;

/**
 * @author Chen
 * 
 */
@SuppressWarnings("serial")
public class PaddockAction extends BaseAction {

	private String newPaddockCorners;
	private Short farmId;
	private Short selectedPId;
	private String selectedPName;
	private int newPId;
	private String newPName;
	private double newPaddockCenterLat;
	private double newPaddockCenterLon;
	private String PDescription;
	private int PFeedCapacity;
	private Double selectedPArea;
	private Double newPadoockArea;
	private String selectedPaddock;
	
	private String brandNewPaddockID;

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

	public String getSelectedPName() {
		return selectedPName;
	}

	public void setSelectedPName(String selectedPName) {
		this.selectedPName = selectedPName;
	}

	public int getNewPId() {
		return newPId;
	}

	public void setNewPId(int newPId) {
		this.newPId = newPId;
	}

	public String getNewPName() {
		return newPName;
	}

	public void setNewPName(String newPName) {
		this.newPName = newPName;
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

	public String getPDescription() {
		return PDescription;
	}

	public void setPDescription(String pDescription) {
		PDescription = pDescription;
	}

	public int getPFeedCapacity() {
		return PFeedCapacity;
	}

	public void setPFeedCapacity(int pFeedCapacity) {
		PFeedCapacity = pFeedCapacity;
	}

	public Double getSelectedPArea() {
		return selectedPArea;
	}

	public void setSelectedPArea(Double selectedPArea) {
		this.selectedPArea = selectedPArea;
	}

	public Double getNewPadoockArea() {
		return newPadoockArea;
	}

	public void setNewPadoockArea(Double newPadoockArea) {
		this.newPadoockArea = newPadoockArea;
	}

	public String getSelectedPaddock() {
		return selectedPaddock;
	}

	public void setSelectedPaddock(String selectedPaddock) {
		this.selectedPaddock = selectedPaddock;
	}

	public String getBrandNewPaddockID() {
		return brandNewPaddockID;
	}

	public void setBrandNewPaddockID(String brandNewPaddockID) {
		this.brandNewPaddockID = brandNewPaddockID;
	}

	/**
	 * @author Chen
	 */
	public String showSelectedPaddock() {

		farmId = (Short) session.get("farmId");
		System.out.println("selectedPId_In_Paddok_Action: " + selectedPId);

		Paddock singlePaddock = paddockService.findPaddockByFIDandPID(
				selectedPId, farmId);

		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.registerTypeAdapter(Paddock.class,
				new PaddockAdapter()).create();

		this.selectedPaddock = gson.toJson(singlePaddock);
		session.remove("selectedPaddock");
		session.put("singlePaddock", singlePaddock);
		return SUCCESS;
	}

	/**
	 * @author Chen
	 * @return "addPaddock"
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String addPaddock() {

		System.out.println("----New Paddock Arguments Begin---");
		System.out.println("JsonFromWeb: " + newPaddockCorners);
		System.out.println("CenterLat: " + newPaddockCenterLat);
		System.out.println("CenterLon: " + newPaddockCenterLon);
		System.out.println("newPId: " + newPId);
		System.out.println("newPName: " + newPName);
		System.out.println("PFeedCapacity: " + PFeedCapacity);
		System.out.println("PDescription: " + PDescription);
		System.out.println("----New Paddock Arguments End---");

		Gson gson = new Gson();

		farmId = (Short) session.get("farmId");

		short paddockCountRange = 100;

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

		/**
		 * Very Important!
		 * Test the newPID from user input is available or not.
		 */
		Short newPid = (Short) pidVavancy.get(0);
		if (pidVavancy.contains(newPId)) {
			newPid = (short) newPId;
		}
		
		if (pidVavancy.size() > 0) {
			
			System.out.println("The new Paddock FID : " + farmId);
			System.out.println("The new Paddock PID: " + newPid);
			paddockService.addPaddockByFarmId(farmId, newPid, newPName,
					newPaddockCenterLat, newPaddockCenterLon, PDescription, (short)PFeedCapacity,
					newPadoockArea);
			for (Corner corner : lc) {
				cornerService.addCorner(farmId, newPid, corner);
			}
		}
		
		this.brandNewPaddockID = newPid.toString();
		
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

	/**
	 * @author Chen
	 * @version 1.1.2
	 */
	@SuppressWarnings("unchecked")
	public String editPaddock() {

		farmId = (Short) session.get("farmId");

		System.out.println("Edit paddock FarmID: " + farmId);
		System.out.println("NewPID: " + newPId);
		System.out.println("Selected PID: " + selectedPId);

		List<Paddock> lp = (List<Paddock>) session.get("paddocksFromDBonPage");
		
		if (newPId == selectedPId) {

			System.out.println("Same pid! Just Update the previous one.");
			for (Paddock paddock : lp) {
				if (paddock.getId().getPId().equals((short) selectedPId)) {
					paddock.setPDescription(PDescription);
					if (!newPName.equals("")) {
						paddock.setPName(newPName);
					}
					paddock.setPFeedCapacity((short) PFeedCapacity);
					paddockService.updatePaddock(paddock);
				}
			}
			
			Paddock singlePaddock = paddockService.findPaddockByFIDandPID(
					selectedPId, farmId);
			session.remove("selectedPaddock");
			session.put("singlePaddock", singlePaddock);
			
			return SUCCESS;
		} else {

			Paddock newPaddock = new Paddock();
			boolean isNewPIDused = false;

			System.out.println("different newPID!+++++");
			for (Paddock paddock : lp) {
				if (paddock.getId().getPId().equals((short) newPId)) {
					System.out.println("Used Paddock ID.....");
					isNewPIDused = true;
					break;
				} else {
					isNewPIDused = false;
					newPaddock = paddock;

					if (!newPName.equals("")) {
						newPName = paddock.getPName();
					}
					System.out.println("NewPName: " + newPName);
				}
			}

			if (isNewPIDused) {
				System.out.println("Is used, just refresh this page.");
				return ERROR;
			} else {
				System.out.println("Change to the newPID!");
				System.out.println("++++" + newPName + "++++");
				List<Corner> lc = cornerService.listCornersByPaddockId(farmId,
						selectedPId);
				paddockService.deletePaddock(selectedPId, farmId);
				paddockService.addPaddockByFarmId(farmId, (short) newPId,
						newPName, newPaddock.getPCenterLat(),
						newPaddock.getPCenterLon(),
						newPaddock.getPDescription(),
						newPaddock.getPFeedCapacity(), newPaddock.getPArea());
				for (Corner corner : lc) {
					System.out.println(corner.getId());
					cornerService.addCorner(farmId, (short) newPId, corner);
				}
				
				Paddock singlePaddock = paddockService.findPaddockByFIDandPID(
						(short) newPId, farmId);
				session.remove("selectedPaddock");
				session.put("singlePaddock", singlePaddock);
				
				return SUCCESS;
			}
		}

	}
}
