package com.mzmy.HRManager.actions;

import com.mzmy.HRManager.model.dao.implDao.AdminDao;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {
	private String uname;
	private String upassw;

	// 登陆的方法
	public String loginFun() {
		// 输出
		System.out.println(uname + "---" + upassw);
		String str="";
		// 去数据查询数据
		boolean flag = new AdminDao().selLogin(uname, upassw);
		// 登陆成功的判断
		if (flag) {
			str="index";
		} else {
			//struts的校验
			this.addFieldError("msg", "账号或者密码有误");
			str="error";
		}
        //返回
		return str;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpassw() {
		return upassw;
	}

	public void setUpassw(String passw) {
		this.upassw = passw;
	}

}
