package com.mzmy.HRManager.model.dao;

import java.util.ArrayList;

import com.mzmy.HRManager.model.vo.DeptVo;

/**
 * 部门信息操作的dao层接口
 * @author mzmy
 *
 */
public interface InfDeptDao {
	//查询所有的信息
	public ArrayList<DeptVo> selAllDept();
	//删除的方法
	public int delDeptById(int did);
	//插入数据
	public int insDept(DeptVo dept);
	//根据id查询一条信息
	public DeptVo getOneDeptById(int did);
	//修改的方法
	public int updateDeptById(DeptVo dept);

}
