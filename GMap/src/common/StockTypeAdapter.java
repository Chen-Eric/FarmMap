/**
 * 
 */
package common;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import domain.StockType;

/**
 * @author Chen
 *
 */
public class StockTypeAdapter implements JsonSerializer<StockType>{

	@Override
	public JsonElement serialize(StockType stockType, Type type,
			JsonSerializationContext context) {
		JsonObject jo = new JsonObject();
		
		jo.addProperty("stid", stockType.getSId());
		jo.addProperty("st", stockType.getSType());
		jo.addProperty("scUnit", stockType.getStockUnits());
		
		return jo;
	}
	
}
