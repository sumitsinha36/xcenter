package com.xcenter.util;

import java.lang.reflect.Field;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtil {

	public JSONObject getJSONObjectFromList(List<? extends Object> objects) throws IllegalArgumentException, IllegalAccessException, JSONException {
		
		JSONObject json = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		
		for(Object object : objects) {
			
			JSONObject temp = new JSONObject();
			Field[] fields = object.getClass().getDeclaredFields();
			for(Field field : fields) {
				field.setAccessible(true);
				temp.put(field.getName(), field.get(object));
			}
			jsonArray.put(temp);
		}
		json.put("menu", jsonArray);
		
		return json;
	}
}
