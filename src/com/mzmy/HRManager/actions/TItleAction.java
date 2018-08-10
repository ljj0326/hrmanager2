package com.mzmy.HRManager.actions;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.mzmy.HRManager.model.dao.implDao.ImplTitleDao;
import com.mzmy.HRManager.model.vo.TitleVo;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 对职位信息控制传递的action类
 * 
 * @author mzmy
 *
 */
public class TItleAction extends ActionSupport implements RequestAware {
	// 获取数据中的数据
	private ImplTitleDao tdao = new ImplTitleDao();
	// 定义请求对象
	private Map<String, Object> request;
	// 属性
	private TitleVo title;

	// 定义删除的方法
	public String deleteTitleFun() {
		// 调用方法删除数据
		int i = tdao.delTitleById(title.getT_id());
		return "showall";
	}

	// 定义删除的方法
	public String updateTitleFun() {
		// 修改数据
		tdao.updateById(title);
		return "showall";
	}

	// 定义删除的方法
	public String selectAllTitleFun() {
		// 调用方法获取数据
		ArrayList<TitleVo> tlist = tdao.selAllTitles();
		// 将数据封装到请求属性
		request.put("tlist", tlist);
		return "selectall";
	}

	// 定义删除的方法
	public String insertTitleFun() {
		//调用方法执行语句
		int i=tdao.insTitle(title);
		return "showall";
	}

	// 定义删除的方法
	public String selByIdTitleFun() {
		// 调用方法获得返回结果
		TitleVo tdata = tdao.selOneTitleById(title.getT_id());
		// 调用方法将数据传递到前台页面
		request.put("tdata", tdata);
		return "selbyid";
	}

	// 获取请求对象
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public TitleVo getTitle() {
		return title;
	}

	public void setTitle(TitleVo title) {
		this.title = title;
	}

}
