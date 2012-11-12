/**
 * 
 */
package action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import common.CornerAdapter;
import common.PaddockAdapter;

import domain.*;

/**
 * @author Chen
 */
@SuppressWarnings("serial")
public class MapAction extends BaseAction {
	
	private Short farmId;
	
	private String paddocksFromDB;
	
	private String paddockBasicInfo;

	

	public String getPaddocksFromDB() {
		return paddocksFromDB;
	}

	public void setPaddocksFromDB(String paddocksFromDB) {
		this.paddocksFromDB = paddocksFromDB;
	}

	public String getPaddockBasicInfo() {
		return paddockBasicInfo;
	}

	public void setPaddockBasicInfo(String paddockBasicInfo) {
		this.paddockBasicInfo = paddockBasicInfo;
	}

	/**
	 * @author Chen
	 * @return "darwMap"
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String drawMap() {

		farmId = (Short) session.get("farmId");
		System.out.println("Selected Farm ID: " + farmId);
		
		if (farmId == null) {
			try {
				this.response.sendError(403);
				System.out.println(ERROR);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return ERROR;
		} else {
			List<Paddock> listPaddocksOfFarm = paddockService
					.listPaddocksByFarmId((short)farmId);
			System.out.println(listPaddocksOfFarm.size() + "_paddocks");
			GsonBuilder gsonBuilder = new GsonBuilder();
			Gson gson = gsonBuilder.registerTypeAdapter(Corner.class, new CornerAdapter()).create();

			List jsonCorners = new ArrayList();
			
			for (Iterator iterator = listPaddocksOfFarm.iterator(); iterator
					.hasNext();) {
				Paddock paddock = (Paddock) iterator.next();
				List<Corner> listCorners = cornerService.listCornersByPaddockId(
						paddock.getId().getFarmFId(), paddock.getId().getPId());
				for (Iterator iterator2 = listCorners.iterator(); iterator2
						.hasNext();) {
					Corner corner = (Corner) iterator2.next();
					jsonCorners.add(gson.toJson(corner));
				}
			}
//			cookies.put("test", "test");
//			response.addCookie(new Cookie("test", "test"));
			this.paddocksFromDB = jsonCorners.toString();
			session.put("paddocksFromDBonPage", listPaddocksOfFarm);
			System.out.println(paddocksFromDB);
			return SUCCESS;
		}
	}
	
	public String addPaddockName(){
		
		System.out.println("Add paddockBasicInfo...");
		
		farmId = (Short) session.get("farmId");
		
		List<Paddock> listPaddocksOfFarm = paddockService
				.listPaddocksByFarmId((short)farmId);
		System.out.println(listPaddocksOfFarm.size() + "_paddocks");
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.registerTypeAdapter(Paddock.class, new PaddockAdapter()).create();
		
		this.paddockBasicInfo = gson.toJson(listPaddocksOfFarm);
		System.out.println(paddockBasicInfo);
		return SUCCESS;
	}

}
