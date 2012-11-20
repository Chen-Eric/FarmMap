/**
 * 
 */
package common;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import domain.Paddock;

/**
 * @author Chen
 */
public class PaddockAdapter implements JsonSerializer<Paddock>{

	@Override
	public JsonElement serialize(Paddock paddock, Type type,
			JsonSerializationContext context) {
		JsonObject jo = new JsonObject();
		
		jo.addProperty("pid", paddock.getId().getPId());
		jo.addProperty("pName", paddock.getPName());
		jo.addProperty("pCenterLat", paddock.getPCenterLat());
		jo.addProperty("pCenterLon", paddock.getPCenterLon());
		jo.addProperty("pDescription", paddock.getPDescription());
		jo.addProperty("pFeedCapability", paddock.getPFeedCapacity());
		jo.addProperty("pArea", paddock.getPArea());
		
		return jo;
	}
	
}
