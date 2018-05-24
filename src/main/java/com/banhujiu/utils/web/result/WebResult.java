package com.banhujiu.utils.web.result;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

/**
 * @author banhujiu
 * @date 2018/5/8 0008 19:57
 */
public class WebResult {
	private Gson gson = new Gson();
	private Map<String, String> dataMap;
	private int status = ResultStatusEnum.OK.getVal();

	public Map<String, String> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, String> dataMap) {
		this.dataMap = dataMap;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public WebResult addDataMap(String key, String value) {
		if (key == null) {
			throw new NullPointerException("dataMap key is null");
		}
		initDataMap();
		this.dataMap.put(key, value);
		return this;
	}

	public WebResult addDataMap(String key, Object value) {
		if (key == null) {
			throw new NullPointerException("dataMap key is null");
		}
		initDataMap();
		this.dataMap.put(key, valueToJson(value));
		return this;
	}

	protected String valueToJson(Object value) {
		return gson.toJson(value);
	}

	private void initDataMap() {
		if (dataMap == null) {
			dataMap = new HashMap<String, String>();
		}
	}

	public static WebResult ok() {
		return new WebResult();
	}

	public static WebResult error() {
		WebResult result = new WebResult();
		result.setStatus(ResultStatusEnum.ERROR.getVal());
		return result;
	}
}
