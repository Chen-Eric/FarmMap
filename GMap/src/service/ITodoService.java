/**
 * 
 */
package service;

import java.util.List;

import common.TodoFormatter;

import domain.Farm;
import domain.Paddock;
import domain.Todo;

/**
 * @author Chen
 *
 */
public interface ITodoService {
	
	public void addTodo(Todo todo);
	
	public void addTodo(short pid, short fid, String enterDate, String dueDate, String description, boolean done);
	
	public void deleteTodo(Todo todo);
	
	public void updateTodo(Todo todo);
	
	public List<Todo> listTodoByPaddock(short farmId, short paddockId);
	
	public List<TodoFormatter> listTodoByPaddockForForm(short farmId, short paddockId);
	
	public List<Todo> listTodosByFarm(Farm farm);
	
	public List<Todo> listTodosByDateEntered(java.util.Date date);
	
	public List<Todo> listTodosByDateDue(java.util.Date date);
}
