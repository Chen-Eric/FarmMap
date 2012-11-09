package common;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import domain.Grazing;

/**
 * @author Chen
 *
 */
public class GrazingAdapter implements JsonSerializer<Grazing>{

	@Override
	public JsonElement serialize(Grazing grazing, Type type,
			JsonSerializationContext context) {
		JsonObject jo = new JsonObject();
		jo.addProperty("fid", grazing.getPaddockFarmFId());
		jo.addProperty("pid", grazing.getPaddockPId());
		jo.addProperty("gid", grazing.getGId());
		jo.addProperty("G_Date_In", grazing.getGDateIn().toString().substring(0, 10));
		if (grazing.getGDateOut() != null) {
			jo.addProperty("G_Date_Out", grazing.getGDateOut().toString().substring(0, 10));
		} else {
			jo.addProperty("G_Date_Out", "No out date.");
		}
		if (grazing.getGNote() != null) {
			jo.addProperty("note", grazing.getGNote());
		} else {
			jo.addProperty("note", "No note.");
		}
		return jo;
	}
	
}
