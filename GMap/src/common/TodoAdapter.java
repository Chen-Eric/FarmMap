/**
 * 
 */
package common;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import domain.Todo;

/**
 * @author Chen
 *
 */
public class TodoAdapter implements JsonSerializer<Todo> {

	@Override
	public JsonElement serialize(Todo todo, Type type,
			JsonSerializationContext context) {
		JsonObject jo = new JsonObject();
		jo.addProperty("fid", todo.getPaddockFarmFId());
		jo.addProperty("pid", todo.getPaddockPId());
		jo.addProperty("tid", todo.getTId());
		jo.addProperty("T_Date_Entered", todo.getTDateEntered().toString().substring(0, 10));
		if (todo.getTDateDue() != null) {
			jo.addProperty("T_Date_Due", todo.getTDateDue().toString().substring(0, 10));
		} else {
			jo.addProperty("T_Date_Due", "No due date.");
		}
		if (todo.getTDescription() != null) {
			jo.addProperty("T_Description", todo.getTDescription());
		} else {
			jo.addProperty("T_Description", "No description.");
		}
		return jo;
	}
	
}
