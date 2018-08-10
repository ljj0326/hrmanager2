package com.mzmy.HRManager.model.dao.implDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mzmy.HRManager.model.dao.InfDeptDao;
import com.mzmy.HRManager.model.vo.DeptVo;
import com.mzmy.HRManager.model.vo.TitleVo;
import com.mzmy.HRManager.util.JDBCUtil;

/**
 * JDBC操作的实现类
 * 
 * @author mzmy
 *
 */
public class ImplDeptDao implements InfDeptDao {
	// 定义变量
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	@Override
	public ArrayList<DeptVo> selAllDept() {
		// 定义一个集合存储所有的信息
		ArrayList<DeptVo> list = new ArrayList<DeptVo>();
		try {
			// 获得连接对象
			con = JDBCUtil.getConnection();
			// 编写sql语句
			String sql = "select * from hrm_dept";
			// 链接对象获得预编译语句对象
			pst = con.prepareStatement(sql);
			// 发送语句执行语句，返回结果
			rs = pst.executeQuery();
			// 获取数据
			while (rs.next()) {
				// 实例化对象存储每一条职位信息
				DeptVo dv = new DeptVo();
				dv.setD_id(rs.getInt(1));
				dv.setD_name(rs.getString(2));
				dv.setD_addr(rs.getString(3));
				// 将该对象存储到集合中
				list.add(dv);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭
			JDBCUtil.close(con, pst, rs);
		}
		// 返回数据
		return list;
	}

	@Override
	public int delDeptById(int did) {
		int i = 0;
		try {
			// 获得连接对象
			con = JDBCUtil.getConnection();
			// 编写sql语句
			String sql = "delete from hrm_dept where d_id=?";
			// 链接对象获得预编译语句对象
			pst = con.prepareStatement(sql);
			//设置参数
			pst.setInt(1, did);
			// 发送语句执行语句，返回结果
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭
			JDBCUtil.close(con, pst, rs);
		}
		// 返回数据
		return i;
	}

	//添加信息的方法
	@Override
	public int insDept(DeptVo dept) {
		int i = 0;
		try {
			// 获得连接对象
			con = JDBCUtil.getConnection();
			// 编写sql语句
			String sql = "insert into hrm_dept values(sep_dept.nextval,?,?)";
			// 链接对象获得预编译语句对象
			pst = con.prepareStatement(sql);
			//设置参数
			pst.setString(1, dept.getD_name());
			pst.setString(2, dept.getD_addr());
			// 发送语句执行语句，返回结果
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭
			JDBCUtil.close(con, pst, rs);
		}
		// 返回数据
		return i;
	}

	@Override
	public DeptVo getOneDeptById(int did) {
		// 定义一个duixiang存储所有的信息
		DeptVo dv = new DeptVo();
				try {
					// 获得连接对象
					con = JDBCUtil.getConnection();
					// 编写sql语句
					String sql = "select * from hrm_dept where d_id=?";
					// 链接对象获得预编译语句对象
					pst = con.prepareStatement(sql);
					//设置参数
					pst.setInt(1, did);
					// 发送语句执行语句，返回结果
					rs = pst.executeQuery();
					// 获取数据
					while (rs.next()) {
						// 实例化对象存储每一条职位信息
						dv.setD_id(rs.getInt(1));
						dv.setD_name(rs.getString(2));
						dv.setD_addr(rs.getString(3));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					// 关闭
					JDBCUtil.close(con, pst, rs);
				}
				// 返回数据
				return dv;
	}

	@Override
	public int updateDeptById(DeptVo dept) {
		int i = 0;
		try {
			// 获得连接对象
			con = JDBCUtil.getConnection();
			// 编写sql语句
			String sql = "update hrm_dept set d_name=?,d_addr=? where d_id=?";
			// 链接对象获得预编译语句对象
			pst = con.prepareStatement(sql);
			//设置参数
			pst.setString(1, dept.getD_name());
			pst.setString(2, dept.getD_addr());
			pst.setInt(3, dept.getD_id());
			// 发送语句执行语句，返回结果
			i=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭
			JDBCUtil.close(con, pst, rs);
		}
		// 返回数据
		return i;
	}
	
	

}
