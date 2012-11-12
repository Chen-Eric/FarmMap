/**
 * 
 */
package action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

import service.IBlockService;
import service.ICornerService;
import service.IFarmService;
import service.IGrazingService;
import service.IPaddockService;
import service.IStockTypeService;
import service.IStockCountService;
import service.ITodoService;



/**
 * @author Chen
 * 
 */
public class BaseAction extends ActionSupport implements ServletContextAware,
		SessionAware, ServletRequestAware, ServletResponseAware, CookiesAware {

	/**
	 * @author Chen
	 * @serial 1L
	 */
	private static final long serialVersionUID = 1L;
	//Basic container components.
	protected ServletContext servletContext;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected Map<String, Object> session;
	protected Map<String, String> cookies;
	
	//Services.
	protected IBlockService blockService;
	protected ICornerService cornerService;
	protected IFarmService farmService;
	protected IGrazingService grazingService;
	protected IPaddockService paddockService;
	protected IStockCountService stockCountService;
	protected IStockTypeService stockTypeService;
	protected ITodoService todoService;
	
	//For json format results.
	
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;		
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;		
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;		
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;		
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public IBlockService getBlockService() {
		return blockService;
	}

	public void setBlockService(IBlockService blockService) {
		this.blockService = blockService;
	}

	public ICornerService getCornerService() {
		return cornerService;
	}

	public void setCornerService(ICornerService cornerService) {
		this.cornerService = cornerService;
	}

	public IFarmService getFarmService() {
		return farmService;
	}

	public void setFarmService(IFarmService farmService) {
		this.farmService = farmService;
	}

	public IGrazingService getGrazingService() {
		return grazingService;
	}

	public void setGrazingService(IGrazingService grazingService) {
		this.grazingService = grazingService;
	}

	public IPaddockService getPaddockService() {
		return paddockService;
	}

	public void setPaddockService(IPaddockService paddockService) {
		this.paddockService = paddockService;
	}

	public IStockCountService getStockcountService() {
		return stockCountService;
	}

	public void setStockcountService(IStockCountService stockCountService) {
		this.stockCountService = stockCountService;
	}

	public IStockTypeService getStockTypeService() {
		return stockTypeService;
	}

	public void setStockTypeService(IStockTypeService stockTypeService) {
		this.stockTypeService = stockTypeService;
	}

	public ITodoService getTodoService() {
		return todoService;
	}

	public void setTodoService(ITodoService todoService) {
		this.todoService = todoService;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public IStockCountService getStockCountService() {
		return stockCountService;
	}

	public void setStockCountService(IStockCountService stockCountService) {
		this.stockCountService = stockCountService;
	}

	@Override
	public void setCookiesMap(Map<String, String> map) {
		this.cookies = map;
	}

}
