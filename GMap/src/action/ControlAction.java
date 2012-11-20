/**
 * 
 */
package action;

/**
 * @author Chen
 *
 */
public class ControlAction extends BaseAction {
	
	private int farmId;
	
	public int getFarmId() {
		return farmId;
	}


	public void setFarmId(int farmId) {
		this.farmId = farmId;
	}


	/**
	 * @author Chen
	 * @return SUCCESS
	 */
	public String showFarmMap(){
		System.out.println(Integer.valueOf(farmId).equals(null));
		if (Integer.valueOf(farmId).equals(null)) {
			return ERROR;
		} else {
			System.out.println("ControlAction: " + farmId);
			session.put("farmId", (short)farmId);
			return SUCCESS;
		}
	}
	
	public String showFarmMapOnTest(){
		System.out.println(Integer.valueOf(farmId).equals(null));
		if (Integer.valueOf(farmId).equals(null)) {
			return ERROR;
		} else {
			System.out.println("ControlAction: " + farmId);
			session.put("farmId", (short)farmId);
			return SUCCESS;
		}
	}
	
}
