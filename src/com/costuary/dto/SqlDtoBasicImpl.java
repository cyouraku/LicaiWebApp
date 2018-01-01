package com.costuary.dto;

import java.util.List;

public class SqlDtoBasicImpl implements SqlDtoBasic {

	@Override
	public String showSelectResult(List<String> resultSetList) {
		StringBuilder sb = new StringBuilder();
		for (String str : resultSetList) {
			sb.append(str);
			sb.append("\n");
		}
		return sb.toString();
	}

	@Override
	public String showInsertResult(int result) {
		String temp = "";
		if(result == 1){
			temp = result + " row inserted!";
		}else{
			temp = "nothing inserted!";
		}
		return temp;
	}

	@Override
	public String showDeleteResult(int result) {
		String temp = "";
		if(result == 0){
			temp = "nothing happened";
		}else if(result == 1){
			temp = result + " row deleted!";
		}else if(result > 1){
			temp = result + " rows deleted!";
		}
		return temp;
	}

	@Override
	public String showSelectSeqResult(List<Integer> resultSetList) {
		StringBuilder sb = new StringBuilder();
		for (int seq : resultSetList) {
			sb.append(seq);
			sb.append("\n");
		}
		return sb.toString();
	}

}
