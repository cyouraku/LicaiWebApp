package com.costuary.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.costuary.bean.ServerHealthInfoBean;
import com.costuary.util.DateUtil;

public class H515sTblSqlBasicImpl implements SqlBeanInterface {

	private String sql = null;
	private ConnUtil connUtil = null;
	private ResultSet ret = null;
	private ServerHealthInfoBean resultBean = null;
	private List<String> resultSetList = new ArrayList<String>();
	private List<Integer> seqList = new ArrayList<Integer>();
	private List<ServerHealthInfoBean> resultBeanList = new ArrayList<ServerHealthInfoBean>();

	public H515sTblSqlBasicImpl(){}

	public void init(){
		this.resultSetList.clear();
		this.resultBeanList.clear();
	}

	@Override
	public List<String> selectSqlOfAll() {
		init();
		sql = "SELECT * FROM lenovo_h515s_temprature ORDER BY RECORD_TIME DESC LIMIT 1";
		connUtil = new ConnUtil(sql);
		try {
			ret = connUtil.pst.executeQuery();
			resultBean = new ServerHealthInfoBean();
			while(ret.next()){
				resultSetList.add(ret.getInt(1) + "\t" + ret.getFloat(2) + "\t" + ret.getFloat(3) + "\t" + ret.getInt(4) + "\t" + ret.getTimestamp(5) );
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
		return seqList;
	}

	@Override
	public int insertSql(Object bean) {
		sql = "INSERT INTO lenovo_h515s_temprature (`RADEON_PCI_0008`, `K10TEMP_PCI_00C3`, `CPU_FAN_RPM`) VALUES (?,?,?)";
		String GpuTmp;
		String CpuTmp;
		String FanSpeed;
		int ret = 0;
		if(bean instanceof ServerHealthInfoBean){
			GpuTmp = ((ServerHealthInfoBean)bean).getGpu_temperature();
			CpuTmp  = ((ServerHealthInfoBean)bean).getCpu_teperature();
			FanSpeed = ((ServerHealthInfoBean)bean).getFan_speed();
			connUtil = new ConnUtil(sql);
			try {
				connUtil.pst.setFloat(1, Float.parseFloat(GpuTmp));
				connUtil.pst.setFloat(2, Float.parseFloat(CpuTmp));
				connUtil.pst.setInt(3, Integer.parseInt(FanSpeed));
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
		return result;
	}

	@Override
	public int updateSql(Object bean) {
		return 0;
	}


	/*
	 * Add method, select latest one record from lenovo_h515s_temprature
	 * @see com.costuary.sql.SqlBeanInterface#selectSqlOfAll()
	 */
	@Override
	public Object resultSql(Object bean) {
		sql = "SELECT * FROM lenovo_h515s_temprature ORDER BY RECORD_TIME DESC LIMIT 1";
		connUtil = new ConnUtil(sql);
		resultBean = new ServerHealthInfoBean();
		try {
			ret = connUtil.pst.executeQuery();
			while(ret.next()){
				resultBean.setRecord_id(Integer.toString(ret.getInt(1)));
				resultBean.setGpu_temperature(Float.toString(ret.getFloat(2)));
				resultBean.setCpu_teperature(Float.toString(ret.getFloat(3)));
				resultBean.setFan_speed(Integer.toString(ret.getInt(4)));
				//Parse sql.timestamp.getTime() to java.util.Date and then set to "Asia/Tokyo" timezone and save as String
				String dateStrTmp = DateUtil.parseTimeFormat(ret.getTimestamp(5));
				resultBean.setRecord_timeStamp(dateStrTmp);
			}
			ret.close();
			connUtil.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public int insertSqlAll(List<Object> beanList) {
		int cnt = 0;
		return cnt;
	}

}
