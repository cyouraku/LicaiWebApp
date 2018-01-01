package com.costuary.dto;

import java.util.List;

public interface SqlDtoBasic {

	/**
	 * Show result of select sql
	 * @param ret
	 * @return
	 */
	String showSelectResult(List<String> resultSetList);

	/**
	 * Show result of select seq
	 * @param ret
	 * @return
	 */
	String showSelectSeqResult(List<Integer> resultSetList);

	/**
	 * Show result of insert sql
	 * @return
	 */
	String showInsertResult(int result);


	/**
	 * Show result of delete sql
	 * @return
	 */
	String showDeleteResult(int result);
}
