/**
 * 
 */
package common;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import domain.StockCount;

/**
 * @author Chen
 *
 */
public class StockCountAdapter implements JsonSerializer<StockCount>{

	@Override
	public JsonElement serialize(StockCount stockCount, Type type,
			JsonSerializationContext context) {
		
		JsonObject jo = new JsonObject();
		
		jo.addProperty("gid", stockCount.getId().getGrazingGId());
		jo.addProperty("stid", stockCount.getId().getStockTypeSId());
		jo.addProperty("scCount", stockCount.getScCount());
		
		return jo;
	}

}
