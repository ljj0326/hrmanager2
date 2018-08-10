package com.mzmy.HRManager.actions;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.mzmy.HRManager.model.dao.implDao.ImplDeptDao;
import com.mzmy.HRManager.model.dao.implDao.ImplStaffDao;
import com.mzmy.HRManager.model.dao.implDao.ImplTitleDao;
import com.mzmy.HRManager.model.vo.DeptVo;
import com.mzmy.HRManager.model.vo.StaffVo;
import com.mzmy.HRManager.model.vo.TitleVo;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 对于员工信息处理的action类
 * @author mzmy
 *
 */
public class StaffAction  extends ActionSupport implements RequestAware {

	// 获取数据中的数据
	private ImplStaffDao edao = new ImplStaffDao();
	// 定义请求对象
	private Map<String, Object> request;
	// 属性
	private StaffVo staff;

	// 定义删除的方法
	public String deleteStaffFun() {
		// 调用方法删除数据
		int i = edao.delStaffById(staff.getE_id());
		return "showall";
	}

	// 定义删除的方法
	public String updateStaffFun() {
		// 修改数据
		edao.updateById(staff);
		return "showall";
	}

	// 定义删除的方法
	public String selectAllStaffeFun() {
		// 调用方法获取数据
		ArrayList<StaffVo> elist = edao.selAllStaffs();
		// 将数据封装到请求属性
		request.put("elist",elist);
		System.out.println("=============="+elist.size());
		return "selall";
	}

	// 定义删除的方法
	public String insertStaffFun() {
		//调用方法执行语句
		int i=edao.insStaff(staff);
		return "showall";
	}

	// 定义删除的方法
	public String selByIdStaffFun() {
		//部门信息
		ArrayList<DeptVo> dlist=new ImplDeptDao().selAllDept();
		ArrayList<TitleVo> tlist=new ImplTitleDao().selAllTitles();
		// 调用方法获得返回结果
		staff=edao.selOneStaffById(staff.getE_id());
		// 调用方法将数据传递到前台页面
		request.put("dlist", dlist);
		request.put("tlist", tlist);
		request.put("staff", staff);
		return "update";
	}

	//下拉框的页面
	public String addPage(){
		//部门信息
		ArrayList<DeptVo> dlist=new ImplDeptDao().selAllDept();
		ArrayList<TitleVo> tlist=new ImplTitleDao().selAllTitles();
		request.put("dlist", dlist);
		request.put("tlist", tlist);
		return "add";
	}
	// 获取请求对象
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public StaffVo getStaff() {
		return staff;
	}

	public void setStaff(StaffVo staff) {
		this.staff = staff;
	}
	
}
