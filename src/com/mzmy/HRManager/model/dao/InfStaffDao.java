package com.mzmy.HRManager.model.dao;

import java.util.ArrayList;

import com.mzmy.HRManager.model.vo.StaffVo;

/**
 * 员工操作方法的接口
 * 
 * @author mzmy
 *
 */
public interface InfStaffDao {
	//查询所有的数据的方法
		public ArrayList<StaffVo> selAllStaffs();
		//删除数据
		public int delStaffById(int tid);
		//添加数据的方法
		public int insStaff(StaffVo sv);
		//查询一条信息通过id
		public StaffVo  selOneStaffById(int tid);
		//修改数据
		public int updateById(StaffVo sv);
}
