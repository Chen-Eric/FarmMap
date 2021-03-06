/**
 * 
 */
package util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import common.TodoFormatter;

import dao.ICornerDAO;
import dao.impl.BlockDAO;
import dao.impl.GrazingDAO;
import dao.impl.StockCountDAO;
import dao.impl.StockTypeDAO;
import dao.impl.TodoDAO;
import domain.Block;
import domain.BlockId;
import domain.Corner;
import domain.CornerId;
import domain.Farm;
import domain.Grazing;
import domain.Paddock;
import domain.PaddockId;
import domain.StockType;
import domain.StockCount;
import domain.StockCountId;
import domain.Todo;

import service.impl.BlockService;
import service.impl.CornerService;
import service.impl.FarmService;
import service.impl.GrazingService;
import service.impl.PaddockService;
import service.impl.StockTypeService;
import service.impl.StockCountService;
import service.impl.TodoService;

/**
 * @author Chen
 * 
 */
public class HSTest {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		FarmService farmService = (FarmService) ctx.getBean("FarmService");
		BlockService blockService = (BlockService) ctx.getBean("BlockService");
		BlockDAO blockDAO = (BlockDAO) ctx.getBean("BlockDAO");
		PaddockService paddockService = (PaddockService) ctx
				.getBean("PaddockService");
		StockTypeService stockTypeService = (StockTypeService) ctx
				.getBean("StockTypeService");
		StockTypeDAO stockTypeDAO = (StockTypeDAO) ctx.getBean("StockTypeDAO");
		StockCountService stockcountService = (StockCountService) ctx
				.getBean("StockCountService");
		StockCountDAO stockCountDAO = (StockCountDAO) ctx.getBean("StockCountDAO");
		TodoService todoService = (TodoService) ctx.getBean("TodoService");
		TodoDAO todoDAO = (TodoDAO) ctx.getBean("TodoDAO");
		GrazingService grazingService = (GrazingService) ctx
				.getBean("GrazingService");
		GrazingDAO grazingDAO = (GrazingDAO) ctx.getBean("GrazingDAO");
		CornerService cornerService = (CornerService) ctx
				.getBean("CornerService");
		ICornerDAO cornerDAO = (ICornerDAO) ctx.getBean("CornerDAO");

		// Test.
		short farmId = 1;
		short paddockId = 1;

		// List<Paddock> lp = paddockService.listPaddocksByFarmId(farmId);
		// System.out.println(lp.size());

		// Corner corner = new Corner();
		// corner.setCLat((double) 101);
		// corner.setCLon((double) 110);
		// CornerId cornerId = new CornerId();
		// cornerId.setPaddockFarmFId(farmId);
		// cornerId.setPaddockPId(paddockId);
		// corner.setId(cornerId);
		//
		// Grazing grazing = new Grazing();
		// grazing.setGDateIn(new Date());
		// grazing.setPaddockPId(paddockId);
		// grazing.setPaddockFarmFId(farmId);

		// grazingService.addGrazing(grazing);

		// todoService.addTodo(todo);

		// paddockService.deletePaddock(paddockId, farmId);

		// StockType stockType = new StockType("beef", 10);
		//
		// StockCountId scid = new StockCountId();
		// scid.setGrazingGId(4);
		// scid.setStockTypeSId((short)1);
		// StockCount sc = new StockCount();
		// sc.setId(scid);
		// sc.setScCount("sheep");
		//
		// stockcountService.deleteStockCount(sc);
		//
		// System.out.println(paddockService.findPaddockById(paddockId, farmId));

		// StockType stockType = new StockType();
		// stockType.setSId((short) 4);
		// stockTypeService.deleteStockType((short) 4);
		// stockTypeDAO.delete(stockType);

		// Todo and Date Test
		String dateString = "2012-12-12";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date d = sdf.parse(dateString);

		Todo todo = new Todo();
		todo.setPaddockFarmFId(farmId);
		todo.setPaddockPId(paddockId);
		todo.setTDateEntered(d);
		todo.setTDone(true);

		// todoService.addTodo(todo);

//		List<Todo> lt = todoService.listTodoByPaddock(farmId, paddockId);
		
//		StockCountId scid = new StockCountId();
//		scid.setGrazingGId(1);
//		List<StockCount> lsc = stockCountDAO.findByGrazingId(2);
//		System.out.println(lsc.size());
		
//		Short stockTypeSId = 4;
//		int grazingGId = 1;
//		String scCount = "wo";
//		
//		StockCountId stockCountId = new StockCountId();
//		stockCountId.setStockTypeSId(stockTypeSId);
//		stockCountId.setGrazingGId(grazingGId);
//		StockCount stockCount = new StockCount();
//		stockCount.setId(stockCountId);
//		stockCount.setScCount(scCount);
//		stockCountDAO.save(stockCount);
		
//		List<StockCount> lsc = stockcountService.listStockcountsByGrazingId((short) 2);
//		
//		System.out.println(lsc.size());
		
	}

}
