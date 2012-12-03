/**
 * 
 */
package action;

import java.util.List;

import antlr.ASdebug.ASDebugStream;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import common.StockCountAdapter;

import domain.StockCount;
import domain.StockType;

/**
 * @author Chen
 */
public class StockCountAction extends BaseAction{
	/**
	 * @serial auto
	 */
	private static final long serialVersionUID = 6986830748267680401L;
	private int selectedSCId;
	private int selectedPID;
	private int selectedGId;
	private String selectedscCount;
	
	private int newSCGrazingId;
	private int newSCStockTypeId;
	private String newSCCount;
	
	private String stockCountsInDB;
	private String stockCount;
	
	public int getSelectedSCId() {
		return selectedSCId;
	}

	public void setSelectedSCId(int selectedSCId) {
		this.selectedSCId = selectedSCId;
	}

	public int getSelectedPID() {
		return selectedPID;
	}

	public void setSelectedPID(int selectedPID) {
		this.selectedPID = selectedPID;
	}

	public int getSelectedGId() {
		return selectedGId;
	}

	public void setSelectedGId(int selectedGId) {
		this.selectedGId = selectedGId;
	}

	public String getSelectedscCount() {
		return selectedscCount;
	}

	public void setSelectedscCount(String selectedscCount) {
		this.selectedscCount = selectedscCount;
	}

	public int getNewSCGrazingId() {
		return newSCGrazingId;
	}

	public void setNewSCGrazingId(int newSCGrazingId) {
		this.newSCGrazingId = newSCGrazingId;
	}

	public int getNewSCStockTypeId() {
		return newSCStockTypeId;
	}

	public void setNewSCStockTypeId(int newSCStockTypeId) {
		this.newSCStockTypeId = newSCStockTypeId;
	}

	public String getNewSCCount() {
		return newSCCount;
	}

	public void setNewSCCount(String newSCCount) {
		this.newSCCount = newSCCount;
	}

	public String getStockCountsInDB() {
		return stockCountsInDB;
	}

	public void setStockCountsInDB(String stockCountsInDB) {
		this.stockCountsInDB = stockCountsInDB;
	}

	public String getStockCount() {
		return stockCount;
	}

	public void setStockCount(String stockCount) {
		this.stockCount = stockCount;
	}

	/**
	 * @author Chen
	 * @return SUCCESS and json format string.
	 */
	public String showSCByPaddock(){
		
//		short selectedPId = (Short) session.get("selectedPId");
		System.out.println("SCAction_selectedGId: " + selectedGId);
		
		List<StockCount> lsc = stockCountService.listStockcountsByGrazingId((short) selectedGId);
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.registerTypeAdapter(StockCount.class, new StockCountAdapter()).create();
		
		this.stockCountsInDB = gson.toJson(lsc);
		return SUCCESS;
	}
	
	/**
	 * @author Chen
	 */
	public String showSCByGrazing(){
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.registerTypeAdapter(StockCount.class, new StockCountAdapter()).create();
		
		List<StockCount> lsc = stockCountService.listStockcountsByGrazingId((short) selectedGId);
		
		this.stockCount = gson.toJson(lsc);
		return SUCCESS;
	}
	
	/**
	 * @author Chen
	 * @return
	 */
	public String addSCByPaddock(){
		
		System.out.println("newSCGrazingId: " 	+ newSCGrazingId);
		System.out.println("newSCStockTypeId: "  + newSCStockTypeId);
		System.out.println("newSCCount: "      	+ newSCCount);
		
		stockCountService.addStockCount((short) newSCStockTypeId, newSCGrazingId, newSCCount);
		
		return SUCCESS;
	}
	
	public String deleteSC(){
		
		System.out.println("selectedSCId: " + selectedSCId);
		System.out.println("selectedGId: " + selectedGId);
		System.out.println("selectedscCount: " + selectedscCount);
		
		stockCountService.deleteStockCount((short) selectedSCId, selectedGId, selectedscCount);
		
		return SUCCESS;
	}
	
	public String editSC(){
		
		System.out.println("selectedSCId: " + selectedSCId);
		
		return SUCCESS;
	}
	
}
