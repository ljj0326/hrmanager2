package com.mzmy.HRManager.model.dao;

import java.util.ArrayList;

import com.mzmy.HRManager.model.vo.TitleVo;

/**
 * 用于定义职位相关的数据库操作的方法
 * @author mzmy
 *
 */
public interface InfTitleDao {
	//查询所有的数据的方法
	public ArrayList<TitleVo> selAllTitles();
	//删除数据
	public int delTitleById(int tid);
	//添加数据的方法
	public int insTitle(TitleVo tv);
	//查询一条信息通过id
	public TitleVo  selOneTitleById(int tid);
	//修改数据
	public int updateById(TitleVo tv);

}
