/**
 * 
 */
package common;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import domain.Corner;

/**
 * @author Chen
 *
 */
public class CornerAdapter implements JsonSerializer<Corner> {

	@Override
	public JsonElement serialize(Corner corner, Type type,
			JsonSerializationContext context) {
		JsonObject jo = new JsonObject();
		jo.addProperty("pid", corner.getId().getPaddockPId());
		jo.addProperty("lat", corner.getCLat());
		jo.addProperty("lon", corner.getCLon());
		return jo;
	}
	
}
