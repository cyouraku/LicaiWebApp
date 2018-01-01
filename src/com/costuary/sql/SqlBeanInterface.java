package com.costuary.sql;

import java.util.List;

public interface SqlBeanInterface {

	/**
	 * select all
	 * @return ret
	 */
	List<String>  selectSqlOfAll();

	/**
	 * select certain column
	 * @return ret
	 */
	List<Integer> selectSqlOfCertainCol(String param);

	/**
	 * insert method
	 *  @param bean
	 * @return executeUpdate() result
	 */
	int insertSql(Object bean);

	/**
	 * insert List<BasicBean> method
	 * @param bean
	 * @return
	 */
	int insertSqlAll(List<Object> beanList);


	/**
	 * delete method
	 * @param bean
	 * @return
	 */
	int deletetSql(Object bean);

	/**
	 * update method
	 * @param bean
	 * @return
	 */
	int updateSql(Object bean);

	/**
	 * update/delete/insert method
	 * @param bean
	 * @return
	 */
	Object resultSql(Object bean);
}
