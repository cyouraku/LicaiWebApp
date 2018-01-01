package com.costuary.util;

import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;

import com.costuary.bean.LicaiBean;
import com.costuary.constant.SqlConstant;

public class JsonStrCreatorForSelectResult implements IJsonStrCreator {

	//use singleton pattern
	private static JsonStrCreatorForSelectResult jsonStrCreatorForSelectResult = new JsonStrCreatorForSelectResult();
	private JsonStrCreatorForSelectResult(){};

	public static JsonStrCreatorForSelectResult getInstance(){
		return jsonStrCreatorForSelectResult;
	}

	/**
	 * create json string for SelectResult
	 */
	public String creatJsonStr(LicaiBean bean) {
		JsonObject value = null;
		value = Json.createObjectBuilder().add("seqNo", bean.getSeq())
			     .add("date", DateUtil.parseSqlDateToStringFmt(bean.getDate()))
			     .add("subCatCn",SqlConstant.getSubCatCn(bean.getSubCatId()))
			     .add("amt", bean.getAmt())
			     .add("comment", bean.getComment()).build();
		//Debug:
		System.out.println(value.toString());
		return "[" + value.toString() + "]";
	}

	/**
	 * create json string with null value for SelectResult
	 */
	public String creatJsonStrNull() {
		JsonObject value = null;
		value = Json.createObjectBuilder().add("seqNo", "null").add("date", "null").add("subCatCn", "null").add("amt", "null")
				.add("comment", "null").build();
		//Debug:
		System.out.println(value.toString());
		return "[" + value.toString() + "]";
	}

	/**
	 * create json string[] for SelectResult
	 */
	public String[] creatJsonStrList(List<LicaiBean> beanList) {
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

}
