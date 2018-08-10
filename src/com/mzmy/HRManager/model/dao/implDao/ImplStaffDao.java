package com.mzmy.HRManager.model.dao.implDao;

import java.sql.*;
import java.util.ArrayList;

import com.mzmy.HRManager.model.dao.InfStaffDao;
import com.mzmy.HRManager.model.vo.StaffVo;
import com.mzmy.HRManager.util.JDBCUtil;
/**
 * 员工的数据信息的dao层
 * 
 * @author mzmy
 *
 */
public class ImplStaffDao implements InfStaffDao {

	//定义变量
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	@Override
	public ArrayList<StaffVo> selAllStaffs() {
		//定义一个集合存储所有的信息
		ArrayList<StaffVo> list=new ArrayList<StaffVo>();
		try {
			//获得连接对象
			con=JDBCUtil.getConnection();
			//编写sql语句
			String sql="select * from hrm_emp";
			//链接对象获得预编译语句对象
			pst=con.prepareStatement(sql);
			//发送语句执行语句，返回结果
			rs=pst.executeQuery();
			//获取数据
			while(rs.next()){
				//实例化对象存储每一条职位信息
				StaffVo tv=new StaffVo();
				tv.setE_id(rs.getInt(1));
				tv.setE_name(rs.getString(2));
				tv.setE_mail(rs.getString(3));
				tv.setE_tel(rs.getString(4));
				tv.setE_starttime(rs.getTimestamp(5));
				tv.setE_titleid(rs.getInt(6));
				tv.setE_salary(rs.getDouble(7));
				tv.setE_deptid(rs.getInt(8));
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
	public int delStaffById(int tid) {
		//定义变量
		int i=0;
		try {
			//获得链接对象
			con=JDBCUtil.getConnection();
			//编写slq语句
			String sql="delete from hrm_emp where e_id=?";
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
	public int insStaff(StaffVo tv) {
		//定义变量
		int i=0;
		try {
			//获得链接对象
			con=JDBCUtil.getConnection();
			//编写sql语句
			String sql="insert into hrm_emp values(sep_emp.nextval,?,?,?,?,?,?,?)";
			//获得预编译语句处理语句
			pst=con.prepareStatement(sql);
			//设置参数
			pst.setString(1, tv.getE_name());
			pst.setString(2, tv.getE_mail());
			pst.setString(3, tv.getE_tel());
			pst.setTimestamp(4, tv.getE_starttime());
			pst.setInt(5, tv.getE_titleid());
			pst.setDouble(6, tv.getE_salary());
			pst.setInt(7, tv.getE_deptid());
			
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
	public StaffVo selOneStaffById(int tid) {
		//创建对象
		StaffVo tv=new StaffVo();
		try {
			//获得链接对象
			con=JDBCUtil.getConnection();
			//编写sql语句
			String sql="select * from hrm_emp where e_id=?";
			//获得预编译语句语句对象编辑语句
			pst=con.prepareStatement(sql);
			//设置参数
			pst.setInt(1, tid);
			//发送执行语句
			rs=pst.executeQuery();
			//获取数据
			while(rs.next()){
				tv.setE_id(rs.getInt(1));
				tv.setE_name(rs.getString(2));
				tv.setE_mail(rs.getString(3));
				tv.setE_tel(rs.getString(4));
				tv.setE_starttime(rs.getTimestamp(5));
				tv.setE_titleid(rs.getInt(6));
				tv.setE_salary(rs.getDouble(7));
				tv.setE_deptid(rs.getInt(8));
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
	public int updateById(StaffVo tv) {
		//定义变量
		int i=0;
		try {
			//获得链接对象
			con=JDBCUtil.getConnection();
			//编写sql语句
			String sql="update hrm_emp set e_name=?,e_mail=?,e_tel=?,e_starttime=?,e_titleid=?,e_salary=?,e_deptid=? where e_id=?";
			pst=con.prepareStatement(sql);
			//设置参数
			pst.setString(1, tv.getE_name());
			pst.setString(2, tv.getE_mail());
			pst.setString(3, tv.getE_tel());
			pst.setTimestamp(4, tv.getE_starttime());
			pst.setInt(5, tv.getE_titleid());
			pst.setDouble(6, tv.getE_salary());
			pst.setInt(7, tv.getE_deptid());
			pst.setInt(8, tv.getE_id());
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
