package com.dyy.a.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlDBConnector {

	// 数据库连接方法
	public static Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager
					.getConnection(
							"jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEnconding=utf-8",
							"root", "123456");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/*
	 * public static void main(String[] args) {
	 * System.out.println(getConnection()); }
	 */

	// 释放数据库的资源
	public static void Release(ResultSet rs, PreparedStatement ps,
			Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
