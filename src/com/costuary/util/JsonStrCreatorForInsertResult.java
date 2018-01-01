package com.costuary.util;

import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;

import com.costuary.bean.LicaiBean;
import com.costuary.constant.SqlConstant;

public class JsonStrCreatorForInsertResult implements IJsonStrCreator {

	private static JsonStrCreatorForInsertResult jsonStrCreatorForInsertResult = new JsonStrCreatorForInsertResult();
	private JsonStrCreatorForInsertResult(){};

	public static JsonStrCreatorForInsertResult getInstance(){
		return jsonStrCreatorForInsertResult;
	}

	/**
	 * create json string for InsertResult
	 */
	public String creatJsonStr(LicaiBean bean) {
		JsonObject value = null;
		value = Json.createObjectBuilder().add("date", DateUtil.parseSqlDateToStringFmt(bean.getDate()))
				.add("subCatCn", SqlConstant.getSubCatCn(bean.getSubCatId())).add("subCatId", bean.getSubCatId())
				.add("amt", bean.getAmt()).add("currencyId", bean.getCurrencyId()).add("comment", bean.getComment())
				.build();
		// Debug:
		System.out.println(value.toString());
		return "[" + value.toString() + "]";
	}

	/**
	 * create json string with null value for InsertResult
	 */
	public String creatJsonStrNull() {
		JsonObject value = null;
		value = Json.createObjectBuilder().add("date",  "null")
				.add("subCatCn",  "null")
				.add("amt",  "null")
				.build();
		// Debug:
		System.out.println(value.toString());
		return "[" + value.toString() + "]";
	}

	/**
	 * create json string[] for InsertResult
	 */
	public String[] creatJsonStrList(List<LicaiBean> beanList) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
