package util;

import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class JsonUtil {
	
	//1把对象转换为json对象
	public static String getJsonStrFromObject(Object o){
		JSONObject jsonObject = JSONObject.fromObject(o); 
		return jsonObject.toString();
	}
	
	//1把对象转换为json字符串
	//2可以进行数据的过滤或者处理
	//例如: 这样可以让日期对象按照自己设置的格式输出
	//JsonConfig jsonConfig = new JsonConfig();
	//jsonConfig.registerJsonValueProcessor(Date.class,new DateJsonValueProcessor());
	public static String getJsonObjectFromObject(Object o,JsonConfig jsonConfig){
		JSONObject jsonObject = JSONObject.fromObject(o,jsonConfig); 
		return jsonObject.toString();
	}
	
	//1把对象转换为json对象 
	//2可以设置需要忽略的字段
	public static String getJsonObjectFromObject(Object o,String[] str){
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setExcludes(str);
		JSONObject jsonObject = JSONObject.fromObject(o,jsonConfig); 
		return jsonObject.toString();
	}
	
	//1把java对象转换为json字符串
	//2可以设置需要忽略的字段
	//3可以需要替换的字段
	public static String getJsonStrFromObject(Object o,String[] str,Map<String,String> map){
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setExcludes(str);
		JSONObject jsonObject = JSONObject.fromObject(o,jsonConfig); 
		String s = jsonObject.toString();
		for(String k:map.keySet()){
			String v = map.get(k);
			s = s.replaceAll(k, v);
		}
		return s;
	}
	
	//1把java对象转换为json数组
	public static String getJsonArrayFromObject(Object o){
		JSONArray array = JSONArray.fromObject(o);
		return array.toString();
	}
	//1把java对象转换为json数组 
	//2可以进行数据的过滤或者处理
	public static String getJsonArrayFromObject(Object o,JsonConfig jsonConfig){
		JSONArray array = JSONArray.fromObject(o,jsonConfig); 
		return array.toString();
	}
	
	//1把对象转换为json数组 
	//2可以设置需要忽略的字段
	public static String getJsonArrayFromObject(Object o,String[] str){
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setExcludes(str);
		JSONArray array = JSONArray.fromObject(o,jsonConfig); 
		return array.toString();
	}
	
	//1把对象转换为json数组
	//2可以设置需要忽略的字段
	//3可以设置需要替换的字段
	public static String getJsonArrayFromObject(Object o,String[] str,Map<String,String> map){
		JsonConfig jsonConfig = new JsonConfig();  
		jsonConfig.setIgnoreDefaultExcludes(false);
		jsonConfig.setExcludes(str);
		JSONArray array = JSONArray.fromObject(o,jsonConfig); 
		String s = array.toString();
		for(String k:map.keySet()){
			String v = map.get(k);
			s = s.replaceAll(k, v);
		}
		return s;
	}
	
}
