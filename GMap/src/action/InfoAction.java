/**
 * 
 */
package action;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import common.GrazingAdapter;
import common.TodoAdapter;

import domain.Farm;
import domain.Grazing;
import domain.Todo;

/**
 * @author Chen
 * 
 */
public class InfoAction extends BaseAction {

	/**
	 * @author Chen
	 * @serial Default
	 */
	private static final long serialVersionUID = 1L;
	
	private int totalPages;
	private int currentPage;
	private int totalRecords;
	
	private String paddockBasicInfo;
	private String paddockGrazings;
	private String paddockTodos;
	
	private int paddockId;

	public String getPaddockBasicInfo() {
		return paddockBasicInfo;
	}

	public void setPaddockBasicInfo(String paddockBasicInfo) {
		this.paddockBasicInfo = paddockBasicInfo;
	}

	public String getPaddockGrazings() {
		return paddockGrazings;
	}

	public void setPaddockGrazings(String paddockGrazings) {
		this.paddockGrazings = paddockGrazings;
	}

	public String getPaddockTodos() {
		return paddockTodos;
	}

	public void setPaddockTodos(String paddockTodos) {
		this.paddockTodos = paddockTodos;
	}

	public void setPaddockId(int paddockId) {
		this.paddockId = paddockId;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	/**
	 * @author Chen
	 * @return "showFarms"
	 */
	public String showFarms() {
		List<Farm> listOfFarms = farmService.listFarms();
		session.put("farms", listOfFarms);
		// System.out.println(listOfFarms.isEmpty());
		return "showFarms";
	}

	/**
	 * @author Chen
	 * @return paddock basic infomation json object.
	 */
	public String showPaddockBasicInfo() {

		return null;
	}

	/**
	 * @author Chen
	 * @return paddock grazing infomation json object.
	 */
	public String showPaddockGrazings() {
		
		short farmId = (Short) session.get("farmId");
		
		System.out.println("farmId: " + farmId);
		System.out.println("paddockId: " + paddockId);

		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.registerTypeAdapter(Grazing.class,
				new GrazingAdapter()).create();

		List<Grazing> lg = grazingService.listGrazingsByPaddock(farmId,
				(short)paddockId);

		System.out.println("Grazings: " + gson.toJson(lg));

		this.paddockGrazings = gson.toJson(lg);
		
		return SUCCESS;
	}

	/**
	 * @author Chen
	 * @return paddock Todo infomation json object.
	 */
	public String showPaddockTodos() {
		
		short farmId = (Short) session.get("farmId");
		
		System.out.println("farmId: " + farmId);
		System.out.println("paddockId: " + paddockId);
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.registerTypeAdapter(Todo.class, new TodoAdapter()).create();
		
		List<Todo> lt = todoService.listTodoByPaddock(farmId, (short)paddockId);
		
		this.paddockTodos = gson.toJson(lt);
		System.out.println("Todos: " + gson.toJson(lt));
		return SUCCESS;
	}
	
}
