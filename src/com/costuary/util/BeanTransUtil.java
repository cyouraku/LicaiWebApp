package com.costuary.util;

import com.costuary.bean.LicaiBean;
import com.costuary.bean.WebInputBean;

public class BeanTransUtil {

	/**
	 * transfer WebInputBean to LicaiBean
	 * @param inputBean
	 * @return
	 */
	public static LicaiBean transinputBeanTolicaiBean (WebInputBean inputBean){
		LicaiBean licaiBean = new LicaiBean();
//		licaiBean.setSeq(Integer.parseInt(inputBean.getSeq()));
//		licaiBean.setDate(DateUtil.getDateFormatted(DateUtil.parseTimeFormat(inputBean.getDate())));//yyyy-mm-dd
		licaiBean.setDate(DateUtil.getDateFormatted(inputBean.getDate()));//yyyy-mm-dd
		licaiBean.setTypeId(Integer.parseInt(inputBean.getTypeId()));
		licaiBean.setSubCatId(Integer.parseInt(inputBean.getSubcatId()));
		licaiBean.setComment(inputBean.getComment());
		licaiBean.setAmt(Integer.parseInt(inputBean.getAmt()));
		licaiBean.setCurrencyId(Integer.parseInt(inputBean.getCurrencyId()));
		return licaiBean;
	}





}
