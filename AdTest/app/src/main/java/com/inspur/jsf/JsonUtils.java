package com.inspur.jsf;

import com.xin.util.XLog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

public class JsonUtils {
	public static String getStringFromJson(String json, String key) {
		JSONObject jsonObject = getObjectSafely(json);
		if (jsonObject != null) {
			try {
				return jsonObject.getString(key);
			} catch (JSONException e) {
				XLog.e("getIntFromJson", e);
			}
		}
		return null;
	}

	public static JSONObject getObjectSafely(String json) {
		if (json == null) {
			return null;
		}
		try {
			JSONObject array = new JSONObject(json);
			return array;
		} catch (JSONException e) {
			XLog.e("getObjectSafely", e);
		}
		return null;
	}

	public static JSONArray getArraySafely(String json) {
		if (json == null) {
			return null;
		}
		JSONArray array;
		try {
			array = new JSONArray(json);
			int len = array.length();
			XLog.i("getArraySafely.count = " + len);
			if (len > 0) {
				return array;
			}
		} catch (JSONException e) {
			XLog.e("getArraySafely", e);
		}
		return null;
	}

	public static int getFirstInt(JSONArray array, String field, int defaultValue) {
		if (array == null) {
			return defaultValue;
		}
		try {
			int len = array.length();
			if (len > 0) {
				JSONObject obj = array.getJSONObject(0);
				return obj.getInt(field);
			}
		} catch (JSONException e) {
			XLog.e("getFirstInt", e);
		}
		return defaultValue;
	}

	public static String getFirstString(JSONArray array, String field) {
		if (array == null) {
			return null;
		}
		try {
			int len = array.length();
			if (len > 0) {
				JSONObject obj = array.getJSONObject(0);
				return obj.getString(field);
			}
		} catch (JSONException e) {
			XLog.e("getFirstString", e);
		}
		return null;
	}

	public static HashMap<String, Object> get(JSONObject jsonObject) {
		HashMap<String, Object> data = new HashMap<String, Object>();
		Iterator it = jsonObject.keys();
		while (it.hasNext()) {
			String key = String.valueOf(it.next());
			Object value = jsonObject.opt(key);
			data.put(key, value);
		}
		return data;
	}
}
