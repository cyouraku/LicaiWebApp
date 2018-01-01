package com.costuary.util;

public interface IJsonStrFactory {


	JsonStrCreatorForSelectResult creatJsonStrCreatorSelect();

	JsonStrCreatorForReportResult creatJsonStrCreatorReport();

	JsonStrCreatorForInsertResult creatJsonStrCreatorInsert();

}
