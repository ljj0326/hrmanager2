package com.mzmy.HRManager.model.vo;

import java.sql.Timestamp;

/**
 * 员工信息的实体类
 *   
 * @author mzmy
 *
 */
public class StaffVo {
   //属性
	private int e_id;//E_ID
	private String e_name;//E_NAME
	private String e_mail;//E_MAIL
	private String e_tel;//E_TEL
	private Timestamp e_starttime;//E_STARTTIME
	private int e_titleid;//E_TITLEID
	private double e_salary;//E_SALARY
	private int e_deptid;//E_DEPTID
	
	public int getE_id() {
		return e_id;
	}
	public void setE_id(int e_id) {
		this.e_id = e_id;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getE_mail() {
		return e_mail;
	}
	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}
	public String getE_tel() {
		return e_tel;
	}
	public void setE_tel(String e_tel) {
		this.e_tel = e_tel;
	}
	public Timestamp getE_starttime() {
		return e_starttime;
	}
	public void setE_starttime(Timestamp e_starttime) {
		this.e_starttime = e_starttime;
	}
	
	public int getE_titleid() {
		return e_titleid;
	}
	public void setE_titleid(int e_titleid) {
		this.e_titleid = e_titleid;
	}
	public double getE_salary() {
		return e_salary;
	}
	public void setE_salary(double e_salary) {
		this.e_salary = e_salary;
	}
	public int getE_deptid() {
		return e_deptid;
	}
	public void setE_deptid(int e_deptid) {
		this.e_deptid = e_deptid;
	}
	
	
}
