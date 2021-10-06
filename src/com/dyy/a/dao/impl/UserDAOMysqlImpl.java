package com.dyy.a.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dyy.a.dao.UserDAO;
import com.dyy.a.entity.Customer;
import com.dyy.a.util.MysqlDBConnector;

public class UserDAOMysqlImpl implements UserDAO {

	/**
	 * 单例模式（内部类方式）
	 */
	private static class SingletonHolder {
		public final static UserDAOMysqlImpl instance = new UserDAOMysqlImpl();
	}

	private UserDAOMysqlImpl() {
	}

	public static UserDAOMysqlImpl getInstance() {
		return SingletonHolder.instance;
	}

	@Override
	public Customer Login(Customer cust) {
		Customer customer = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 取得数据库的连接
		conn = MysqlDBConnector.getConnection();


		try {
			ps = conn
					.prepareStatement("select * from customer where custname=? and passwd = ? ");
			ps.setString(1, cust.getCustname());
			ps.setString(2, cust.getPasswd());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer();
				customer.setCustname(rs.getString("custname"));
				customer.setPasswd(rs.getString("passwd"));
				customer.setStatus(rs.getInt("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放数据库的连接
			MysqlDBConnector.Release(rs, ps, conn);

		}

		return customer;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> list = new ArrayList<Customer>();
		Customer customer = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// 取得数据库的连接
		conn = MysqlDBConnector.getConnection();

		try {
			ps = conn
					.prepareStatement("select * from customer");
			ps.setInt(1, 0);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			rs = ps.executeQuery();
			while (rs.next()) {
				customer = new Customer();
				customer.setCustid(rs.getInt("custid"));
				customer.setCustname(rs.getString("custname"));
				customer.setPasswd(rs.getString("passwd"));
				customer.setStatus(rs.getInt("status"));
				list.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放数据库的连接
			MysqlDBConnector.Release(rs, ps, conn);

		}

		return list;
	}

	@Override
	public int selectCustCountByConditions() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int totalCount = 0; // 保存总记录数的变量
		conn = MysqlDBConnector.getConnection();

		try {
			ps = conn
					.prepareStatement("select count(*) from customer");
			ps.setInt(1, 0);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			rs = ps.executeQuery();
			if (rs.next()) {
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlDBConnector.Release(rs, ps, conn);
		}
		return totalCount;
	}

	/**
	 * 设置区间从数据库中查询相关的记录
	 */
	@Override
	public List<Customer> selectCustCountByConditions(int pageNo, int pageSize) {

		List<Customer> list = new ArrayList<Customer>();
		Customer customer = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		conn = MysqlDBConnector.getConnection();
		try {
			ps = conn
					.prepareStatement("select * from customer limit ?,?");
			// 设置分页的两个参数
			ps.setInt(1, 0);
			ps.setInt(2, (pageNo - 1) * pageSize); // 从第几条数据开始查询
			ps.setInt(3, pageSize); // 要查询出几条数据

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			rs = ps.executeQuery();
			while (rs.next()) {
				customer = new Customer();
				customer.setCustid(rs.getInt("custid"));
				customer.setCustname(rs.getString("custname"));
				customer.setPasswd(rs.getString("passwd"));
				customer.setStatus(rs.getInt("status"));
				list.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlDBConnector.Release(rs, ps, conn);
		}

		return list;
	}

	@Override
	public Customer selectOne(int custid) {

		Customer customer = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		conn = MysqlDBConnector.getConnection();
		try {
			ps = conn
					.prepareStatement("select * from customer where custid=?");
			ps.setInt(1, custid);
			ps.setInt(2, 0);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer();
				customer.setCustid(rs.getInt("custid"));
				customer.setCustname(rs.getString("custname"));
				customer.setPasswd(rs.getString("passwd"));
				customer.setStatus(rs.getInt("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlDBConnector.Release(rs, ps, conn);
		}

		return customer;
	}

	@Override
	public int updateCust(Customer cust) {

		int flag = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = MysqlDBConnector.getConnection();
		try {
			ps = conn
					.prepareStatement("update customer set custname =?,passwd = ?,status = ? where custid = ? ");
			// 设置分页的两个参数
			ps.setString(1, cust.getCustname());
			ps.setString(2, cust.getPasswd());
			ps.setInt(3, cust.getStatus());
			ps.setInt(4, cust.getCustid());

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlDBConnector.Release(rs, ps, conn);
		}

		return flag;
	}

	@Override
	public int deleteCust(Customer cust) {
		int flag = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = MysqlDBConnector.getConnection();
		try {
			ps = conn
					.prepareStatement("update customer where custid = ? ");
			ps.setInt(1, 1);
			ps.setInt(2, cust.getCustid());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			flag = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlDBConnector.Release(rs, ps, conn);
		}
		return flag;
	}

	@Override
	public int insertCust(Customer cust) {

		int flag = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = MysqlDBConnector.getConnection();
		try {
			int maxNum = Max();
			ps = conn
					.prepareStatement("insert into customer values(?,?,?,?) ");

			ps.setInt(1, maxNum + 1);
			ps.setString(2, cust.getCustname());
			ps.setString(3, cust.getPasswd());
			ps.setInt(4,1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MysqlDBConnector.Release(rs, ps, conn);
		}
		return flag;
	}

	@Override
	public int Max() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int maxNum = 0; // id最大值

		conn = MysqlDBConnector.getConnection();
		try {
			ps = conn.prepareStatement("select max(custid) from customer");

			rs = ps.executeQuery();
			if (rs.next()) {
				maxNum = rs.getInt(1);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			MysqlDBConnector.Release(rs, ps, conn);
		}
		return maxNum;
	}


	
	

}
