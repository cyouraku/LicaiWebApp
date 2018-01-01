package com.costuary.util;

import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;

import com.costuary.bean.LicaiBean;
import com.costuary.constant.SqlConstant;

public class JsonStrCreatorForReportResult implements IJsonStrCreator {

	private static JsonStrCreatorForReportResult jsonStrCreatorForReportResult = new JsonStrCreatorForReportResult();
	private JsonStrCreatorForReportResult(){}

	public static JsonStrCreatorForReportResult getInstance(){
		return jsonStrCreatorForReportResult;
	}

	/**
	 * create json string for ReportResult
	 */
	public String creatJsonStr(LicaiBean bean) {
		return null;
	}

	/**
	 * create json string with null value for ReportResult
	 */
	public String creatJsonStrNull() {
		JsonObject value = null;
		value = Json.createObjectBuilder().add("subCatCn", "null")
			     .add("sum",  "null")
			     .add("percent",  "null").build();
		//Debug:
		System.out.println(value.toString());
		return "[" + value.toString() + "]";
	}

	/**
	 * create json string[] for ReportResult
	 */
	public String[] creatJsonStrList(List<LicaiBean> beanList) {
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

}
