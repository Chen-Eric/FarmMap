/**
 * 
 */
package service.impl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import common.TodoFormatter;

import dao.impl.TodoDAO;
import domain.Farm;
import domain.Paddock;
import domain.PaddockId;
import domain.Todo;
import service.ITodoService;

/**
 * @author Chen
 * 
 */
public class TodoService implements ITodoService {

	private TodoDAO todoDAO;

	public TodoDAO getTodoDAO() {
		return todoDAO;
	}

	public void setTodoDAO(TodoDAO todoDAO) {
		this.todoDAO = todoDAO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.ITodoService#addTodo(domain.Todo)
	 */
	@Override
	public void addTodo(Todo todo) {
		todoDAO.save(todo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.ITodoService#deleteTodo(domain.Todo)
	 */
	@Override
	public void deleteTodo(short tid) {
		Todo todo = new Todo();
//		todo.setTId(tid);
//		todo.setPaddockPId(pid);
//		todo.setPaddockFarmFId(fid);
		
		todo = todoDAO.findById(tid);
		
		todoDAO.delete(todo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.ITodoService#updateTodo(domain.Todo)
	 */
	@Override
	public void updateTodo(short tid, String enterDate, String dueDate,  String description, boolean done) {
		Todo todo = new Todo();
		todo = todoDAO.findById(tid);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (dueDate.equals("No due date.")) {
				java.util.Date enterD = sdf.parse(enterDate);
				todo.setTDateEntered(enterD);
				
			} else {
				java.util.Date enterD = sdf.parse(enterDate);
				java.util.Date dueD = sdf.parse(dueDate);
				
				todo.setTDateEntered(enterD);
				todo.setTDateDue(dueD);
				
			}
			
			todo.setTDescription(description);
			todo.setTDone(done);
			
			todoDAO.updateTodo(todo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.ITodoService#listTodoByPaddock(domain.Paddock)
	 */
	@Override
	public List<Todo> listTodoByPaddock(short farmId, short paddockId) {

		Paddock paddock = new Paddock();
		PaddockId pid = new PaddockId();
		pid.setFarmFId(farmId);
		pid.setPId(paddockId);
		paddock.setId(pid);

		return todoDAO.findByFarmAndPaddock(paddock);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see service.ITodoService#listTodosByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<Todo> listTodosByFarm(Farm farm) {
		// TODO change it to findByExample later.
		return todoDAO.findByProperty("paddock.Paddock_Farm_F_ID",
				farm.getFId());
	}

	@Override
	public List<Todo> listTodosByDateEntered(java.util.Date date) {
		Todo todo = new Todo();
		todo.setTDateEntered(date);
		return todoDAO.findByExample(todo);
	}

	@Override
	public List<Todo> listTodosByDateDue(java.util.Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addTodo(short pid, short fid, String enterDate, String dueDate,
			String description, boolean done) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			if (dueDate.equals("")) {
				java.util.Date enterD = sdf.parse(enterDate);
				Todo todo = new Todo(pid, fid, enterD, null, description, done);
				todoDAO.save(todo);
			} else {
				java.util.Date enterD = sdf.parse(enterDate);
				java.util.Date dueD = sdf.parse(dueDate);
				Todo todo = new Todo(pid, fid, enterD, dueD, description, done);
				todoDAO.save(todo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<TodoFormatter> listTodoByPaddockForForm(short farmId, short paddockId) {
		Paddock paddock = new Paddock();
		PaddockId pid = new PaddockId();
		pid.setFarmFId(farmId);
		pid.setPId(paddockId);
		paddock.setId(pid);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		List<Todo> lt = todoDAO.findByFarmAndPaddock(paddock);
	
		List<TodoFormatter> ltf = new ArrayList<TodoFormatter>();
		for (Todo tt : lt) {
			TodoFormatter ttf = new TodoFormatter();
			ttf.setPaddockPId(tt.getPaddockPId());
			ttf.setPaddockFarmFId(tt.getPaddockFarmFId());
			ttf.setTId(tt.getTId());
			ttf.setTDateEntered(tt.getTDateEntered().toString().substring(0, 10));
			if (tt.getTDateDue() != null) {
				ttf.setTDateDue(tt.getTDateDue().toString().substring(0, 10));
			} else {
				ttf.setTDateDue("No due date.");
			}
			ttf.setTDescription(tt.getTDescription());
			ttf.setTDone(tt.getTDone());

			ltf.add(ttf);
		}
		
		return ltf;
	}

}
