/**
 * 
 */
package util;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.util.finder.Test;

import common.CornerAdapter;
import common.GrazingAdapter;
import common.PaddockAdapter;
import common.TodoAdapter;

import service.impl.CornerService;
import service.impl.GrazingService;
import service.impl.PaddockService;
import service.impl.TodoService;

import dao.impl.CornerDAO;
import dao.impl.PaddockDAO;
import domain.Corner;
import domain.CornerId;
import domain.Farm;
import domain.Grazing;
import domain.Paddock;
import domain.PaddockId;
import domain.StockType;
import domain.Todo;

import action.BaseAction;

/**
 * @author Chen
 * 
 */
public class ActionTest extends BaseAction {

	/**
	 * @author Chen
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		PaddockService paddockService = (PaddockService) ctx
				.getBean("PaddockService");
		PaddockDAO paddockDAO = (PaddockDAO) ctx.getBean("PaddockDAO");
		CornerService cornerService = (CornerService) ctx
				.getBean("CornerService");
		CornerDAO cornerDAO = (CornerDAO) ctx.getBean("CornerDAO");
		GrazingService grazingService = (GrazingService) ctx
				.getBean("GrazingService");
		TodoService todoService = (TodoService) ctx.getBean("TodoService");

		short farmId = 1;
		// short paddockId = 3;

		// GsonBuilder gsonBuilder = new GsonBuilder();
		// Gson gson = gsonBuilder.registerTypeAdapter(Todo.class, new
		// TodoAdapter()).create();
		//
		// List<Grazing> lg = grazingService.listGrazingsByPaddock(farmId,
		// paddockId);

		// List<Todo> lt = todoService.listTodoByPaddock(farmId, paddockId);

		// System.out.println(lg.get(0).getGDateIn());
		// System.out.println(lg.get(0).getGDateIn().toString());
		// System.out.println(lg.get(0).getGDateIn().toString().substring(0,
		// 10));
		// System.out.println(gson.toJson(lt));

		// show paddock test.

//		GsonBuilder gsonBuilder = new GsonBuilder();
//		Gson gson = gsonBuilder.registerTypeAdapter(Corner.class,
//				new CornerAdapter()).create();
//		Gson gson2 = new Gson();
//		List<Paddock> listPaddocksOfFarm = paddockService
//				.listPaddocksByFarmId(farmId);
//
//		List jsonCorners = new ArrayList();
//	
//		for (Iterator iterator = listPaddocksOfFarm.iterator(); iterator
//				.hasNext();) {
//			Paddock paddock = (Paddock) iterator.next();
//			List<Corner> listCorners = cornerService.listCornersByPaddockId(
//					paddock.getId().getFarm().getFId(), paddock.getId()
//							.getPId());
//			for (Iterator iterator2 = listCorners.iterator(); iterator2
//					.hasNext();) {
//				Corner corner = (Corner) iterator2.next();
//				jsonCorners.add(gson.toJson(corner));
//			}
//		}
//		System.out.println(jsonCorners);
//		System.out.println(gson.fromJson(jsonCorners.toString(), Corner.class));
		
		//New paddock and New corners test.
//		List<Paddock> lp = paddockService.listPaddocksByFarmId(farmId);
//		List pidVacancy = new ArrayList();
//		
//		for (short i = 1; i <= 3; i++) {
//			pidVacancy.add(i);
//		}
//		
//		for (Paddock p : lp) {
//			if (pidVacancy.contains(p.getId().getPId())) {
//				pidVacancy.remove(p.getId().getPId());
//			}
//		}
//		
//		for (Iterator iterator = pidVacancy.iterator(); iterator.hasNext();) {
//			Short newPid = (Short) iterator.next();
//			System.out.println(newPid);
//			Farm farm = new Farm();
//			farm.setFId(farmId);
//			PaddockId paddockId = new PaddockId();
//			paddockId.setPId(newPid);
//			paddockId.setFarm(farm);
//			Paddock paddock = new Paddock();
//			paddock.setId(paddockId);
//			paddock.setPName("f"+ farmId + "p"+newPid);
//			paddockService.addPaddockByFarmId(farmId, newPid, "f"+ farmId + "p"+newPid);
//		}
		
		//pName test.
//		List<Paddock> listPaddocksOfFarm = paddockService
//				.listPaddocksByFarmId((short)farmId);
//		System.out.println(listPaddocksOfFarm.size() + "_paddocks");
//		
//		GsonBuilder gsonBuilder = new GsonBuilder();
//		Gson gson = gsonBuilder.registerTypeAdapter(Paddock.class, new PaddockAdapter()).create();
//		
//		System.out.println(gson.toJson(listPaddocksOfFarm));
		
	}
}
