package com.mzmy.HRManager.model.dao.implDao;

import java.sql.*;
import java.util.ArrayList;

import com.mzmy.HRManager.model.dao.InfTitleDao;
import com.mzmy.HRManager.model.vo.TitleVo;
import com.mzmy.HRManager.util.JDBCUtil;

public class ImplTitleDao implements InfTitleDao {

	//定义变量
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	@Override
	public ArrayList<TitleVo> selAllTitles() {
		//定义一个集合存储所有的信息
		ArrayList<TitleVo> list=new ArrayList<TitleVo>();
		try {
			//获得连接对象
			con=JDBCUtil.getConnection();
			//编写sql语句
			String sql="select * from hrm_title";
			//链接对象获得预编译语句对象
			pst=con.prepareStatement(sql);
			//发送语句执行语句，返回结果
			rs=pst.executeQuery();
			//获取数据
			while(rs.next()){
				//实例化对象存储每一条职位信息
				TitleVo tv=new TitleVo();
				tv.setT_id(rs.getInt(1));
				tv.setT_name(rs.getString(2));
				tv.setT_minsalary(rs.getDouble(3));
				tv.setT_maxsalary(rs.getDouble(4));
				
				//将该对象存储到集合中
				list.add(tv);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭
			JDBCUtil.close(con, pst, rs);
		}
		//返回数据
		return list;
		
	}
	
	//删除数据
	@Override
	public int delTitleById(int tid) {
		//定义变量
		int i=0;
		try {
			//获得链接对象
			con=JDBCUtil.getConnection();
			//编写slq语句
			String sql="delete from hrm_title where t_id=?";
			//获得预编译语句对象设置参数
			pst=con.prepareStatement(sql);
			//设置参数
			pst.setInt(1, tid);
			//发送执行语句返回结果
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(con, pst, rs);
		}
		return i;
	}

	//添加数据
	@Override
	public int insTitle(TitleVo tv) {
		//定义变量
		int i=0;
		try {
			//获得链接对象
			con=JDBCUtil.getConnection();
			//编写sql语句
			String sql="insert into hrm_title values(sep_title.nextval,?,?,?)";
			//获得预编译语句处理语句
			pst=con.prepareStatement(sql);
			//设置参数
			pst.setString(1, tv.getT_name());
			pst.setDouble(2, tv.getT_minsalary());
			pst.setDouble(3, tv.getT_maxsalary());
			//发送执行语句
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭
			JDBCUtil.close(con, pst, rs);
		}
		return i;
	}

	//通过id查询数据
	@Override
	public TitleVo selOneTitleById(int tid) {
		//创建对象
		TitleVo tv=new TitleVo();
		try {
			//获得链接对象
			con=JDBCUtil.getConnection();
			//编写sql语句
			String sql="select * from hrm_title where t_id=?";
			//获得预编译语句语句对象编辑语句
			pst=con.prepareStatement(sql);
			//设置参数
			pst.setInt(1, tid);
			//发送执行语句
			rs=pst.executeQuery();
			//获取数据
			while(rs.next()){
				tv.setT_id(rs.getInt(1));
				tv.setT_name(rs.getString(2));
				tv.setT_minsalary(rs.getDouble(3));
				tv.setT_maxsalary(rs.getDouble(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(con, pst, rs);
		}
		return tv;
	}

	//修改数据
	@Override
	public int updateById(TitleVo tv) {
		//定义变量
		int i=0;
		try {
			//获得链接对象
			con=JDBCUtil.getConnection();
			//编写sql语句
			String sql="update hrm_title set t_name=?,t_maxsalary=?,t_minsalary=? where t_id=?";
			pst=con.prepareStatement(sql);
			//设置参数
			pst.setString(1, tv.getT_name());
			pst.setDouble(2,tv.getT_maxsalary());
			pst.setDouble(3,tv.getT_minsalary());
			pst.setInt(4,tv.getT_id());
			//执行语句
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCUtil.close(con, pst, rs);
		}
		return i;
	}

}
