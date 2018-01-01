package com.costuary.util;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;

import com.costuary.bean.LicaiBean;
import com.costuary.constant.SqlConstant;

public class StringUtil {

	public static String getString(byte[] bytes,String charset){
		String result = "";
		try {
			result = new String(bytes,charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}


	public static boolean checkInputStrLength(String inputStr){
		int length = inputStr.length();
		if(length < 20){
			return true;
		}else{
			return false;
		}
	}



	//for select result
//	public static String createJsonStr(List<LicaiBean> beanList){
//		int length = beanList.size();
//		LicaiBean bean;
//		JsonArray value = null;
//		if(length != 0){
//			for(int i = 0;i < length;i++){
//				bean = beanList.get(i);
//				value = Json.createArrayBuilder()
//					     .add(Json.createObjectBuilder()
//					     .add("seqNo", bean.getSeq())
//					     .add("date", DateUtil.parseSqlDateToStringFmt(bean.getDate()))
//					     .add("subCatCn",SqlConstant.getSubCatCn(bean.getSubCatId()))
//					     .add("amt", bean.getAmt())
//					     .add("comment", bean.getComment())).build();
//			}
//		}
//		System.out.println(value.toString());
//		return value.toString();
//	}

	//for select result
	public static String createJsonStrIfNull(){
		JsonObject value = null;
		value = Json.createObjectBuilder().add("seqNo", "null").add("date", "null").add("subCatCn", "null").add("amt", "null")
				.add("comment", "null").build();
		//Debug:
		System.out.println(value.toString());
		return "[" + value.toString() + "]";
	}

	//for select result
	public static String[] createJsonStrList(List<LicaiBean> beanList){
		int length = beanList.size();
		String[] jsonStr = new String[length];
		LicaiBean bean;
		JsonObject value = null;
		if(length != 0){
			for(int i = 0;i < length;i++){
				bean = beanList.get(i);
				value = Json.createObjectBuilder()
					     .add("seqNo", bean.getSeq())
					     .add("date", DateUtil.parseSqlDateToStringFmt(bean.getDate()))
					     .add("subCatCn",SqlConstant.getSubCatCn(bean.getSubCatId()))
					     .add("amt", bean.getAmt())
					     .add("comment", bean.getComment()).build();
				jsonStr[i] = value.toString();
				//Debug:
				System.out.println(jsonStr[i]);
			}
		}
		return jsonStr;
	}

	//for report result
	public static String[] createJsonStrListForReport(List<LicaiBean> beanList){
		int length = beanList.size();
		String[] jsonStr = new String[length];
		LicaiBean bean;
		JsonObject value = null;
		float sum = 0;
		if(length != 0){
			for(int i = 0;i < length;i++){
				bean = beanList.get(i);
				sum += bean.getAmt();

			}
			for(int i = 0;i < length;i++){
				bean = beanList.get(i);
				value = Json.createObjectBuilder()
					     .add("subCatCn",SqlConstant.getSubCatCn(bean.getSubCatId()))
					     .add("sum", bean.getAmt())
					     .add("percent", Math.round(bean.getAmt()/sum*100) + "%").build();
				jsonStr[i] = value.toString();
				//Debug:
				System.out.println(jsonStr[i]);
			}
		}
		return jsonStr;
	}

	//for insert result
	public static String createJsonStrForInsertResult(LicaiBean bean) {
		JsonObject value = null;
		value = Json.createObjectBuilder().add("date", DateUtil.parseSqlDateToStringFmt(bean.getDate()))
				.add("subCatCn", SqlConstant.getSubCatCn(bean.getSubCatId())).add("subCatId", bean.getSubCatId())
				.add("amt", bean.getAmt()).add("currencyId", bean.getCurrencyId()).add("comment", bean.getComment())
				.build();
		// Debug:
		System.out.println(value.toString());
		return "[" + value.toString() + "]";
	}

}
