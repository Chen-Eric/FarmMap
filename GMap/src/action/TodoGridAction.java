package action;

import java.util.ArrayList;
import java.util.List;

import util.Column;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import common.TodoAdapter;
import common.TodoFormatter;

import domain.Todo;

public class TodoGridAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 23018738170317447L;

	private int selectedPId;

	// My result List
	private List<TodoFormatter> gridModel;
	
	private List<Column> demoGridModel;

	// get how many rows we want to have into the grid - rowNum attribute in the grid
	private Integer rows = 0;

	// Get the requested page. By default grid sets this to 1.
	private Integer page = 0;

	// sorting order - asc or desc
	private String sord;

	// get index row - i.e. user click to sort.
	private String sidx;

	// Search Field
	private String searchField;

	// The Search String
	private String searchString;

	// he Search Operation ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
	private String searchOper;

	// Your Total Pages
	private Integer total = 0;

	// All Record
	private Integer records = 0;

	public String showGrid() {
		
		int to = (rows * page);
		int from = to - rows;
		
		System.out.println("TodoGridModel_rows: " + rows);
		System.out.println("TodoGridModel_to: " + to);
		System.out.println("TodoGridModel_from: " + from);
		
		short farmId = (Short) session.get("farmId");
		List<TodoFormatter> allGridModel = todoService.listTodoByPaddockForForm(farmId, (short) 1);
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.registerTypeAdapter(Todo.class, new TodoAdapter()).create();
		
		//Count Rows
		records = allGridModel.size();
		
		//My logic to search and select the required data.
//		gridModel = allGridModel.subList(from, to);
		gridModel = allGridModel;
		
		total = (int) Math.ceil((double)records / (double)rows);
		
		System.out.println("TodoGridModel: " + allGridModel);
		System.out.println("TodoGridAction_records: " + records);
		System.out.println("TodoGridAction_total: " + total);
		return SUCCESS;
	}
	
	public String gridDemo(){
		
		 records = 2; 
         rows=2; 
         
         demoGridModel = new ArrayList<Column>();
         demoGridModel.add(new Column(123));
         demoGridModel.add(new Column(333));
         
         total = (int) Math.ceil((double) records / (double) rows); 
         
		return SUCCESS;
	}
	

	public int getSelectedPId() {
		return selectedPId;
	}

	public void setSelectedPId(int selectedPId) {
		this.selectedPId = selectedPId;
	}

	public List<TodoFormatter> getGridModel() {
		return gridModel;
	}

	public void setGridModel(List<TodoFormatter> gridModel) {
		this.gridModel = gridModel;
	}

	public List<Column> getDemoGridModel() {
		return demoGridModel;
	}

	public void setDemoGridModel(List<Column> demoGridModel) {
		this.demoGridModel = demoGridModel;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getSord() {
		return sord;
	}

	public void setSord(String sord) {
		this.sord = sord;
	}

	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getSearchOper() {
		return searchOper;
	}

	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}
	
	
}
