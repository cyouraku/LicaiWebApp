package com.costuary.util;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.costuary.bean.LicaiBean;
import com.costuary.bean.WebInputBean;
import com.costuary.sql.ConnUtil;

public class LicaiSqlUtil {

	static String sql = null;
	static ConnUtil connUtil = null;
	static ResultSet ret= null;


	/**
	 * 查看查询结果
	 * @param bean
	 * @param toDate
	 * @return
	 */
	public static List<LicaiBean> selectMenuSql(WebInputBean bean,String toDate) {
		List<LicaiBean> resultSetList = new ArrayList<LicaiBean>();
		String sql = "";

		StringBuilder sb = new StringBuilder();
		String subCatId = bean.getSubcatId();
		if("".equals(toDate)){
			//SELECT * FROM Costuary.licai_tbl where CURRENCY_ID = 102 and TYPE_ID = 1 and DATE = ?frDate and SUBCAT_ID = ?subCatID and comment like %?comment%;
			sb.append("SELECT * FROM Costuary.licai_tbl where CURRENCY_ID = " + bean.getCurrencyId() + " ");
			sb.append("and TYPE_ID = '" + bean.getTypeId() + "' ");
			sb.append("and DATE = '" + bean.getDate() + "' ");
			if(!"".equals(subCatId)){
				sb.append("and SUBCAT_ID = " + bean.getSubcatId() + " ");
			}
			sb.append("and comment like '%" + bean.getComment() + "%' order by DATE desc");
			sql = sb.toString();
		}else if("".equals(subCatId)){
			//SELECT * FROM Costuary.licai_tbl where CURRENCY_ID = 102 and TYPE_ID = 1 and DATE >= ?frDate and DATE <= ?toDate and comment like %?comment%;
			sb.append("SELECT * FROM Costuary.licai_tbl where CURRENCY_ID = " + bean.getCurrencyId() + " ");
			sb.append("and TYPE_ID = '" + bean.getTypeId() + "' ");
			if(!"".equals(toDate)){
				sb.append("and DATE >= '" + bean.getDate() + "' ");
				sb.append("and DATE <= '" + toDate + "' ");
			}else{
				sb.append("and DATE = '" + bean.getDate() + "' ");
			}
			sb.append("and comment like '%" + bean.getComment() + "%' order by DATE desc");
			sql = sb.toString();
		}

//		else if("".equals(toDate) && "".equals(bean.getSubcatId())){
//			//SELECT * FROM Costuary.licai_tbl where CURRENCY_ID = 102 and TYPE_ID = 1 and DATE = '2017-08-12' and comment like '%?comment%';
//			sb.append("SELECT * FROM Costuary.licai_tbl where CURRENCY_ID = 102 ");
//			sb.append("and DATE = '" + bean.getDate() + "' ");
//			sb.append("and comment like '%" + bean.getComment() + "%'");
//			sql = sb.toString();
//		}

		else{
			//SELECT * FROM Costuary.licai_tbl where CURRENCY_ID = 102 and TYPE_ID = 1 and DATE >= ?frDate and DATE <= ?toDate and SUBCAT_ID = ?subCatID and comment like %?comment%;
			sb.append("SELECT * FROM Costuary.licai_tbl where CURRENCY_ID = " + bean.getCurrencyId() + " ");
			sb.append("and TYPE_ID = '" + bean.getTypeId() + "' ");
			sb.append("and DATE >= '" + bean.getDate() + "' ");
			sb.append("and DATE <= '" + toDate + "' ");
			sb.append("and SUBCAT_ID = " + bean.getSubcatId() + " ");
			sb.append("and comment like '%" + bean.getComment() + "%' order by DATE desc");
			sql = sb.toString();
		}
		//Debug:
		System.out.println(sql);
		connUtil = new ConnUtil(sql);
		try {
			ret = connUtil.pst.executeQuery();
			while(ret.next()){
				LicaiBean resultBean = new LicaiBean();
				resultBean.setSeq(ret.getInt(1));
				resultBean.setDate(ret.getDate(2));
				resultBean.setTypeId(ret.getInt(3));
				resultBean.setSubCatId(ret.getInt(4));
				resultBean.setAmt(ret.getFloat(5));
				resultBean.setCurrencyId(ret.getInt(6));
				resultBean.setComment(ret.getString(7));
				resultSetList.add(resultBean);
			}
			ret.close();
			connUtil.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSetList;
	}

	/**
	 * 查看年度，季度，月度，每周统计报告
	 * @param bean
	 * @param toDate
	 * @return
	 */
	public static List<LicaiBean> reportMenuSql(WebInputBean bean,String toDate) {
		List<LicaiBean> resultSetList = new ArrayList<LicaiBean>();
		String sql = "";

		StringBuilder sb = new StringBuilder();
		//SELECT SUBCAT_ID,SUM(AMT) as Total_AMT FROM Costuary.licai_tbl where CURRENCY_ID = 102 and TYPE_ID = 1 and DATE >= '2017-08-01' and DATE <= '2017-08-31' group by SUBCAT_ID;
//		sb.append("SELECT SUBCAT_ID,SUM(AMT) FROM Costuary.licai_tbl where CURRENCY_ID = " + bean.getCurrencyId() + " ");
//		sb.append("and TYPE_ID = '" + bean.getTypeId() + "' ");
//		sb.append("and DATE >= '" + bean.getDate() + "' ");
//		sb.append("and DATE < '" + toDate + "' ");
//		sb.append("group by SUBCAT_ID");
//		sql = sb.toString();

		if("".equals(toDate)){
			sb.append("SELECT SUBCAT_ID,SUM(AMT) FROM Costuary.licai_tbl where CURRENCY_ID = " + bean.getCurrencyId() + " ");
			sb.append("and TYPE_ID = '" + bean.getTypeId() + "' ");
			sb.append("and DATE = '" + bean.getDate() + "' ");
			sb.append("group by SUBCAT_ID");
		}else{
			sb.append("SELECT SUBCAT_ID,SUM(AMT) FROM Costuary.licai_tbl where CURRENCY_ID = " + bean.getCurrencyId() + " ");
			sb.append("and TYPE_ID = '" + bean.getTypeId() + "' ");
			sb.append("and DATE >= '" + bean.getDate() + "' ");
			sb.append("and DATE < '" + toDate + "' ");
			sb.append("group by SUBCAT_ID");
		}
		sql = sb.toString();
		//Debug:
		System.out.println(sql);
		connUtil = new ConnUtil(sql);
		try {
			ret = connUtil.pst.executeQuery();
			while(ret.next()){
				LicaiBean resultBean = new LicaiBean();
				resultBean.setSubCatId(ret.getInt("SUBCAT_ID"));
				resultBean.setAmt(ret.getFloat("SUM(AMT)"));
				resultSetList.add(resultBean);
			}
			ret.close();
			connUtil.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSetList;
	}

	/**
	 * select all from licai_tbl table
	 * @return
	 */
	public static String selectSqlOfLicai(){
		sql = "select * from licai_tbl order by SEQ desc limit 10";
		connUtil = new ConnUtil(sql);
		StringBuilder sb = new StringBuilder();
		try {
			ret = connUtil.pst.executeQuery();
			while(ret.next()){
				sb.append(ret.getInt(1) + "\t" + ret.getDate(2) + "\t" + ret.getInt(3) + "\t" + ret.getInt(4) + "\t" + ret.getFloat(5) + "\t" + ret.getInt(6)+ "\t" + ret.getString(7));
				sb.append("\n");
			}
			ret.close();
			connUtil.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * select certain cols from licai_tbl table
	 * @return
	 */
	public static String selectSqlOfLicai(String param){
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select ");
		sqlBuilder.append(param);
		sqlBuilder.append(" from licai_tbl");
//		sql = "select ? from licai_tbl";
		sql = sqlBuilder.toString();
		System.out.println("Debug: " + sql);
		connUtil = new ConnUtil(sql);
		StringBuilder sb = new StringBuilder();
		try {
			ret = connUtil.pst.executeQuery();
			while(ret.next()){
				sb.append(ret.getString(1));
				sb.append("\n");
			}
			ret.close();
			connUtil.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * insert into from licai_tbl table
	 * @return
	 */
	public static void insertSqlOfLicai(LicaiBean bean){
//		sql = "INSERT INTO licai_tbl (`SEQ`, `DATE`, `TYPE`, `SUBCAT`, `COMMENT`, `AMT`, `CURRENCY`) VALUES (?,?,?,?,?,?,?)";
		sql = "INSERT INTO licai_tbl (`DATE`, `TYPE`, `SUBCAT`, `COMMENT`, `AMT`, `CURRENCY`) VALUES (?,?,?,?,?,?)";
//		int seq = bean.getSeq();
		Date date = bean.getDate();
		int type = bean.getTypeId();
		int subCat = bean.getSubCatId();
		String comment = bean.getComment();
		float amt = bean.getAmt();
		int currency = bean.getCurrencyId();
		System.out.println(sql);
		connUtil = new ConnUtil(sql);
		try {
//			connUtil.pst.setInt(1, seq);
			connUtil.pst.setDate(2, date);
			connUtil.pst.setInt(3, type);
			connUtil.pst.setInt(4, subCat);
			connUtil.pst.setString(5, comment);
			connUtil.pst.setFloat(6, amt);
			connUtil.pst.setInt(7, currency);
			int ret = connUtil.pst.executeUpdate();
			if(ret>0){
				System.out.println(ret + " row(s) inserted!");
			}
			connUtil.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * delete from Income table
	 * @return
	 */
	public static void deletetSqlOfLicai(LicaiBean bean){
		sql = "DELETE from licai_tbl where SEQ = ?";
		int seq = bean.getSeq();
		System.out.println(sql);
		connUtil = new ConnUtil(sql);
		try {
			connUtil.pst.setInt(1, seq);
			int ret = connUtil.pst.executeUpdate();
			if(ret>0){
				System.out.println(ret + " row(s) deleted!");
			}
			connUtil.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
