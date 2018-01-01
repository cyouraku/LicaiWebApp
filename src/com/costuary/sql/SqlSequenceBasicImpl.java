package com.costuary.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.costuary.util.DateUtil;

public class SqlSequenceBasicImpl implements SqlSequeceBasic {

	private String sql = null;
	private ConnUtil connUtil = null;
	private ResultSet ret = null;
	private int currentVal = 0;
	private Timestamp timestamp = null;

	public SqlSequenceBasicImpl(){}

	public void init(){
		this.currentVal = 0;
	}

	@Override
	public int selectSqlOfCertainCol(String tableName) {
		synchronized(this){
			try {
				init();
				sql = "select CURRENT_VAL from Costuary.Sequence where TBL_NM = ?";
				connUtil = new ConnUtil(sql);
				try {
					connUtil.pst.setString(1, tableName);
					ret = connUtil.pst.executeQuery();
					while(ret.next()){
						currentVal = ret.getInt(1);
					}
					ret.close();
					connUtil.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		return currentVal;
	}

	@Override
	public int updateSql(String tableName) {
		int result = 0;
		synchronized(this){
			sql = "UPDATE Costuary.Sequence SET CURRENT_VAL = CURRENT_VAL + 1,TIME_STAMP = ? where TBL_NM = ?";
//			sql = "UPDATE Costuary.Sequence (CURRENT_VAL,TIME_STAMP) VALUES (CURRENT_VAL + 1,?) WHERE TBL_NM = ?";
			connUtil = new ConnUtil(sql);
			try {
				connUtil.pst.setTimestamp(1, DateUtil.getTimestamp());
				connUtil.pst.setString(2, tableName);
				result = connUtil.pst.executeUpdate();
				connUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int resetCurrentValSql(String tableName) {
		int result = 0;
		synchronized(this){
			sql = "UPDATE Costuary.Sequence SET CURRENT_VAL = default WHERE TBL_NM = ?";
			System.out.println("Debug: " + sql);
			connUtil = new ConnUtil(sql);
			try {
				connUtil.pst.setString(1, tableName);
				result = connUtil.pst.executeUpdate();
				connUtil.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public Object selectSqlOfAnyCol(String tableName) {
		synchronized(this){
			try {
				init();
				sql = "select TIME_STAMP from Costuary.Sequence where TBL_NM = ?";
				connUtil = new ConnUtil(sql);
				try {
					connUtil.pst.setString(1, tableName);
					ret = connUtil.pst.executeQuery();
					while(ret.next()){
						 timestamp  = ret.getTimestamp(1);
					}
					ret.close();
					connUtil.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
		return  timestamp ;
	}
}
