package com.mzmy.HRManager.actions;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.mzmy.HRManager.model.dao.implDao.ImplDeptDao;
import com.mzmy.HRManager.model.vo.DeptVo;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 对部门所有操作的信息Action
 * 
 * @author mzmy
 *
 */
public class DeptAction extends ActionSupport implements RequestAware{
	//获得对象
	ImplDeptDao deptdao=new ImplDeptDao();
	//定义对象
	private Map<String,Object> request;
	//定义对象
	private DeptVo dept;
	//查询所有部门信息的方法
	public String selAllDeptFun(){
		//调用对象获得数据
		ArrayList<DeptVo> dlist=deptdao.selAllDept();
		//放到请求中
		request.put("dlist",dlist);
		return "selall";
	}
	
	//删除数据
	public String deleteDeptById(){
		//删除数据
	 int i=deptdao.delDeptById(dept.getD_id());
		
		return "showall";
	}
	
	//添加的方法
	public String insertDeptFun(){
		//添加数据
		int i=deptdao.insDept(dept);
		return "showall";
	}
	//分根据id获取一条信息
	public String selOneDeptById(){
		//调用方法获取一条信息
		dept=deptdao.getOneDeptById(dept.getD_id());
		//请求
		request.put("dept", dept);
		return "update";
	}
	
	//修改数据
	public String updateDeptFun(){
		System.out.println("-----"+dept.getD_name());
		//修改数据
		int i=deptdao.updateDeptById(dept);
		 System.out.println("======"+i);
		return "showall";
	}
	//获得请求对象
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}

	public DeptVo getDept() {
		return dept;
	}

	public void setDept(DeptVo dept) {
		this.dept = dept;
	}
	

}
