package com.costuary.util;

import java.util.List;

import com.costuary.bean.LicaiBean;

public interface IJsonStrCreator {

	/**
	 *create json string
	 * @return
	 */
	String creatJsonStr(LicaiBean bean);

	/**
	 *create json string with null info
	 * @return
	 */
	String creatJsonStrNull();

	/**
	 *create json string[]
	 * @return
	 */
	String[] creatJsonStrList(List<LicaiBean> beanList);

}
