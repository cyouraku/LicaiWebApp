package com.costuary.sql;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.costuary.bean.LicaiBean;

public class LicaiTblSqlBasicImpl implements SqlBeanInterface {

	private String sql = null;
	private ConnUtil connUtil = null;
	private ResultSet ret = null;
	private List<String> resultSetList = new ArrayList<String>();
	private List<Integer> seqList = new ArrayList<Integer>();

	public LicaiTblSqlBasicImpl(){}

	public void init(){
		this.resultSetList.clear();
	}

	@Override
	public List<String> selectSqlOfAll() {
		init();
		sql = "select * from licai_tbl";
		connUtil = new ConnUtil(sql);
		try {
			ret = connUtil.pst.executeQuery();
			while(ret.next()){
				resultSetList.add(ret.getInt(1) + "\t" + ret.getDate(2) + "\t" + ret.getInt(3) + "\t" + ret.getString(4) + "\t" + ret.getString(5) + "\t" + ret.getFloat(6)+ "\t" + ret.getInt(7));
			}
			ret.close();
			connUtil.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSetList;
	}

	@Override
	public List<Integer> selectSqlOfCertainCol(String param) {

		init();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("select ");
		sqlBuilder.append(param);
		sqlBuilder.append(" from licai_tbl");
		sqlBuilder.append(" order by SEQ");
		sql = sqlBuilder.toString();
		connUtil = new ConnUtil(sql);
		try {
			ret = connUtil.pst.executeQuery();
			while(ret.next()){
				seqList.add(ret.getInt(1));
			}
			ret.close();
			connUtil.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seqList;
	}

	@Override
	public int insertSql(Object bean) {
		sql = "INSERT INTO licai_tbl (`DATE`, `TYPE_ID`, `SUBCAT_ID`, `COMMENT`, `AMT`, `CURRENCY_ID`) VALUES (?,?,?,?,?,?)";
//		bean = (LicaiBean)new LicaiBean();
		Date date;
		int type;
		int subCat;
		String comment;
		float amt;
		int currency;
		int ret = 0;
		if(bean instanceof LicaiBean){
			date = ((LicaiBean) bean).getDate();
			type = ((LicaiBean) bean).getTypeId();
			subCat = ((LicaiBean) bean).getSubCatId();
			comment = ((LicaiBean) bean).getComment();
			amt = ((LicaiBean) bean).getAmt();
			currency = ((LicaiBean) bean).getCurrencyId();
			connUtil = new ConnUtil(sql);
			try {
				connUtil.pst.setDate(1, date);
				connUtil.pst.setInt(2, type);
				connUtil.pst.setInt(3, subCat);
				connUtil.pst.setString(4, comment);
				connUtil.pst.setFloat(5, amt);
				connUtil.pst.setInt(6, currency);
				ret = connUtil.pst.executeUpdate();
				connUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	@Override
	public int deletetSql(Object bean) {
		int result = 0;
		sql = "DELETE from licai_tbl where SEQ = ?";
		if(bean instanceof LicaiBean){
			int seq = ((LicaiBean) bean).getSeq();
			System.out.println(sql);
			connUtil = new ConnUtil(sql);
			try {
				connUtil.pst.setInt(1, seq);
				result = connUtil.pst.executeUpdate();
				connUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int updateSql(Object bean) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public Object resultSql(Object bean) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public int insertSqlAll(List<Object> beanList) {
		int ret = 0;
		int cnt = 0;
		for(Object bean:beanList){
			if(bean instanceof LicaiBean){
				sql = "INSERT INTO licai_tbl (`DATE`, `TYPE_ID`, `SUBCAT_ID`, `COMMENT`, `AMT`, `CURRENCY_ID`) VALUES (?,?,?,?,?,?)";
				Date date = ((LicaiBean) bean).getDate();
				int type = ((LicaiBean) bean).getTypeId();
				int subCat = ((LicaiBean) bean).getSubCatId();
				String comment = ((LicaiBean) bean).getComment();
				float amt = ((LicaiBean) bean).getAmt();
				int currency = ((LicaiBean) bean).getCurrencyId();
				connUtil = new ConnUtil(sql);
				try {
					connUtil.pst.setDate(1, date);
					connUtil.pst.setInt(2, type);
					connUtil.pst.setInt(3, subCat);
					connUtil.pst.setString(4, comment);
					connUtil.pst.setFloat(5, amt);
					connUtil.pst.setInt(6, currency);
					ret = connUtil.pst.executeUpdate();
					if(ret == 1){
						cnt++;
					}
					connUtil.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return cnt;
	}

}
