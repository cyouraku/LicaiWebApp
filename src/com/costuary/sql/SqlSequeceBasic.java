package com.costuary.sql;

public interface SqlSequeceBasic {


	/**
	 * select certain column
	 * @return ret
	 */
	int selectSqlOfCertainCol(String tableName);

	/**
	 * select certain column
	 * @return ret
	 */
	Object selectSqlOfAnyCol(String tableName);

	/**
	 * update method
	 * @param bean
	 * @return
	 */
	int updateSql(String tableName);

	/**
	 * reset current val method
	 * @param bean
	 * @return
	 */
	int resetCurrentValSql(String tableName);

}
