package com.costuary.util;

public class JsonStrFactory implements IJsonStrFactory {

	@Override
	public JsonStrCreatorForSelectResult creatJsonStrCreatorSelect() {
		return JsonStrCreatorForSelectResult.getInstance();
	}

	@Override
	public JsonStrCreatorForReportResult creatJsonStrCreatorReport() {
		return JsonStrCreatorForReportResult.getInstance();
	}

	@Override
	public JsonStrCreatorForInsertResult creatJsonStrCreatorInsert() {
		return JsonStrCreatorForInsertResult.getInstance();
	}

}
