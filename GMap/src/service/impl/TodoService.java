/**
 * 
 */
package service.impl;

import java.sql.Date;
import java.util.List;

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

	/* (non-Javadoc)
	 * @see service.ITodoService#addTodo(domain.Todo)
	 */
	@Override
	public void addTodo(Todo todo) {
		todoDAO.save(todo);
	}

	/* (non-Javadoc)
	 * @see service.ITodoService#deleteTodo(domain.Todo)
	 */
	@Override
	public void deleteTodo(Todo todo) {
		todoDAO.delete(todo);
	}

	/* (non-Javadoc)
	 * @see service.ITodoService#updateTodo(domain.Todo)
	 */
	@Override
	public void updateTodo(Todo todo) {
		todoDAO.updateTodo(todo);
	}

	/* (non-Javadoc)
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

	/* (non-Javadoc)
	 * @see service.ITodoService#listTodosByProperty(java.lang.String, java.lang.Object)
	 */
	@Override
	public List<Todo> listTodosByFarm(Farm farm) {
		// TODO change it to findByExample later.
		return todoDAO.findByProperty("paddock.Paddock_Farm_F_ID", farm.getFId());
	}

	@Override
	public List<Todo> listTodosByDateEntered(java.util.Date date) {
		Todo  todo = new Todo();
		todo.setTDateEntered(date);
		return todoDAO.findByExample(todo);
	}

	@Override
	public List<Todo> listTodosByDateDue(java.util.Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
