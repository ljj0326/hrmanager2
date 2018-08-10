package com.mzmy.HRManager.model.vo;
/**
 * 此类适用于描述职位的属性的信息
 * 
 * @author mzmy
 *
 */
public class TitleVo {
	private int t_id;//职位编号
	private String t_name;//职位名字
	private double t_minsalary;//最低工资
	private double t_maxsalary;//最高工资
	
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getT_name() {
		return t_name;
	}
	public void setT_name(String t_name) {
		this.t_name = t_name;
	}
	public double getT_minsalary() {
		return t_minsalary;
	}
	public void setT_minsalary(double t_minsalary) {
		this.t_minsalary = t_minsalary;
	}
	public double getT_maxsalary() {
		return t_maxsalary;
	}
	public void setT_maxsalary(double t_maxsalary) {
		this.t_maxsalary = t_maxsalary;
	}
	
	

}
